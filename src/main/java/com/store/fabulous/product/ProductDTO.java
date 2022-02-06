package com.store.fabulous.product;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private Long price;
    private Integer quantity;
    private Long storeId;

    public ProductDTO(ProductEntity product) {
        this.id = product.getId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.storeId = product.getStoreId();
    }
}
