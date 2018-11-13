package ua.com.training.model.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

public interface DAO<T> {
    ResourceBundle resource = ResourceBundle.getBundle("sql");
    void add(T item);

    void deleteById(Long id);

    void update(T item);

    void updateBouquetIdByItemId( long itemID, long index);

    void remove(T item);

    List  getAll();

    T getById(Long id) throws SQLException;
}