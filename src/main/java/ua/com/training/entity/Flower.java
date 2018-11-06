package ua.com.training.entity;

import java.math.BigDecimal;
import java.util.Objects;

public class Flower {

    private BigDecimal price;
    private double freshness;
    private String colour;
    private double length;
    private String name;

    public  static class Builder {
        private Flower flower;
        private BigDecimal price;
        private double freshness;
        private double length;
        private String name;
        private String colour;

        public Builder setPrice(BigDecimal price) {
            this.price = price;
            return this;
        }

        public Builder setFreshness(double freshness) {
            this.freshness = freshness;
            return this;
        }

        public Builder setLength(double length) {
            this.length = length;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        Flower build() {
            flower = new Flower();
            flower.price = this.price;
            flower.freshness = this.freshness;
            flower.colour = this.colour;
            flower.length = this.length;
            flower.name = this.name;
            return flower;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flower flower = (Flower) o;
        return Double.compare(flower.freshness, freshness) == 0 &&
                Double.compare(flower.length, length) == 0 &&
                Objects.equals(price, flower.price) &&
                Objects.equals(colour, flower.colour) &&
                Objects.equals(name, flower.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, freshness, colour, length, name);
    }

    private Flower(){}

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void setFreshness(double freshness) {
        this.freshness = freshness;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getColour() {
        return colour;
    }

    public double getFreshness() {
        return freshness;
    }

    public double getLength() {
        return length;
    }

    public String getName() {
        return name;
    }
}
