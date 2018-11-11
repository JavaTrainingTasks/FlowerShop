package ua.com.training.controller;

import javax.servlet.ServletException;
import java.io.IOException;

public class IndexPageCommand extends Command {
    @Override
    void process() throws ServletException, IOException {
    forward("index");
    }
}
