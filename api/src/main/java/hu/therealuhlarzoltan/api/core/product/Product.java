package hu.therealuhlarzoltan.api.core.product;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Product {
    private int productId;
    private String name;
    private int weight;
    private String serviceAddress;
}