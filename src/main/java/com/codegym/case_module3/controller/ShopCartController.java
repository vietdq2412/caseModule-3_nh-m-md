package com.codegym.case_module3.controller;

import com.codegym.case_module3.model.OrderDetail;
import com.codegym.case_module3.service.order.OrderDetailService;
import com.codegym.case_module3.service.order.OrderService;
import java.util.*;

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
    OrderService orderService = new OrderService();
    OrderDetailService orderDetailService = new OrderDetailService();
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
                showAddShopCart(request, response, session);
        }
    }

    private void showAddShopCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ServletException {
        if(session.getAttribute("userId") != null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ashion-master/shop-cart.jsp");
            int userId = (int) session.getAttribute("userId");
            int orderId = orderService.findAllByUserId(userId);
            List<OrderDetail> orderDetailList = orderDetailService.findByOrderId(orderId);
            request.setAttribute("orderDetailList", orderDetailList);
            requestDispatcher.forward(request, response);
        }
        else {
            response.sendRedirect("/");
        }
    }
}
