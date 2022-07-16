package com.codegym.case_module3.service.impl;

import com.codegym.case_module3.model.Author;
import com.codegym.case_module3.service.DatabaseHandler;
import com.codegym.case_module3.service.IGeneralService;

import java.sql.SQLException;
import java.util.List;

public class AuthorServiceImpl implements IGeneralService<Author> {
    DatabaseHandler databaseHandler = DatabaseHandler.getInstance();


    @Override
    public void add(Author author) throws SQLException {

    }

    @Override
    public Author findById(int id) throws SQLException {
        return null;
    }

    @Override
    public List<Author> findAll() {
        return null;
    }

    @Override
    public List<Author> findByName(String name) {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Author author) throws SQLException {
        return false;
    }
}
