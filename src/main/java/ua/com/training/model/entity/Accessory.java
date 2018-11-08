package ua.com.training.model.entity;

import java.math.BigDecimal;

public  class Accessory {
    private BigDecimal price;
    private String name;
    static private long count = 0;
    private long id;
    private long bouquetID;

    public long getBouquetID() {
        return bouquetID;
    }

    public void setBouquetID(long bouquetID) {
        this.bouquetID = bouquetID;
    }

    public Accessory() {
        id = count++;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
