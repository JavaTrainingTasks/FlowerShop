package ua.com.training.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataBaseUtill {
    private static  Connection connection;
    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle("database");
    private static final String DRIVER = BUNDLE.getString("db.driver");
    private static final String URL = BUNDLE.getString("db.url");
    private static final String USER = BUNDLE.getString("db.user");
    private static final String PASSWORD = BUNDLE.getString("db.password");

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        } else {
            try {
                System.out.println(DRIVER);
                Class.forName(DRIVER);
                connection = DriverManager.getConnection(URL, USER, PASSWORD);
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();


            }
            return connection;
        }
    }
}