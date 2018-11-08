package ua.com.training.model.database.dao;

import ua.com.training.model.database.DataBaseUtill;
import ua.com.training.model.entity.Flower;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FlowerDAO  implements DAO<Flower> {
    private Connection connection = DataBaseUtill.getConnection();

    @Override
    public void add(Flower item) {

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("flower.insert.item"));
            preparedStatement.setString(1, item.getName());
            preparedStatement.setString(2, item.getColour());
            preparedStatement.setDouble(3, item.getFreshness());
            preparedStatement.setDouble(4, item.getLength());
            preparedStatement.setBigDecimal(5, item.getPrice());
            preparedStatement.setLong(6, item.getBouquetId());
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
    public void update(Flower item) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void updateBouquetIdByItemId(long itemID, long index) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("flower.update.bouquet.index"));
            preparedStatement.setLong(1, index);
            preparedStatement.setLong(2,itemID);
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void remove(Flower item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Flower> getAll() {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(resource.getString("flower.select.all"))) {
            ResultSet resultSet =preparedStatement.executeQuery();
            return buildFromResultSet(resultSet);
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException("getAll in FlowersDAO");

        }
    }

    @Override
    public Flower getById(Long id) {
        throw new UnsupportedOperationException();
    }


    private List<Flower> buildFromResultSet(ResultSet resultSet) throws SQLException {
        List<Flower> flowers = new ArrayList<>();

        while (resultSet.next()) {
            Flower flower = new Flower.Builder().setName(resultSet.getString("FlowerName"))
                                                .setColour(resultSet.getString("FlowerColour"))
                                                .setFreshness(resultSet.getDouble("FlowerFreshness"))
                                                .setPrice(resultSet.getBigDecimal("FlowerPrice"))
                                                .setLength(resultSet.getDouble("FlowerLength"))
                                                .setId(resultSet.getLong("FlowerId"))
                                                .build();
            flowers.add(flower);
        }
    return flowers;
    }
}