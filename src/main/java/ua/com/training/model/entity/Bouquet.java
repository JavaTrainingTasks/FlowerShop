package ua.com.training.model.entity;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Bouquet {
    private  static long count = 1;
    private long id = 0;
    private ArrayList<Flower> flowers;
    private ArrayList<Accessory> accessories;
    private BigDecimal price;

    public Bouquet() {
        flowers = new ArrayList<>();
        accessories = new ArrayList<>();
        id = count++;

    }


    public void addFlowers(int amount, Flower flower) {

        for (int i = 0; i < amount ; i++) {
            flowers.add(flower);
        }
        calculatePrice();
    }

    public void addAccessories(int amount, Accessory accessory) {
        for (int i = 0; i < amount; i++) {
            accessories.add(accessory);
        }
        calculatePrice();
    }

   void calculatePrice() {
        BigDecimal flowersPrice = flowers.stream().map(Flower::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal accessoriesPrice = accessories.stream().map(Accessory::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
        this.price = flowersPrice.add(accessoriesPrice);
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
        calculatePrice();
    }

    public ArrayList<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(ArrayList<Accessory> accessories) {
        this.accessories = accessories;
        calculatePrice();
    }


    public void addFlower(Flower flower) {
        flowers.add(flower);
        calculatePrice();
    }
}
