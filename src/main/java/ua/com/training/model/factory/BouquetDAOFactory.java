package ua.com.training.model.factory;

import ua.com.training.model.dao.BouquetDAO;
import ua.com.training.model.dao.DAO;
import ua.com.training.model.entity.Bouquet;

public class BouquetDAOFactory implements DAOFactory<Bouquet> {
    @Override
    public DAO<Bouquet> createDAO() {
        return new BouquetDAO();
    }
}
