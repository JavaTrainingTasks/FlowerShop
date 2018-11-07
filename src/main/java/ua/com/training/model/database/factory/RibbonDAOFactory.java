package ua.com.training.model.database.factory;

import ua.com.training.model.database.dao.DAO;
import ua.com.training.model.database.dao.RibbonDAO;
import ua.com.training.model.entity.Ribbon;

public class RibbonDAOFactory implements DAOFactory<Ribbon> {
    @Override
    public DAO<Ribbon> createDAO() {
        return new RibbonDAO();
    }
}
