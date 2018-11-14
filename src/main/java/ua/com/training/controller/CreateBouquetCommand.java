package ua.com.training.controller;

import jdk.nashorn.internal.runtime.ECMAException;
import ua.com.training.model.dao.*;
import ua.com.training.model.entity.Bouquet;
import ua.com.training.model.entity.Flower;
import ua.com.training.model.entity.Note;
import ua.com.training.model.entity.PaperWrap;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.Array;
import java.sql.SQLException;
import java.util.*;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Command for building bouquet from requested flowers and accessories
 */
public class CreateBouquetCommand extends Command {
    @Override
    void process() throws ServletException, IOException, SQLException {
        DAO<Flower> flowerDAO = new FlowerDAO();
        DAO<Note> noteDAO = new NoteDAO();
        DAO<PaperWrap> paperWrapDAO = new PaperWrapDAO();
        DAO<Bouquet> bouquetDAO = new BouquetDAO();
        List flowers =  getItemsList(request.getParameterValues("flowers"), flowerDAO);
        List notes = getItemsList(request.getParameterValues("notes"), noteDAO);
        List paperWraps = getItemsList( request.getParameterValues("paperWraps"), paperWrapDAO);

        Bouquet bouquet = new Bouquet();
        bouquetDAO.add(bouquet);
        bouquet.addFlowers(flowers);
        bouquet.addAccessory(notes);
        bouquet.addAccessory(paperWraps);
        bouquetDAO.update(bouquet);

        request.setAttribute("flowers", flowers);
        request.setAttribute("notes", notes);
        request.setAttribute("paperWraps", paperWraps);
        request.setAttribute("bouquet", bouquet);

        forward("bouquet");
    }

    List  getItemsList (String [] idArray, DAO dao ) {
        return Optional.ofNullable(idArray)
                .map(Arrays::stream)
                .orElse(Stream.empty())
                .map(id -> dao.getById(Long.valueOf(id)))
                .collect(Collectors.toList());
    }

}

