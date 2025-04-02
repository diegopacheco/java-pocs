package com.github.diegopacheco.sandboxspring.dao;

import com.github.diegopacheco.sandboxspring.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByName(String name);
    List<Product> findByNameContaining(String name);
}