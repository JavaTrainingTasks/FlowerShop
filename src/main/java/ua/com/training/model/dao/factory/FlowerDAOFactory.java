package ua.com.training.model.dao.factory;

import ua.com.training.model.dao.DAO;
import ua.com.training.model.dao.FlowerDAO;
import ua.com.training.model.entity.Flower;

public class FlowerDAOFactory implements DAOFactory<Flower> {
    @Override
    public DAO<Flower> createDAO() {
        return new FlowerDAO();
    }
}
