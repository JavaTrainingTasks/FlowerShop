package ua.com.training.model.entity;

import java.math.BigDecimal;

public abstract class Accessory {
    private BigDecimal price;

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
