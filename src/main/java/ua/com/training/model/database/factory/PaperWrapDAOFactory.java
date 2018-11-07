package ua.com.training.model.database.factory;

import ua.com.training.model.database.dao.DAO;
import ua.com.training.model.database.dao.PaperWrapDAO;
import ua.com.training.model.entity.PaperWrap;

public class PaperWrapDAOFactory implements DAOFactory<PaperWrap> {
    @Override
    public DAO<PaperWrap> createDAO() {
        return new PaperWrapDAO();
    }
}
