package com.codegym.case_module3.service;

import com.codegym.case_module3.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface Icrud<T> {
    List<T> selectAll();
    T selectById(int id) throws SQLException;

    void insert(T t) throws SQLException;

    boolean delete(int id) throws SQLException;

    boolean update(T t) throws SQLException;
}
