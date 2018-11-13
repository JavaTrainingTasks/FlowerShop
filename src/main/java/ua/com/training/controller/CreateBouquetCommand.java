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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;

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
        String[] flowersId = request.getParameterValues("flowers");
        String[] notesId = request.getParameterValues("notes");
        String[] paperWrapsId = request.getParameterValues("paperWraps");
        Bouquet bouquet = new Bouquet();
        bouquetDAO.add(bouquet);
        try {
            request.setAttribute("flowers", Optional.ofNullable(flowersId)
                                                        .map(flowerId -> Arrays.stream(flowersId)
                                                                                .map(id -> flowerDAO.getById(Long.valueOf(id)))
                                                                                .collect(Collectors.toList()))
                                                        .get());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            request.setAttribute("notes", Optional.ofNullable(notesId)
                                                     .map(flowerId -> Arrays.stream(notesId)
                                                                            .map(id -> noteDAO.getById(Long.valueOf(id)))
                                                                            .collect(Collectors.toList()))
                                                     .get());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            request.setAttribute("paperWraps", Optional.ofNullable(paperWrapsId)
                                                          .map(paperWrapId -> Arrays.stream(paperWrapsId)
                                                                                    .map(id -> paperWrapDAO.getById(Long.valueOf(id)))
                                                                                    .collect(Collectors.toList()))
                                                          .get());

            } catch (Exception e) {
                e.printStackTrace();
            }
            bouquetDAO.update(bouquet);
            request.setAttribute("bouquet", bouquet);
            forward("bouquet");
        }

}

