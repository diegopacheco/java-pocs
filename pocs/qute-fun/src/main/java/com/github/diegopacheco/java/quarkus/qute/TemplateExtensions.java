package com.github.diegopacheco.java.quarkus.qute;

import io.quarkus.qute.TemplateExtension;

import java.math.BigDecimal;

@TemplateExtension
public class TemplateExtensions {
    public static BigDecimal discountedPrice(Item item) {
        return item.price.multiply(new BigDecimal("0.9"));
    }
}