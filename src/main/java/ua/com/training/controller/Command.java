package ua.com.training.controller;

import org.omg.CORBA.Request;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class Command {
    ServletContext servletContext;
    HttpServletRequest request;
    HttpServletResponse response;

    abstract void process() throws ServletException, IOException;

    void init(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) {
        this.servletContext = servletContext;
        this.request = request;
        this.response = response;
    }

     void forward(String target) throws ServletException, IOException {
        target = String.format("/WEB-INF/%s.jsp", target);
        RequestDispatcher dispatcher = servletContext.getRequestDispatcher(target);
        dispatcher.forward(request, response);

    }
}
