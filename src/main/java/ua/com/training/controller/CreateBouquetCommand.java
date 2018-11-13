package ua.com.training.controller;

import ua.com.training.model.dao.*;
import ua.com.training.model.entity.Bouquet;
import ua.com.training.model.entity.Flower;
import ua.com.training.model.entity.Note;
import ua.com.training.model.entity.PaperWrap;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Command for building bouquet from requested flowers and acceessories
 */
public class CreateBouquetCommand extends Command {
    @Override
    void process() throws ServletException, IOException {
        DAO<Flower> flowerDAO = new FlowerDAO();
        DAO<Note> noteDAO = new NoteDAO();
        DAO<PaperWrap> paperWrapDAO = new PaperWrapDAO();
        DAO<Bouquet> bouquetDAO = new BouquetDAO();
        String[] flowersId  =request.getParameterValues("flowers");
        String[] notesId  =request.getParameterValues("notes");
        String[] paperWrapsId  =request.getParameterValues("paperWraps");
        Bouquet bouquet = new Bouquet();
        bouquetDAO.add(bouquet);

        if(flowersId != null) {
            List<Flower> flowers = new ArrayList<>();
            for (String id:flowersId) {
                try {
                    flowers.add(flowerDAO.getById(Long.valueOf(id)));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            bouquet.addFlowers(flowers);
            request.setAttribute("flowers",flowers);
        }
        if(notesId != null) {
            List<Note> notes = new ArrayList<>();
            for (String id: notesId) {
                try {
                    notes.add(noteDAO.getById(Long.valueOf(id)));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            bouquet.addAccessory(notes);
            request.setAttribute("notes",notes);
        }
        if(paperWrapsId != null) {
            List<PaperWrap> paperWraps = new ArrayList<> ();
            for(String id: paperWrapsId) {
                try {
                    paperWraps.add(paperWrapDAO.getById(Long.valueOf(id)));
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            bouquet.addAccessory(paperWraps);
            request.setAttribute("paperWraps", paperWraps);

        }
        bouquetDAO.update(bouquet);
        request.setAttribute("bouquet", bouquet);
        forward("bouquet");
    }
}
