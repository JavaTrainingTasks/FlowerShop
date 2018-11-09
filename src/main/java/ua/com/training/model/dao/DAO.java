package ua.com.training.model.dao;

import ua.com.training.model.entity.Accessory;
import ua.com.training.model.entity.AccessoryType;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

public interface DAO<T> {
    ResourceBundle resource = ResourceBundle.getBundle("sql");
    void add(T item);

    void deleteById(Long id);

    void update(T item);

    void updateBouquetIdByItemId( long itemID, long index);

    void remove(T item);

    List  getAll();

    T getById(Long id);
}