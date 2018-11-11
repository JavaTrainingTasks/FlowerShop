package ua.com.training.model.dao.factory;

import ua.com.training.model.dao.DAO;

public interface DAOFactory<T> {
    DAO<T> createDAO();
}
