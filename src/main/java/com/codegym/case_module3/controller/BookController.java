package com.codegym.case_module3.controller;

import com.codegym.case_module3.model.Book;
import com.codegym.case_module3.service.book.BookServiec;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

@WebServlet(name = "BookServlet", urlPatterns = "/books")
public class BookController extends HttpServlet {
    BookServiec bookServiec;

    @Override
    public void init() {
        bookServiec = new BookServiec();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    showFormCreate(request, response);
                    break;
                case "edit":
                    showFormEdit(request, response);
                    break;
                case "delete":
                        deleteBooks(request, response);
                    break;
                default:
                    showAllBook(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void deleteBooks(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookServiec.delete(id);
        response.sendRedirect("/books");

    }

    private void showFormEdit(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookServiec.findById(id);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/book/edit.jsp");
        request.setAttribute("book", book);
        requestDispatcher.forward(request, response);
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/book/create.jsp");
        requestDispatcher.forward(request,response);
    }

    private void showAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<Integer, Book> books = bookServiec.find("");
        request.setAttribute("listBook", books.values());
        RequestDispatcher resRequestDispatcher = request.getRequestDispatcher("views/book/list.jsp");
        resRequestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        try {
            switch (action){
                case "create":
                    createBook(request, response);
                    break;
                case "edit":
                    editBook(request, response);
                    break;
                default:
                    showAllBook(request, response);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private Book getAllBook(HttpServletRequest request, HttpServletResponse response) {
        String title = request.getParameter("title");
        int categoryId = Integer.parseInt(request.getParameter("categoryId"));
        int authorId = Integer.parseInt(request.getParameter("authorId"));
        int publishYear = Integer.parseInt(request.getParameter("publishYear"));
        String description = request.getParameter("description");
        String image = request.getParameter("image");
        int views = Integer.parseInt(request.getParameter("views"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        double price = Double.parseDouble(request.getParameter("price"));

        return new Book(title, categoryId, authorId, publishYear,image, description, price, views, quantity);
    }
    private void editBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Book book = getAllBook(request, response);
        int id = Integer.parseInt(request.getParameter("id"));
        book.setId(id);
        bookServiec.update(book);
        response.sendRedirect("/books");
    }

    private void createBook(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        Book book = getAllBook(request, response);
        bookServiec.create(book);
        response.sendRedirect("/books");

    }
}
