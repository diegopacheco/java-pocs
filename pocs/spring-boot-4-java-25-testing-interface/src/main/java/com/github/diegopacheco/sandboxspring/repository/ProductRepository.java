package com.github.diegopacheco.sandboxspring.repository;

import com.github.diegopacheco.sandboxspring.model.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ProductRepository {
    private final ConcurrentHashMap<Long, Product> products = new ConcurrentHashMap<>();
    private final AtomicLong idGenerator = new AtomicLong(6);

    public ProductRepository() {
        products.put(1L, new Product(1L, "Laptop", "High performance laptop", 1299.99));
        products.put(2L, new Product(2L, "Smartphone", "Latest smartphone model", 899.99));
        products.put(3L, new Product(3L, "Headphones", "Wireless noise-canceling headphones", 299.99));
        products.put(4L, new Product(4L, "Keyboard", "Mechanical gaming keyboard", 149.99));
        products.put(5L, new Product(5L, "Monitor", "4K Ultra HD monitor", 499.99));
    }

    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    public Product save(Product product) {
        if (product.getId() == null) {
            product.setId(idGenerator.getAndIncrement());
        }
        products.put(product.getId(), product);
        return product;
    }

    public boolean delete(Long id) {
        return products.remove(id) != null;
    }
}
