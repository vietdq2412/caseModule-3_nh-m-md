package com.codegym.case_module3.controller;

import com.codegym.case_module3.model.Author;
import com.codegym.case_module3.model.Book;
import com.codegym.case_module3.model.Category;
import com.codegym.case_module3.service.author.AuthorService;
import com.codegym.case_module3.service.book.BookService;
import com.codegym.case_module3.service.category.CategoryService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "BookDetailServlet", value = "/book-details")
public class BookDetailController extends HttpServlet {
    BookService bookService = new BookService();
    AuthorService authorService = new AuthorService();
    CategoryService categoryService = new CategoryService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        action = request.getParameter("action");

        if(action == null) {
            action = "";
        }

        switch (action) {
            default:
                showProductInfor(request, response);
        }
    }

    private void showProductInfor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ashion-master/book-details.jsp");
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.findById(id);
        Author author = authorService.findById(book.getAuthorId().getId());
        Category category = categoryService.findById(book.getCategoryId().getId());
        request.setAttribute("book",book);
        request.setAttribute("category",category);
        request.setAttribute("author",author);
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
