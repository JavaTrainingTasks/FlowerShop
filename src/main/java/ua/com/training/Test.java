package ua.com.training;

import ua.com.training.model.database.dao.DAO;
import ua.com.training.model.database.factory.DAOFactory;
import ua.com.training.model.database.factory.FlowerDAOFactory;
import ua.com.training.model.entity.Flower;

import java.math.BigDecimal;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        DAOFactory  factory = new FlowerDAOFactory();
        DAO dao = factory.createDAO();
        dao.add(new Flower.Builder().setName("ROSE")
                                    .setFreshness(0.5)
                                    .setLength(3.5)
                                    .setPrice(BigDecimal.valueOf(10.5))
                                    .setColour("Violet")
                                    .build());
        List<Flower> flowers = dao.getAll();
        System.out.println(flowers);
    }
}
