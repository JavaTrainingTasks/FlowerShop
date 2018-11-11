package ua.com.training.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns="")
public class Controller extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Command command = getCommand(request);
        command.init(request, response, getServletContext());
        command.process();
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }



    private Command getCommand(HttpServletRequest request) {
        try {
            Class type;
            if(request.getParameter("command") == null) {
                type = Class.forName("ua.com.training.controller.IndexPageCommand");
            }
            else {
                type = Class.forName(String.format("ua.com.training.controller.%sCommand",
                        request.getParameter("command")));
            }
            return (Command) type.asSubclass(Command.class)
                    .newInstance();
        } catch (Exception e) {
            return new UnknownCommand();

        }
    }
}
