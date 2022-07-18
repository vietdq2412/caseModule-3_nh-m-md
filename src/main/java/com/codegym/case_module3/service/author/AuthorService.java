package com.codegym.case_module3.service.author;

import com.codegym.case_module3.model.Author;
import com.codegym.case_module3.model.Category;
import com.codegym.case_module3.service.DatabaseHandler;
import com.codegym.case_module3.service.category.CategoryService;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class AuthorService implements IAuthorService {
    private final String AUTHOR_TABLE = "author";
    private DatabaseHandler<Author> authorDBHandler = DatabaseHandler.getInstance();
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
    public boolean create(Author author) {
        return authorDBHandler.insertData(AUTHOR_TABLE, author, author.getColumns());
    }

    @Override
    public HashMap<Integer, Author> find(String condition) {
        ResultSet rs = authorDBHandler.findAllByCondition(AUTHOR_TABLE,condition);
        HashMap<Integer, Author> authorHashMap = new HashMap<>();
        try {
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Date dateOfBirth = rs.getDate("date_of_birth");
                int numberOfArts = rs.getInt("number_of_arts");
                String nation = rs.getString("nation");
                String image = rs.getString("image");
                Author author = new Author(id, name, dateOfBirth, numberOfArts, nation, image);
                authorHashMap.put(id, author);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return authorHashMap;
    }

    @Override
    public Author findById(int id) {
        String condition = "Where id = " + id;
        return find(condition).get(id);
    }

    @Override
    public boolean update(Author author) {
        String sql = "update " + AUTHOR_TABLE + " set name = '" + author.getName() +
                "', date_of_birth = '" + author.getDateOfBirth() +
                "', number_of_arts = " + author.getNumberOfArts() +
                ", nation = '" + author.getNation() +
                "', image = '" + author.getImage()+
                "' where id = " + author.getId() + ";";
        return authorDBHandler.updateData(sql);
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from " + AUTHOR_TABLE + " where id = " + id;
        return authorDBHandler.deleteData(sql);
    }
}
