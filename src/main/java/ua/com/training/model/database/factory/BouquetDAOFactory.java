package ua.com.training.model.database.factory;

import ua.com.training.model.database.dao.BouquetDAO;
import ua.com.training.model.database.dao.DAO;
import ua.com.training.model.entity.Bouquet;

public class BouquetDAOFactory implements DAOFactory<Bouquet> {
    @Override
    public DAO<Bouquet> createDAO() {
        return new BouquetDAO();
    }
}
