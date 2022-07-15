package com.codegym.case_module3.service.author;

import com.codegym.case_module3.model.Author;
import com.codegym.case_module3.service.DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AuthorService implements IAuthorService {
    private final String AUTHOR_TABLE = "author";
    DatabaseHandler<Author> authorDBHandler = DatabaseHandler.getInstance();

    private static AuthorService instance;

    private AuthorService() {

    }

    public static AuthorService getInstance() {
        if (instance == null) {
            instance = new AuthorService();
            return instance;
        }
        return instance;
    }
    @Override
    public Boolean create(Author author) {
        return authorDBHandler.insertData("author", author, author.getColumns());
    }

    @Override
    public HashMap<Integer, Author> find(String condition) {

        return null;
    }

    @Override
    public Author findById(int id) {
        String condition = "Where id = " + id;
        return find(condition).get(id);
    }

    @Override
    public Author update(int id) {
        return null;
    }

    @Override
    public Author delete(int id) {
        return null;
    }
}
