package com.github.diegopacheco.sandboxspring.controller;

import com.github.diegopacheco.sandboxspring.model.ProductV1;
import com.github.diegopacheco.sandboxspring.model.ProductV2;
import com.github.diegopacheco.sandboxspring.model.ProductSearchResponseV2;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @RequestMapping(value = "/search", version = "1")
    public List<ProductV1> searchProductsV1(@RequestParam("query") String query) {
        return List.of(
            new ProductV1(1L, "Laptop", 999.99),
            new ProductV1(2L, "Laptop Pro", 1299.99),
            new ProductV1(3L, "Laptop Air", 899.99)
        );
    }

    @RequestMapping(value = "/search", version = "2")
    public ProductSearchResponseV2 searchProductsV2(
            @RequestParam("query") String query,
            @RequestParam(value = "limit", defaultValue = "10") int limit) {

        List<ProductV2> products = List.of(
            new ProductV2(1L, "Laptop", 999.99, "High performance laptop", "Electronics"),
            new ProductV2(2L, "Laptop Pro", 1299.99, "Professional grade laptop", "Electronics"),
            new ProductV2(3L, "Laptop Air", 899.99, "Lightweight and portable", "Electronics")
        );

        return new ProductSearchResponseV2(products, products.size(), limit);
    }
}
