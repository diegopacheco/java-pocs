package com.github.diegopacheco.sandboxspring.service;

import com.github.diegopacheco.sandboxspring.model.Product;
import com.github.diegopacheco.sandboxspring.dao.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> findById(String id) {
        return productRepository.findById(id);
    }

    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        productRepository.findAll().forEach(products::add);
        return products;
    }

    public List<Product> findByName(String name) {
        return productRepository.findByName(name);
    }

    public List<Product> searchByName(String name) {
        return productRepository.findByNameContaining(name);
    }

    public void deleteById(String id) {
        productRepository.deleteById(id);
    }
}