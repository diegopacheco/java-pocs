package com.github.diegopacheco.sandboxspring.model;

import java.util.List;

public class ProductSearchResponseV2 {
    private List<ProductV2> products;
    private int totalResults;
    private int limit;

    public ProductSearchResponseV2() {}

    public ProductSearchResponseV2(List<ProductV2> products, int totalResults, int limit) {
        this.products = products;
        this.totalResults = totalResults;
        this.limit = limit;
    }

    public List<ProductV2> getProducts() {
        return products;
    }

    public void setProducts(List<ProductV2> products) {
        this.products = products;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
