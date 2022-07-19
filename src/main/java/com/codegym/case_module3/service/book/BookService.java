package com.codegym.case_module3.service.book;

import com.codegym.case_module3.connect.ConnectionMySQL;
import com.codegym.case_module3.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class BookService implements IBookService {
    ConnectionMySQL connectionMySQL = new ConnectionMySQL();

    private PreparedStatement setPreparedStatement(PreparedStatement pre, Book book) throws SQLException {
        pre.setString(1, book.getTitle());
        pre.setInt(2, book.getCategoryId());
        pre.setInt(3, book.getAuthorId());
        pre.setInt(4, book.getPublishYear());
        pre.setString(5, book.getDescription());
        pre.setString(6, book.getImage());
        pre.setInt(7,book.getViews());
        pre.setInt(8, book.getQuantity());
        pre.setDouble(9, book.getPrice());

         return pre;
    }
    @Override
    public boolean create(Book book) {
        boolean createRow = false;
        String insert = "insert into book (title, category_id, author_id," +
                " publish_year, description, image, views, quantity, price) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
        try (Connection connection = connectionMySQL.getConnection();
        PreparedStatement pre = connection.prepareStatement(insert)){
            createRow = setPreparedStatement(pre, book).executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return createRow;
    }

    @Override
    public HashMap<Integer, Book> find(String condition) {
        String selectAll = "select * from book;";
        HashMap<Integer, Book> books = new HashMap<>();
        try (Connection connection = connectionMySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectAll);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Book book = getAllBook(rs);
                books.put(book.getId(), book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return books;
    }

    @Override
    public Book findById(int id) {
        String selectById = "select * from book where id = ?";
        Book book = null;
        try(Connection connection = connectionMySQL.getConnection();
        PreparedStatement pre = connection.prepareStatement(selectById)) {
            pre.setInt(1, id);
            ResultSet rs =pre.executeQuery();
            while (rs.next()){
                book = getAllBook(rs);
//                book.setId(id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return book;
    }

    private Book getAllBook(ResultSet rs) throws SQLException {
        Book book = null;
        int id = rs.getInt("id");
        String title = rs.getString("title");
        int category_id = Integer.parseInt(rs.getString("category_id"));
        int author_id = Integer.parseInt(rs.getString("author_id"));
        int publish_year = Integer.parseInt(rs.getString("publish_year"));
        String description = rs.getString("description");
        String image = rs.getString("image");
        int views = rs.getInt("views");
        int quantity = rs.getInt("quantity");
        double price = rs.getDouble("price");
        book = new Book(id,title, author_id, category_id, publish_year, image, description, price, views, quantity);
        return book;

    }

    @Override
    public boolean delete(int id) {
        String delete = "delete from book where (id = ?);";
        boolean deleteRow = false;
        try(Connection connection = connectionMySQL.getConnection();
        PreparedStatement pre = connection.prepareStatement(delete)) {
            pre.setInt(1,id);
            deleteRow = pre.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return deleteRow;
    }

    @Override
    public boolean update(Book book) {
        String update = "update book set title = ?, category_id = ?, author_id = ?, publish_year = ?," +
                " description = ?, image = ?, views = ?, quantity = ?, price = ? where (id = ?);";
        boolean updateRow = false;
        try(Connection connection = connectionMySQL.getConnection();
        PreparedStatement pre = connection.prepareStatement(update)){
            PreparedStatement preparedStatement = setPreparedStatement(pre, book);
            preparedStatement.setInt(10, book.getId());

           updateRow = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updateRow;
    }
}
