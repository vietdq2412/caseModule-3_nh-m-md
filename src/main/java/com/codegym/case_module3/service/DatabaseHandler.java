package com.codegym.case_module3.service;

import com.codegym.case_module3.connect.ConnectionMySQL;

import java.sql.*;

public class DatabaseHandler<T> {
    final String DB_URL = "jdbc:mysql://localhost:3306/casemodule3_bookstore?serverTimezone=UTC";
    final String jdbc_USERNAME = "viet";
    final String jdbc_PASSWORD = "root";

   ConnectionMySQL connectionMySQL = new ConnectionMySQL();
    Connection connection = getConnection();
    private static DatabaseHandler instance;
    private DatabaseHandler() {
        connection = getConnection();
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
            connection = ConnectionMySQL.getInstance().getConnection();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public boolean insertData(String table, T objectToInsert, String insertColumns) {
        connection = getConnection();
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
        connection = getConnection();
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
        connection = getConnection();
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
