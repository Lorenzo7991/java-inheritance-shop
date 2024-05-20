package org.exercise.javashop;

import java.math.BigDecimal;
import java.util.Random;

public class Product {
    // Attributes
    private int productCode;
    private String name;
    private String description;
    private BigDecimal price;
    private BigDecimal vat;

    // Constructor
    public Product(String name, String description, BigDecimal price, BigDecimal vat) {
        // Assignment of product code with random object to create product code as randomized number between 0 and 999999
        this.productCode = new Random().nextInt(1000000);
        this.name = name;
        this.description = description;
        this.price = price;
        this.vat = vat;
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getVat() {
        return vat;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setVat(BigDecimal vat) {
        this.vat = vat;
    }

    // Get method to obtain formatted code
    public String getCode() {
        return String.format("%06d", productCode);
    }

    // Get method to obtain price including VAT
    public BigDecimal getVatPrice() {
        return price.add(price.multiply(vat).divide(new BigDecimal("100")));
    }

    // Get method to obtain extended name with code product
    public String getExtendedName() {
        return getCode() + "/" + name;
    }
}
