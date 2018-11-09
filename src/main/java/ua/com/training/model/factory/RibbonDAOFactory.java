package ua.com.training.model.factory;

import ua.com.training.model.dao.DAO;
import ua.com.training.model.dao.NoteDAO;
import ua.com.training.model.entity.Note;

public class RibbonDAOFactory implements DAOFactory<Note> {
    @Override
    public DAO<Note> createDAO() {
        return new NoteDAO();
    }
}
