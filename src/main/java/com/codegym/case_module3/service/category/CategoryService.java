package com.codegym.case_module3.service.category;

import com.codegym.case_module3.model.Category;
import com.codegym.case_module3.service.DatabaseHandler;

import java.sql.*;
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
        String delete = "delete from category where (id = ?);";
        boolean deleteRow = false;
        try (Connection connection = categoryDBHandler.getConnection();
             PreparedStatement pre = connection.prepareStatement(delete)) {
            pre.setInt(1, id);
            deleteRow = pre.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleteRow;
    }

    @Override
    public HashMap<Integer, Integer> findQuantity() {
        String findQuantity = "SELECT category_id, count(id) as quantity FROM book group by category_id;";
        HashMap<Integer, Integer> listQuantity=new HashMap<>();
        try(Connection connection = categoryDBHandler.getConnection();
            PreparedStatement pre = connection.prepareStatement(findQuantity)) {
           ResultSet rs = pre.executeQuery();
           while (rs.next()){
               int id = rs.getInt("category_id");
               int quantity = rs.getInt("quantity");
               listQuantity.put(id, quantity);
           }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listQuantity;
    }
}
