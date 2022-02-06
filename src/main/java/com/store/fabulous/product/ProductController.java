package com.store.fabulous.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProducts(@PathVariable Long id) {
        return new ResponseEntity<>(service.getProduct(id), HttpStatus.OK);
    }

    @GetMapping("/products-by-store/{storeId}")
    public ResponseEntity<List<ProductDTO>> getProductsByStore(@PathVariable Long storeId) {
        return new ResponseEntity<>(service.getProductsByStore(storeId), HttpStatus.OK);
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> newProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(service.saveProduct(productDTO), HttpStatus.OK);
    }

    @PutMapping("/product")
    public ResponseEntity<ProductDTO> editProduct(@RequestBody ProductDTO productDTO) {
        return new ResponseEntity<>(service.saveProduct(productDTO), HttpStatus.OK);
    }

    @DeleteMapping("/product/{id}")
    public void deletePerson(@PathVariable Long id) {
        service.deleteProduct(id);
    }
}
