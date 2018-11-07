package ua.com.training.model.database.factory;

import ua.com.training.model.database.dao.DAO;

public interface DAOFactory<T> {
    DAO<T> createDAO();
}
