package com.codegym.case_module3.service.book;

import com.codegym.case_module3.connect.ConnectionMySQL;
import com.codegym.case_module3.model.Author;
import com.codegym.case_module3.model.Book;
import com.codegym.case_module3.model.Category;
import com.codegym.case_module3.service.DatabaseHandler;
import com.codegym.case_module3.service.author.AuthorService;
import com.codegym.case_module3.service.category.CategoryService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class BookService implements IBookService {
    AuthorService authorService = new AuthorService();
    CategoryService categoryService = new CategoryService();
    ConnectionMySQL connectionMySQL = new ConnectionMySQL();

    private static BookService instance;
    private DatabaseHandler<Book> bookDBHandler = DatabaseHandler.getInstance();
    private final String BOOK_TABLE = "book";

    private BookService() {

    }

    public static BookService getInstance() {
        if (instance == null) {
            instance = new BookService();
            return instance;
        }
        return instance;
    }

    private PreparedStatement setPreparedStatement(PreparedStatement pre, Book book) throws SQLException {
        pre.setString(1, book.getTitle());
        pre.setInt(2, book.getCategoryId().getId());
        pre.setInt(3, book.getAuthorId().getId());
        pre.setInt(4, book.getPublishYear());
        pre.setString(5, book.getDescription());
        pre.setString(6, book.getImage());
        pre.setInt(7, book.getViews());
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
             PreparedStatement pre = connection.prepareStatement(insert)) {
            createRow = setPreparedStatement(pre, book).executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return createRow;
    }

    @Override
    public HashMap<Integer, Book> find(String condition) {
        ResultSet rs = bookDBHandler.findAllByCondition(BOOK_TABLE, condition);
        HashMap<Integer, Book> bookHashMap = new HashMap<>();
        try {
            while (rs.next()) {
                int id = rs.getInt("id");
                int catId = rs.getInt("category_id");
                int authorId = rs.getInt("author_id");
                int publishYear = rs.getInt("publish_year");
                int views = rs.getInt("views");
                int quantity = rs.getInt("quantity");
                int price = rs.getInt("price");
                String title = rs.getString("title");
                String description = rs.getString("description");
                String image = rs.getString("image");
                Author author = AuthorService.getInstance().findById(authorId);
                Category category = CategoryService.getInstance().findById(catId);
                Book book = new Book(id, title, author, category, publishYear, image, description, price, views, quantity);
                bookHashMap.put(id, book);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookHashMap;
    }

    @Override
    public Book findById(int id) {
        String selectById = "select * from book where id = ?";
        Book book = null;
        try (Connection connection = connectionMySQL.getConnection();
             PreparedStatement pre = connection.prepareStatement(selectById)) {
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
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
        Author author = authorService.findById(author_id);
        Category category = categoryService.findById(category_id);
        book = new Book(id, title, author, category, publish_year, image, description, price, views, quantity);
        return book;

    }

    @Override
    public boolean delete(int id) {
        String delete = "delete from book where (id = ?);";
        boolean deleteRow = false;
        try (Connection connection = connectionMySQL.getConnection();
             PreparedStatement pre = connection.prepareStatement(delete)) {
            pre.setInt(1, id);
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
        try (Connection connection = connectionMySQL.getConnection();
             PreparedStatement pre = connection.prepareStatement(update)) {
            PreparedStatement preparedStatement = setPreparedStatement(pre, book);
            preparedStatement.setInt(10, book.getId());

            updateRow = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updateRow;
    }
}
