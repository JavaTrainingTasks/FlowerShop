package ua.com.training.controller;

import ua.com.training.model.dao.BouquetDAO;
import ua.com.training.model.entity.Bouquet;
import ua.com.training.model.services.SortService;

import javax.servlet.ServletException;
import java.io.IOException;
import java.sql.SQLException;

public class SortByFreshnessCommand extends Command   {
    @Override
    void process() throws ServletException, IOException, SQLException {
        long id = Long.parseLong(request.getParameter("bouquetID"));
        Bouquet bouquet = new BouquetDAO().getById(id);
        request.setAttribute("bouquet",SortService.sortByFreshness(bouquet));
        request.setAttribute("flowers",bouquet.getFlowers());
        request.setAttribute("hide", true);
        forward("bouquet");
    }
}
