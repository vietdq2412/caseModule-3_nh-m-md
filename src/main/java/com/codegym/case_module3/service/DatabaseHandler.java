package com.codegym.case_module3.service;

import com.codegym.case_module3.connect.ConnectionMySQL;

import java.sql.*;

public class DatabaseHandler<T> {
    final String DB_URL = "jdbc:mysql://localhost:3306/casemodule3_bookstore?serverTimezone=UTC";
    final String jdbc_USERNAME = "root";
    final String jdbc_PASSWORD = "123123";

//    ConnectionMySQL connectionMySQL = new ConnectionMySQL();

    Connection connection = getConnection();
    private static DatabaseHandler instance;

    private DatabaseHandler() {

    }

    public static DatabaseHandler getInstance() {
        if (instance == null) {
            instance = new DatabaseHandler();
            return instance;
        }
        return instance;
    }

    public Connection getConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(DB_URL, jdbc_USERNAME, jdbc_PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }

    public boolean insertData(String table, T objectToInsert, String insertColumns) {

        String sql = "insert into " + table + "(" + insertColumns + ") values(" + objectToInsert.toString() + ")";
        System.out.println(sql);
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            statement.execute(sql);
        } catch (SQLIntegrityConstraintViolationException e) {
            String messenger = new RuntimeException(e).toString();
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public ResultSet findAllByCondition(String table, String condition) {

        String sql = "select * from " + table + " " + condition;
        System.out.println(sql);
        try {
            Statement statement = connection.createStatement();
            return statement.executeQuery(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean updateData(String sql) {

        System.out.println(sql);
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            statement.execute(sql);
        } catch (SQLIntegrityConstraintViolationException e) {
            String messenger = new RuntimeException(e).toString();
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public boolean deleteData(String sql) {

        System.out.println(sql);
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
            statement.execute(sql);
        } catch (SQLIntegrityConstraintViolationException e) {
            String messenger = new RuntimeException(e).toString();
            return false;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return true;
    }
}
