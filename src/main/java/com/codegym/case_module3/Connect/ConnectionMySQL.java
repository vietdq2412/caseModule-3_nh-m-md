package com.codegym.case_module3.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {

    private String DB_URL = "jdbc:mysql://localhost:3306/casestudymd3_bookmanagement?serverTimezone=UTC";
    private String JDBC_USERNAME = "root";
    private String JDBC_PASSWORD = "123456";

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
