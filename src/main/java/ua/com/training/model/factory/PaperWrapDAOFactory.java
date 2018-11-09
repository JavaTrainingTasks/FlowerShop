package ua.com.training.model.factory;

import ua.com.training.model.dao.DAO;
import ua.com.training.model.dao.PaperWrapDAO;
import ua.com.training.model.entity.PaperWrap;

public class PaperWrapDAOFactory implements DAOFactory<PaperWrap> {
    @Override
    public DAO<PaperWrap> createDAO() {
        return new PaperWrapDAO();
    }
}
