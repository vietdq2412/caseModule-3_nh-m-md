package com.codegym.case_module3.controller;

import com.codegym.case_module3.model.Author;
import com.codegym.case_module3.model.Book;
import com.codegym.case_module3.model.Category;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShopCartServlet", value = "/shop-carts")
public class ShopCartController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = "";
        action = request.getParameter("action");

        if(action == null) {
            action = "";
        }

        switch (action) {
            default:
                showShopCart(request, response);
        }
    }

    private void showShopCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ashion-master/shop-cart.jsp");
        int id = Integer.parseInt(request.getParameter("id"));

        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
