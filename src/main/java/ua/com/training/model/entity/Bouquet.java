package ua.com.training.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Bouquet {
    private long id;
    private ArrayList<Flower> flowers;
    private ArrayList<Accessory> accessories;
    private BigDecimal price;

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

    BigDecimal calculatePrice() {
        BigDecimal flowersPrice = flowers.stream().map(Flower::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal accessoriesPrice = accessories.stream().map(Accessory::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
        return flowersPrice.add(accessoriesPrice);
    }
    public BigDecimal getPrice() {
        return price;
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


}
