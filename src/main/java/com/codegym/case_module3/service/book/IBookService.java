package com.codegym.case_module3.service.book;

import com.codegym.case_module3.model.Book;
import com.codegym.case_module3.service.IService;

import java.util.HashMap;

public interface IBookService extends IService<Book> {
    HashMap<Integer, Book> findByCategory(int id);
}
