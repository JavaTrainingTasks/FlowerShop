package ua.com.training.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UnknownCommand extends Command {
    @Override
    public void process() throws ServletException, IOException {
        forward("error");
    }


}

