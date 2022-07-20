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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ShopCartServlet", value = "/shop-carts")
public class ShopCartController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String action = "";
        action = request.getParameter("action");

        if(action == null) {
            action = "";
        }

        switch (action) {
            default:
                showShopCart(request, response, session);
        }
    }

    private void showShopCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ashion-master/shop-cart.jsp");
        if(session.getAttribute("userId") != null) {
            int userId = (int) session.getAttribute("userId");
        }

        requestDispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
