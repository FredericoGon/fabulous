package com.store.fabulous.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    public ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    public ProductDTO getProduct(Long id) {
        return new ProductDTO(repository.getById(id));
    }

    public ProductDTO saveProduct(ProductDTO productDTO) {
        return new ProductDTO(repository.save(new ProductEntity(productDTO)));
    }

    public void deleteProduct(Long id) {
        log.info("Product with id: " + id + " deleted.");
        repository.deleteById(id);
    }

    public List<ProductDTO> getProductsByStore(Long storeId) {
        List<ProductEntity> products = repository.getByStoreId(storeId);
        List<ProductDTO> productDTOS = new ArrayList<>();
        products.stream().forEach(product -> productDTOS.add(new ProductDTO(product)));
        return productDTOS;
    }
}
