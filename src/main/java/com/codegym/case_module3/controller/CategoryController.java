package com.codegym.case_module3.controller;

import com.codegym.case_module3.model.Category;
import com.codegym.case_module3.service.category.CategoryService;
import com.codegym.case_module3.service.category.ICategoryService;
import com.google.gson.Gson;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet(name = "CategoryServlet", value = "/category")
public class CategoryController extends HttpServlet {
    private ICategoryService categoryService = CategoryService.getInstance();
    private Gson gson = new Gson();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        action = request.getParameter("action");
        switch (action) {
            case "create":
                createForm(request, response);
                break;
            case "list":
                showList(request, response, "");
                break;
            default:
                request.getRequestDispatcher("views/test.jsp").forward(request, response);
        }
    }

    private void showList(HttpServletRequest request, HttpServletResponse response, String condition) {
        HashMap<Integer, Category> categoryHashMap = categoryService.find(condition);
        String categoryData = gson.toJson(categoryHashMap.values());
        System.out.println(categoryData);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(categoryData);
        out.flush();
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("views/category/create.jsp");
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        action = request.getParameter("action");
        switch (action) {
            case "create":
                createCategory(request, response);
                break;
            case "edit":
                break;
            default:
                request.getRequestDispatcher("views/test.jsp").forward(request, response);
        }
    }

    private void createCategory(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        Category category = new Category(name);
        try {
            categoryService.create(category);
            response.sendRedirect("/category?action=list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
