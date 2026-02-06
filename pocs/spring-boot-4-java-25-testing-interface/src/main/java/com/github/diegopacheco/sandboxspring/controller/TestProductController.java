package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.Product;
import com.github.diegopacheco.sandboxspring.repository.ProductRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Profile("!prod")
public class TestProductController {
    private final ProductRepository productRepository;

    public TestProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping("/product-create")
    public Product createProduct(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/product-delete/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return productRepository.delete(id);
    }
}
