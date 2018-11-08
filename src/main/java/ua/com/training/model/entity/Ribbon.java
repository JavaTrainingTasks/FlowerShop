package ua.com.training.model.entity;

import javax.accessibility.Accessible;

public class Ribbon extends Accessory {
    private  String colour;
    private double length;

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

}
