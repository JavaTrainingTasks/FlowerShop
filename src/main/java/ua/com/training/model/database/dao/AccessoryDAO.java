package ua.com.training.model.database.dao;

import ua.com.training.model.database.DataBaseUtill;
import ua.com.training.model.entity.Accessory;
import ua.com.training.model.entity.Ribbon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AccessoryDAO implements DAO<Accessory> {
    private Connection connection = DataBaseUtill.getConnection();

    @Override
    public void add(Accessory item) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("accessory.insert.item"));
            preparedStatement.setString(1, item.getName());
            preparedStatement.setBigDecimal(2, item.getPrice());
            preparedStatement.setLong(3, item.getBouquetID());
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
    public void update(Accessory item) {
        throw new UnsupportedOperationException();

    }



    @Override
    public void updateBouquetIdByItemId(long itemID, long index) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("accessory.update.bouquet.index"));
            preparedStatement.setLong(1, index);
            preparedStatement.setLong(2,itemID);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void remove(Accessory item) {
        throw new UnsupportedOperationException();

    }

    @Override
    public List<Accessory> getAll() {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(resource.getString("accessory.select.all"))) {
            return buildFromResultSet(preparedStatement.executeQuery());
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException("getAll in AccessoryDAO");

        }
    }

    private List<Accessory> buildFromResultSet(ResultSet resultSet) throws SQLException {
        List<Accessory> accessories = new ArrayList<>();

        while (resultSet.next()) {
            Accessory accessory = new Accessory();

            accessory.setName(resultSet.getString("AccessoryName"));
            accessory.setPrice(resultSet.getBigDecimal("AccessoryPrice"));
            accessory.setBouquetID(resultSet.getLong("bouquetId"));
            accessories.add(accessory);
        }
        return accessories;
    }

    @Override
    public Accessory getById(Long id) {
        throw new UnsupportedOperationException();

    }
}
