package org.exercise.javashop.subclasses;

import org.exercise.javashop.Product;

import java.math.BigDecimal;

public class Headphone extends Product {
    // Attributes specific to Headphones
    private String color;
    private boolean isWireless;

    // Constructor
    public Headphone(String name, String description, BigDecimal price, BigDecimal vat, String color, boolean isWireless) {
        super(name, description, price, vat);
        this.color = color;
        this.isWireless = isWireless;
    }

    // Getter and Setter methods
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isWireless() {
        return isWireless;
    }

    public void setWireless(boolean isWireless) {
        this.isWireless = isWireless;
    }

    @Override
    public String toString() {
        return "Headphone's:\n" +
                "Name: " + getName() + "\n" +
                "Description: " + getDescription() + "\n" +
                "Price: " + getPrice() + "\n" +
                "VAT: " + getVat() + "\n" +
                "Color: " + color + "\n" +
                "Is Wireless: " + isWireless;
    }
    // Override directive to include color and wireless property in getExtendedName
    @Override
    public String getExtendedName() {
        return super.getExtendedName() + color + (isWireless ? " / Wireless" : " / Wired");
    }

}
