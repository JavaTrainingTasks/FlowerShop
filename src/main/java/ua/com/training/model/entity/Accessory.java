package ua.com.training.model.entity;

import java.math.BigDecimal;

public abstract class Accessory {
    private BigDecimal price;
    private String name;

    public void setPrice(BigDecimal price) {
        this.price = price;
    }



    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
}
