package ua.com.training.model.entity;

import java.math.BigDecimal;
import java.util.*;

public class Bouquet {
    private long id = new Random().nextInt(Integer.MAX_VALUE);
    private List<Flower> flowers = new ArrayList<>();
    private List<Accessory> accessories = new ArrayList<>();
    private BigDecimal price;


    public BigDecimal getPrice() {
        return price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
        calculatePrice();
    }
    public List<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(List<Accessory> accessories) {
        this.accessories = accessories;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
        calculatePrice();
    }
    public void addFlowers( List flowers) {
        this.flowers.addAll(flowers);
        calculatePrice();
    }
    public void addAccessory( List accessories) {
       this.accessories.addAll(accessories);
       calculatePrice();

    }
    private void calculatePrice() {
        BigDecimal flowersPrice =BigDecimal.ZERO;
        BigDecimal accessoriesPrice = BigDecimal.ZERO;

        if(flowers != null) {
            accessoriesPrice = accessoriesPrice.add(flowers.stream().map(Flower::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add));
        }

        if(accessories != null) {
            accessoriesPrice = accessoriesPrice
                    .add(accessories.stream()
                    .map(Accessory::getPrice)
                    .reduce(BigDecimal.ZERO, BigDecimal::add));
        }
        this.price = accessoriesPrice.add(accessoriesPrice);
    }

}
