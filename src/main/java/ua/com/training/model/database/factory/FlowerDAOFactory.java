package ua.com.training.model.database.factory;

import ua.com.training.model.database.dao.DAO;
import ua.com.training.model.database.dao.FlowerDAO;
import ua.com.training.model.entity.Flower;

public class FlowerDAOFactory implements DAOFactory<Flower> {
    @Override
    public DAO<Flower> createDAO() {
        return new FlowerDAO();
    }
}
