package com.codegym.case_module3.controller;

import com.codegym.case_module3.model.Order;
import com.codegym.case_module3.service.order.OrderService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "OderController", urlPatterns = "/orders")
public class OderController extends HttpServlet {
    OrderService orderService = new OrderService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch (action){
            case "view":
                break;
            case "change":
                break;
            default:
                showAllOrder(request, response);
        }
    }

    private void showAllOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HashMap<Integer, Order> orders = orderService.find("");
        request.setAttribute("orders", orders);
        request.getRequestDispatcher("views/order/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
