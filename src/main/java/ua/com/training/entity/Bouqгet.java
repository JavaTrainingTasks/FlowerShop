package ua.com.training.entity;

import java.util.ArrayList;

public class Bouqгet {
    private long id;
    ArrayList<Flower> flowers;
    ArrayList<Accessory> accessories;

    public static class Builder
    {


    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(ArrayList<Flower> flowers) {
        this.flowers = flowers;
    }

    public ArrayList<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(ArrayList<Accessory> accessories) {
        this.accessories = accessories;
    }

    void addFlowers(int amount, Flower flower) {
        for (int i = 0; i < amount ; i++) {
            flowers.add(flower);
        }
    }

    void addAccessories(int amount, Accessory accessory) {
        for (int i = 0; i < amount; i++) {
            accessories.add(accessory);
        }
    }
}
