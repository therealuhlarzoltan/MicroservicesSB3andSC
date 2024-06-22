package hu.therealuhlarzoltan.microservices.core.product.services;

import hu.therealuhlarzoltan.microservices.core.product.persistence.ProductEntity;
import hu.therealuhlarzoltan.microservices.core.product.persistence.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.RestController;
import hu.therealuhlarzoltan.api.core.product.Product;
import hu.therealuhlarzoltan.api.core.product.ProductService;
import hu.therealuhlarzoltan.api.exceptions.InvalidInputException;
import hu.therealuhlarzoltan.api.exceptions.NotFoundException;
import hu.therealuhlarzoltan.util.http.ServiceUtil;

@RestController
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private static final Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository repository;
    private final ProductMapper mapper;
    private final ServiceUtil serviceUtil;

    @Override
    public Product getProduct(int productId) {
        if (productId < 1)
            throw new InvalidInputException("Invalid productId: " + productId);
        ProductEntity entity = repository.findByProductId(productId)
                .orElseThrow(
                        () -> new NotFoundException("No product found for productId: " + productId));
        Product response = mapper.entityToApi(entity);
        response.setServiceAddress(serviceUtil.getServiceAddress());
        return response;
    }


    @Override
    public Product createProduct(Product body) {
        try {
            ProductEntity entity = mapper.apiToEntity(body);
            ProductEntity newEntity = repository.save(entity);
            return mapper.entityToApi(newEntity);
        } catch (DuplicateKeyException dke) {
            throw new InvalidInputException("Duplicate key, Product Id: " +
                    body.getProductId());
        }
    }

    @Override
    public void deleteProduct(int productId) {
        repository.findByProductId(productId).ifPresent(e -> repository.delete(e));
    }
}