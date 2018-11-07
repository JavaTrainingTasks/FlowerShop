package ua.com.training.model.database.dao;

import java.util.List;
import java.util.ResourceBundle;

public interface DAO<T> {
    ResourceBundle resource = ResourceBundle.getBundle("sql");
    void add(T item);

    void deleteById(Long id);

    void update(T item);

    void remove(T item);

    List<T> getAll();

    T getById(Long id);
}