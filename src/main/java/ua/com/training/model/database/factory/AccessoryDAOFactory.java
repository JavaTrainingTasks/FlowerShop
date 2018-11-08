package ua.com.training.model.database.factory;

import ua.com.training.model.database.dao.AccessoryDAO;
import ua.com.training.model.database.dao.DAO;
import ua.com.training.model.entity.Accessory;

public class AccessoryDAOFactory implements DAOFactory<Accessory> {
    @Override
    public DAO<Accessory> createDAO() {
        return new AccessoryDAO();
    }
}
