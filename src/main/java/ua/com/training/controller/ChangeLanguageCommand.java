package ua.com.training.controller;

import javax.servlet.ServletException;
import java.io.IOException;

public class ChangeLanguageCommand extends Command {
    @Override
    void process() throws ServletException, IOException {
       request.getSession().setAttribute("lang",request.getParameter("lang"));
       forward("index");
    }
}
