package ua.com.training.model.factory;

import ua.com.training.model.dao.AccessoryDAO;
import ua.com.training.model.dao.DAO;
import ua.com.training.model.entity.Accessory;

public class AccessoryDAOFactory implements DAOFactory<Accessory> {
    @Override
    public DAO<Accessory> createDAO() {
        return new AccessoryDAO();
    }
}
