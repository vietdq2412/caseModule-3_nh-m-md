package com.codegym.case_module3.service.category;

import com.codegym.case_module3.model.Category;
import com.codegym.case_module3.service.DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class CategoryService implements ICategoryService {
    private DatabaseHandler<Category> categoryDBHandler = DatabaseHandler.getInstance();
    private final String CATEGORY_TABLE = "category";
    private static CategoryService instance;

    public CategoryService() {

    }

    public static CategoryService getInstance() {
        if (instance == null) {
            instance = new CategoryService();
            return instance;
        }
        return instance;
    }
    @Override
    public boolean create(Category category) {
        return categoryDBHandler.insertData(CATEGORY_TABLE, category, category.getColumns());
    }

    @Override
    public HashMap<Integer, Category> find(String condition) {
        ResultSet rs = categoryDBHandler.findAllByCondition(CATEGORY_TABLE,condition);
        HashMap<Integer, Category> categoryHashMap = new HashMap<>();
        try {
            while (rs.next()){
                String name = rs.getString("name");
                int id = rs.getInt("id");
                Category category = new Category(id, name);
                categoryHashMap.put(id, category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categoryHashMap;
    }

    @Override
    public Category findById(int id) {
        String condition = "Where id = " + id;
        return find(condition).get(id);
    }

    @Override
    public boolean update(Category category) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
