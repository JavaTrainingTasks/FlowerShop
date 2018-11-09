package ua.com.training.model.dao;

import ua.com.training.model.entity.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BouquetDAO implements  DAO<Bouquet> {
    private Connection connection = DataBaseUtill.getConnection();

    @Override
    public void add(Bouquet item) {
        try(PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.insert.item"))){
            preparedStatement.setLong(1, item.getId());
            preparedStatement.setBigDecimal(2, item.getPrice());
            preparedStatement.executeUpdate();
            setBouquetFlowers(item);
            setBouquetAccessories(item);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    private void setBouquetFlowers(Bouquet item) {
        for (Flower flower: item.getFlowers()) {
            try(PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.set.flowers"))){
                preparedStatement.setLong(1,item.getId());
                preparedStatement.setLong(2,flower.getId());
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
    private void setBouquetAccessories(Bouquet item) {
        for (AccessoryType type:AccessoryType.values()) {
            for (Accessory accessory : item.getAccessories().get(type)) {
                try (PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.set.accessories"))) {
                    preparedStatement.setLong(1, item.getId());
                    preparedStatement.setLong(2, accessory.getId());
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }
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


    private Map<AccessoryType, ArrayList<Accessory>> getBouquetAccoosseries(Bouquet bouquet) throws SQLException {
        Map<AccessoryType, ArrayList<Accessory>> accessories = new HashMap<>();
        accessories.put(AccessoryType.NOTE, new ArrayList<>());
        accessories.put(AccessoryType.PAPER_WRAP, new ArrayList<>());
        ResultSet resultSet;
        try(PreparedStatement preparedStatement = connection.prepareStatement(resource.getString("bouquet.select.accessories"))){
            preparedStatement.setLong(1,bouquet.getId());
            resultSet = preparedStatement.executeQuery();
        }

        while (resultSet.next()) {
            if (resultSet.getString("Type") == "NOTE") {
                Note note = new Note();
                note.setId(resultSet.getLong("AccessoryId"));
                note.setNoteMessage(resultSet.getString("NoteMessage"));
                note.setPrice(resultSet.getBigDecimal("AccessoryPrice"));
                note.setName(resultSet.getString("AccessoryName"));
                accessories.get(AccessoryType.NOTE).add(note);
            }
            if (resultSet.getString("Type") == "PAPER_WRAP") {
                PaperWrap paperWrap = new PaperWrap();
                paperWrap.setId(resultSet.getLong("AccessoryId"));
                paperWrap.setLength(resultSet.getLong("Length"));
                paperWrap.setPrice(resultSet.getBigDecimal("AccessoryPrice"));
                paperWrap.setName(resultSet.getString("AccessoryName"));
                accessories.get(AccessoryType.PAPER_WRAP).add(paperWrap);
            }

        }
        return accessories;
    }
    @Override
    public Bouquet getById(Long id) {
        return null;
    }
}
