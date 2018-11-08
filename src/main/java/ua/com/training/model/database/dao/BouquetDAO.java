package ua.com.training.model.database.dao;

import ua.com.training.model.database.DataBaseUtill;
import ua.com.training.model.entity.Accessory;
import ua.com.training.model.entity.Bouquet;
import ua.com.training.model.entity.Flower;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BouquetDAO implements  DAO<Bouquet> {
    private Connection connection = DataBaseUtill.getConnection();

    @Override
    public void add(Bouquet item) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.insert.item"));
            preparedStatement.setLong(1, item.getId());
            preparedStatement.setBigDecimal(2, item.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void update(Bouquet item) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.update.item"));
            preparedStatement.setLong(2, item.getId());
            preparedStatement.setBigDecimal(1, item.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBouquetIdByItemId(long itemID, long index) {

    }


    @Override
    public void remove(Bouquet item) {
        throw new UnsupportedOperationException();

    }

    @Override
    public List<Bouquet> getAll() {
        return null;
    }

    @Override
    public Bouquet getById(Long id) {
        return null;
    }
}
