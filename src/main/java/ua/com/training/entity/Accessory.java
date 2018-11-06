package ua.com.training.entity;

import java.math.BigDecimal;

public abstract class Accessory {
    BigDecimal price;

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
