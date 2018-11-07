package ua.com.training.model.database.dao;

import ua.com.training.model.database.DataBaseUtill;
import ua.com.training.model.entity.PaperWrap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    public void remove(PaperWrap item) {
        throw new UnsupportedOperationException();

    }

    @Override
    public List<PaperWrap> getAll() {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(resource.getString("paper.wrap.select.all"))) {
            return buildFromResultSet(preparedStatement.executeQuery());
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException("getAll in PaperWrapDAO");

        }
    }

    private List<PaperWrap> buildFromResultSet(ResultSet resultSet) throws SQLException {
        List<PaperWrap> paperWraps = new ArrayList<>();

        while (resultSet.next()) {
            PaperWrap paperWrap = new PaperWrap();
            paperWrap.setColour(resultSet.getString("PaperColour"));
            paperWrap.setName(resultSet.getString("PaperName"));
            paperWrap.setPrice(resultSet.getBigDecimal("PaperPrice"));
            paperWraps.add(paperWrap);
        }
        return paperWraps;
    }



    @Override
    public PaperWrap getById(Long id) {
        return null;
    }
}
