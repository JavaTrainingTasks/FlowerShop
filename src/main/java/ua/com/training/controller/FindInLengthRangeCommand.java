package ua.com.training.controller;

import ua.com.training.model.dao.BouquetDAO;
import ua.com.training.model.dao.DAO;
import ua.com.training.model.entity.Bouquet;
import ua.com.training.model.services.FlowersFinder;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class FindInLengthRangeCommand extends Command {
    @Override
    void process() throws ServletException, IOException, SQLException {
        long id = Long.parseLong(request.getParameter("bouquetID"));
        Bouquet bouquet =( new BouquetDAO()).getById(id);
        List flowers = FlowersFinder.findFlowersInRangeOfLengths(bouquet,
                                                     Double.parseDouble(request.getParameter("lowRange")),
                                                     Double.parseDouble(request.getParameter("highRange")));
        request.setAttribute("flowers",flowers);
        request.setAttribute("bouquet",bouquet);
        request.setAttribute("hide", true);
        forward("bouquet");
    }
}
