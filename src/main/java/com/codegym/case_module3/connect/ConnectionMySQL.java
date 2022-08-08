package com.codegym.case_module3.connect;

import com.codegym.case_module3.service.category.CategoryService;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

    private String JDBC_URL = "jdbc:mysql://localhost:3306/casemodule3_bookstore?serverTimezone=UTC";
    private String JDBC_USERNAME = "viet";
    private String JDBC_PASSWORD = "root";

    private static ConnectionMySQL instance;

    public ConnectionMySQL() {

    }

    public static ConnectionMySQL getInstance() {
        if (instance == null) {
            instance = new ConnectionMySQL();

            return instance;
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            Connection connection = null;
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
