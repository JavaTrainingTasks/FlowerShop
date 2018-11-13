package ua.com.training.controller;

import ua.com.training.model.dao.*;
import ua.com.training.model.entity.Accessory;
import ua.com.training.model.entity.Flower;
import ua.com.training.model.entity.Note;
import ua.com.training.model.entity.PaperWrap;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

/**
 * Command for loading page where you can build a bouquet
 */
public class BouquetBuildCommand extends Command {
    @Override
    void process() throws ServletException, IOException {
        DAO<Flower> flowerDAO = new FlowerDAO();
        DAO<Note> noteDAO = new NoteDAO();
        DAO<PaperWrap> paperWrapDAO = new PaperWrapDAO();
        List paperWraps =  paperWrapDAO.getAll();
        List flowers = flowerDAO.getAll();
        List notes = noteDAO.getAll();
        request.setAttribute("flowers", flowers);
        request.setAttribute("notes", notes);
        request.setAttribute("paperWraps", paperWraps);
        forward("build");
    }
}
