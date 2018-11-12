package ua.com.training.model.dao;

import ua.com.training.model.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BouquetDAO implements  DAO<Bouquet> {
    private Connection connection = DataBaseUtill.getConnection();

    @Override
    public void add(Bouquet item) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.insert.item"))){
            preparedStatement.setLong(1, item.getId());
            preparedStatement.setBigDecimal(2, item.getPrice());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void setBouquetFlowers(Bouquet item) {
            try(PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.set.flowers"))) {
                if(item.getFlowers() != null) {
                    for (Flower flower : item.getFlowers()) {
                        preparedStatement.setLong(2, item.getId());
                        preparedStatement.setLong(1, flower.getId());
                        preparedStatement.addBatch();
                    }
                    System.out.println(preparedStatement);
                    preparedStatement.executeBatch();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    private void setBouquetAccessories(Bouquet item) {
            if (item.getAccessories() !=null){
                    try (PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.set.accessories"))) {
                        for (Accessory accessory : item.getAccessories()) {
                            preparedStatement.setLong(1, item.getId());
                            preparedStatement.setLong(2, accessory.getId());
                        }
                                preparedStatement.executeBatch();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
        }
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void update(Bouquet item) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.update.item"))){
            preparedStatement.setLong(1, item.getId());
            preparedStatement.setBigDecimal(2, item.getPrice());
            preparedStatement.executeUpdate();
            setBouquetFlowers(item);
            setBouquetAccessories(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateBouquetIdByItemId(long itemID, long index) {
        throw new UnsupportedOperationException();
    }


    @Override
    public void remove(Bouquet item) {
        throw new UnsupportedOperationException();

    }

    @Override
    public List<Bouquet> getAll() {
        List<Bouquet> bouquets = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.select.all"))){
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Bouquet bouquet = new Bouquet();
                bouquet.setId(resultSet.getLong("BouquetId"));
                bouquet.setAccessories(getBouquetAccoosseries(bouquet));
                bouquet.setFlowers(getBouquetFlowers(bouquet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bouquets;
    }

    private List<Flower> getBouquetFlowers(Bouquet bouquet) {
        List<Flower> flowers = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(resource.getString("bouquet.select.flowers"))) {
            preparedStatement.setLong(1,bouquet.getId());
            ResultSet resultSet =preparedStatement.executeQuery();

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
            return  flowers;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException("getAll in FlowersDAO");

        }
    }
    private List<Flower> getBouquetFlowersById(long id) {
        List<Flower> flowers = new ArrayList<>();
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(resource.getString("bouquet.select.flowers.by.id"))) {
            preparedStatement.setLong(1,id);
            ResultSet resultSet =preparedStatement.executeQuery();

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
            return  flowers;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException("getAll in FlowersDAO");

        }
    }


    private List getBouquetAccoosseries(Bouquet bouquet) throws SQLException {
        List<Accessory> accessories = new ArrayList<>();
        ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.select.accessories"))){
            preparedStatement.setLong(1,bouquet.getId());
            resultSet = preparedStatement.executeQuery();
        }
        return buildAccessoryFromResultSet(resultSet);
    }

    private List<Accessory> getBouquetAccoosseriesById(long id) throws SQLException, RuntimeException{
    List<Accessory> accessories = new ArrayList<>();
        ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.select.accessories"))){
            preparedStatement.setLong(1,id);
            resultSet = preparedStatement.executeQuery();
        }
        if(!resultSet.isClosed()){
        buildAccessoryFromResultSet(resultSet);
            return accessories;

        }
        return null;
    }
    private List buildAccessoryFromResultSet(ResultSet resultSet) throws SQLException {
        ArrayList accessories = new ArrayList();
        while (resultSet.next()) {
            Accessory accessory = new Accessory();
            accessory.setId(resultSet.getLong("AccessoryId"));
            accessory.setPrice(resultSet.getBigDecimal("AccessoryPrice"));
            accessory.setName(resultSet.getString("AccessoryName"));
            accessories.add(accessory);
        }
        return accessories;
    }

    @Override
    public Bouquet getById(Long id) throws SQLException {
        try(PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.select.by.id"))){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
                Bouquet bouquet = new Bouquet();
                    bouquet.setAccessories(getBouquetAccoosseriesById(id));
                    bouquet.setFlowers(getBouquetFlowersById(id));
                return bouquet;

        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
