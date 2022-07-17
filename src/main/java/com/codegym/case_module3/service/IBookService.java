package com.codegym.case_module3.service;

import com.codegym.case_module3.model.Book;

import java.sql.SQLException;
import java.util.List;

public interface IBookService extends Icrud<Book>{
    @Override
    List<Book> selectAll();

    @Override
    Book selectById(int id) throws SQLException;

    @Override
    void insert(Book book) throws SQLException;
    @Override
    boolean delete(int id) throws SQLException;

    @Override
    boolean update(Book book) throws SQLException;
}
