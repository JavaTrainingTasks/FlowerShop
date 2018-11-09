package ua.com.training.model.entity;

import java.math.BigDecimal;
import java.util.*;

public class Bouquet {
    private long id;
    private List<Flower> flowers = new ArrayList<>();
    private Map<AccessoryType,ArrayList<Accessory>> accessories =  new HashMap<>();
    private BigDecimal price;






   private void calculatePrice() {
        BigDecimal flowersPrice = flowers.stream().map(Flower::getPrice).reduce(BigDecimal.ZERO,BigDecimal::add);
        BigDecimal accessoriesPrice = BigDecimal.ZERO;
       for (AccessoryType type:AccessoryType.values()) {
           accessoriesPrice.add(accessories.get(type).stream().map(Accessory::getPrice)
                   .reduce(BigDecimal.ZERO,BigDecimal::add));
       }
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

    public List<Flower> getFlowers() {
        return flowers;
    }

    public void setFlowers(List<Flower> flowers) {
        this.flowers = flowers;
        calculatePrice();
    }
    public Map<AccessoryType, ArrayList<Accessory>> getAccessories() {
        return accessories;
    }

    public void setAccessories(Map<AccessoryType, ArrayList<Accessory>> accessories) {
        this.accessories = accessories;
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
        calculatePrice();
    }
    public void addFlowers(int amount, Flower flower) {

        for (int i = 0; i < amount ; i++) {
            flowers.add(flower);
        }
        calculatePrice();
    }
    public void addAccessory(Accessory accessory, AccessoryType type) {
        accessories.get(type).add(accessory);
        calculatePrice();

    }
    public void addAccessories(int amount, Accessory accessory, AccessoryType type) {
        for (int i = 0; i < amount; i++) {
            accessories.get(type).add(accessory);
        }
        calculatePrice();
    }

}
