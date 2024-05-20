package org.exercise.javashop.subclasses;

import org.exercise.javashop.Product;
import java.math.BigDecimal;
import java.util.Random;

public class Smartphone extends Product {
    // Attributes specific to Smartphone
    private String imei;
    private int memory;

    // Constructor
    public Smartphone(String name, String description, BigDecimal price, BigDecimal vat, String imei, int memory) {
        // Call the Product superclass constructor
        super(name, description, price, vat);
        this.imei =  generateRandomIMEI();
        this.memory = memory;
    }

    // Method to generate random IMEI code
    private String generateRandomIMEI() {
        Random random = new Random();
        StringBuilder imeiBuilder = new StringBuilder(15);
        for (int i = 0; i < 15; i++) {
            imeiBuilder.append(random.nextInt(10));
        }
        return imeiBuilder.toString();
    }

    // Getter and Setter methods
    public String getImei() {
        return imei;
    }

    public int getMemory() {
        return memory;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    // Override directive to include IMEI code in getExtendedName
    @Override
    public String getExtendedName() {
        return super.getExtendedName() + " / " + imei;
    }

}
