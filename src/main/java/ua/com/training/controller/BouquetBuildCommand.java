package ua.com.training.controller;

import ua.com.training.model.dao.DAO;
import ua.com.training.model.dao.FlowerDAO;
import ua.com.training.model.entity.Flower;

import javax.servlet.ServletException;
import java.io.IOException;
import java.util.List;

public class BouquetBuildCommand extends Command {
    @Override
    void process() throws ServletException, IOException {
        DAO<Flower> dao = new FlowerDAO();
        List flowers = dao.getAll();
        request.setAttribute("flowers", flowers);
        forward("bouquet");
    }
}
