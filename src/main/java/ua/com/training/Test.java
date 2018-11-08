package ua.com.training;

import ua.com.training.model.database.dao.DAO;
import ua.com.training.model.database.dao.FlowerDAO;
import ua.com.training.model.database.factory.AccessoryDAOFactory;
import ua.com.training.model.database.factory.BouquetDAOFactory;
import ua.com.training.model.database.factory.DAOFactory;
import ua.com.training.model.database.factory.FlowerDAOFactory;
import ua.com.training.model.entity.Accessory;
import ua.com.training.model.entity.Bouquet;
import ua.com.training.model.entity.Flower;
import ua.com.training.model.services.FlowersFinder;
import ua.com.training.model.services.SortService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        DAOFactory  factory = new AccessoryDAOFactory();
        DAO accesoryDao = factory.createDAO();
        DAO flowerDao= new FlowerDAOFactory().createDAO();
        DAO bouquetDao = new BouquetDAOFactory().createDAO();
        Accessory accessory = new Accessory();
        Bouquet bouquet = new Bouquet();
        bouquetDao.add(bouquet);
        Flower flower =new Flower.Builder().setPrice(BigDecimal.valueOf(11.1)).setLength(2.1).setName("Kekflower").setBouquetId(bouquet.getId()).build();
        accessory.setName("Ribbon");
        accessory.setPrice(BigDecimal.valueOf(11.5));
        accessory.setBouquetID(bouquet.getId());
        bouquet.addFlower(flower);
        flowerDao.add(flower);
        accesoryDao.add(accessory);
        bouquet.setFlowers((ArrayList<Flower>) flowerDao.getAll());
        bouquet.setAccessories((ArrayList<Accessory>) accesoryDao.getAll());
        bouquetDao.update(bouquet);
        ArrayList<Flower> flowers = (ArrayList<Flower>) flowerDao.getAll();
        System.out.println(flowers);

        //FlowersFinder.findFlowersInRangeOfFreshness(bouquet,0.1, 0.5).forEach(System.out::println);
        //SortService.sortByFreshness(bouquet).getFlowers().forEach(System.out::println);
        //System.out.println(flowers);
    }
}
