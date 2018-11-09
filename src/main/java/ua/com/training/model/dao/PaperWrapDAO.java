package ua.com.training.model.dao;

import ua.com.training.model.entity.Accessory;
import ua.com.training.model.entity.AccessoryType;
import ua.com.training.model.entity.PaperWrap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaperWrapDAO implements  DAO<PaperWrap>{
    private Connection connection = DataBaseUtill.getConnection();
    @Override
    public void add(PaperWrap item) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void update(PaperWrap item) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void updateBouquetIdByItemId(long itemID, long index) {

    }


    @Override
    public void remove(PaperWrap item) {
        throw new UnsupportedOperationException();

    }

    @Override
    public Map<AccessoryType, ArrayList<Accessory>> getAll() {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(resource.getString("paper.wrap.select.all"))) {
            return buildFromResultSet(preparedStatement.executeQuery());
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException("getAll in PaperWrapDAO");

        }
    }

    private List<PaperWrap> buildFromResultSet(ResultSet resultSet) throws SQLException {
     throw new UnsupportedOperationException();
    }



    @Override
    public PaperWrap getById(Long id) {
        return null;
    }
}
