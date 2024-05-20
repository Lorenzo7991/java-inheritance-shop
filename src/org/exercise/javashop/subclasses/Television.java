package org.exercise.javashop.subclasses;

import org.exercise.javashop.Product;
import java.math.BigDecimal;

public class Television extends Product {
    // Attributes specific to Television
    private int size;
    private boolean isSmart;

    public Television(String name, String description, BigDecimal price, BigDecimal vat, int size, boolean isSmart) {
        // Call the Product superclass constructor
        super(name, description, price, vat);
        this.size = size;
        this.isSmart = isSmart;
    }

    // Getter and Setter methods
    public int getSize() {
        return size;
    }

    public boolean isSmart() {
        return isSmart;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSmart(boolean isSmart) {
        this.isSmart = isSmart;
    }

    // Override directive to include specific subclass properties in getExtendedName
    @Override
    public String getExtendedName() {
        return super.getExtendedName() + " / " + size + " pollici" + (isSmart ? " / Smart TV" : " / Non-Smart TV");
    }

    // Override getDescription to include smart property
    @Override
    public String getDescription() {
        return super.getDescription() + (isSmart ? " / Smart TV" : " / Non-Smart TV");
    }
}
