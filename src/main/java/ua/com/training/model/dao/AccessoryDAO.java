package ua.com.training.model.dao;

import ua.com.training.model.entity.Accessory;
import ua.com.training.model.entity.AccessoryType;
import ua.com.training.model.entity.Note;
import ua.com.training.model.entity.PaperWrap;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccessoryDAO implements DAO<Accessory> {
    private Connection connection = DataBaseUtill.getConnection();

    @Override
    public void add(Accessory item) {
        throw new UnsupportedOperationException();
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

    }

    @Override
    public void remove(Accessory item) {
        throw new UnsupportedOperationException();

    }

    @Override
    public  List<Accessory> getAll() {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(resource.getString("accessory.select.all"))) {
            return buildFromResultSet(preparedStatement.executeQuery());
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException();

        }
    }



    private List<Accessory> buildFromResultSet(ResultSet resultSet) throws SQLException {
        List<Note> notes =  new ArrayList<>();
        List<PaperWrap> paperWraps = new ArrayList<>();
        List<Accessory> accessories = new ArrayList<>();
        while (resultSet.next()) {
            if (resultSet.getString("Type") == "NOTE") {
                Note note = new Note();
                note.setId(resultSet.getLong("AccessoryId"));
                note.setNoteMessage(resultSet.getString("NoteMessage"));
                note.setPrice(resultSet.getBigDecimal("AccessoryPrice"));
                note.setName(resultSet.getString("AccessoryName"));
                notes.add(note);
            }
            if (resultSet.getString("Type") == "PAPER_WRAP") {
                PaperWrap paperWrap = new PaperWrap();
                paperWrap.setId(resultSet.getLong("AccessoryId"));
                paperWrap.setLength(resultSet.getLong("Length"));
                paperWrap.setPrice(resultSet.getBigDecimal("AccessoryPrice"));
                paperWrap.setName(resultSet.getString("AccessoryName"));
                paperWraps.add(paperWrap);
            }

        }
        accessories.addAll(paperWraps);
        accessories.addAll(paperWraps);
        return accessories;
    }
    @Override
    public Accessory getById(Long id) {
        return null;
    }
}