package ua.com.training.model.database.dao;

import com.mysql.fabric.jdbc.FabricMySQLConnectionProxy;
import ua.com.training.model.database.DataBaseUtill;
import ua.com.training.model.entity.Accessory;
import ua.com.training.model.entity.Ribbon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RibbonDAO implements DAO<Ribbon> {
    private Connection connection = DataBaseUtill.getConnection();

    @Override
    public void add(Ribbon item) {

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Ribbon item) {

    }

    @Override
    public void updateBouquetIdByItemId(long itemID, long index) {

    }



    @Override
    public void remove(Ribbon item) {

    }

    @Override
    public List<Ribbon> getAll() {

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(resource.getString("ribbon.select.all"))) {
            return buildFromResultSet(preparedStatement.executeQuery());
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException("getAll in PaperWrapDAO");

        }
    }

    private List<Ribbon> buildFromResultSet(ResultSet resultSet) throws SQLException {
        List<Ribbon> ribbons = new ArrayList<>();

        while (resultSet.next()) {
            Ribbon ribbon = new Ribbon();
            ribbon.setColour(resultSet.getString("RibbonColour"));
            ribbon.setName(resultSet.getString("RibbonName"));
            ribbon.setPrice(resultSet.getBigDecimal("RibbonPrice"));
            ribbon.setLength(resultSet.getDouble("RibbonLength"));
            ribbons.add(ribbon);
        }
        return ribbons;
    }


    @Override
    public Ribbon getById(Long id) {
        return null;
    }
}
