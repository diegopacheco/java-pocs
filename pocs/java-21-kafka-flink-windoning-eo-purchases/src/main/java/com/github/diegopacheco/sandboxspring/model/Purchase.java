package com.github.diegopacheco.sandboxspring.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Purchase implements Serializable {
    private String purchaseId;
    private String userId;
    private String productName;
    private String productType;
    private BigDecimal value;
    private int quantity;
    private BigDecimal total;

    public Purchase() {
    }

    public Purchase(String purchaseId, String userId, String productName, String productType, BigDecimal value, int quantity) {
        this.purchaseId = purchaseId;
        this.userId = userId;
        this.productName = productName;
        this.productType = productType;
        this.value = value;
        this.quantity = quantity;
        this.total = value.multiply(BigDecimal.valueOf(quantity));
    }

    public String getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(String purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
