package hu.therealuhlarzoltan.api.core.product;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import org.springframework.web.bind.annotation.RequestParam;

public interface ProductService {

    @GetMapping(value = "/product/{productId}", produces = "application/json")
    Mono<Product> getProduct(
            @PathVariable int productId,
            @RequestParam(value = "delay", required = false, defaultValue = "0") int delay,
            @RequestParam(value = "faultPercent", required = false, defaultValue = "0") int faultPercent
    );


    @PostMapping(
            value = "/product",
            consumes = "application/json",
            produces = "application/json")
    Mono<Product> createProduct(@RequestBody Product body);
    @DeleteMapping(value = "/product/{productId}")
    Mono<Void> deleteProduct(@PathVariable int productId);

}
