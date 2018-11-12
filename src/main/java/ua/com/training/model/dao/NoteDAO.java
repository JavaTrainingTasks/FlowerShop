package ua.com.training.model.dao;

import ua.com.training.model.entity.Accessory;
import ua.com.training.model.entity.AccessoryType;
import ua.com.training.model.entity.Note;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NoteDAO implements DAO<Note> {
    private Connection connection = DataBaseUtill.getConnection();

    @Override
    public void add(Note item) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void update(Note item) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void updateBouquetIdByItemId(long itemID, long index) {
        throw new UnsupportedOperationException();

    }



    @Override
    public void remove(Note item) {
        throw new UnsupportedOperationException();

    }

    @Override
    public List<Note> getAll() {

        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(resource.getString("notes.select.all"))) {
            return buildFromResultSet(preparedStatement.executeQuery());
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException("getAll in Note");

        }
    }

    private List<Note> buildFromResultSet(ResultSet resultSet) throws SQLException {
        List<Note> notes = new ArrayList<>();

        while (resultSet.next()) {
            Note note = new Note();
                    note.setName(resultSet.getString("AccessoryName"));
                    note.setPrice(resultSet.getBigDecimal("AccessoryPrice"));
                    note.setId(resultSet.getLong("AccessoryId"));
                    note.setNoteMessage(resultSet.getString("NoteMessage"));
            notes.add(note);
        }
        return notes;

    }


    @Override
    public Note getById(Long id) {
        try (PreparedStatement preparedStatement =
                     connection.prepareStatement(resource.getString("notes.select.by.id"))) {
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Note note = new Note();
            note.setName(resultSet.getString("AccessoryName"));
            note.setPrice(resultSet.getBigDecimal("AccessoryPrice"));
            note.setId(resultSet.getLong("AccessoryId"));
            note.setNoteMessage(resultSet.getString("NoteMessage"));
            return note;
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw new RuntimeException();

        }

    }
}
