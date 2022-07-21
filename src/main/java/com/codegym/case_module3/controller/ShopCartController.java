package com.codegym.case_module3.controller;

import com.codegym.case_module3.model.Account;
import com.codegym.case_module3.model.Book;
import com.codegym.case_module3.model.Order;
import com.codegym.case_module3.model.OrderDetail;
import com.codegym.case_module3.service.account.AccountService;
import com.codegym.case_module3.service.order.OrderDetailService;
import com.codegym.case_module3.service.order.OrderService;
import com.google.gson.Gson;

import java.io.PrintWriter;
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
    private AccountService accountService = new AccountService();
    private HttpSession session;
    private Gson gson = new Gson();
    private Account curUser;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        session = request.getSession();
        curUser = (Account) session.getAttribute("user");
        request.setAttribute("currentUser", curUser);
        String action = "";
        action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "getCartData":
                getCartData(request, response);
                break;
            case "checkout":
                showCheckoutPage(request, response);
                break;
            default:
                showShopCart(request, response, session);
        }
    }

    private void showCheckoutPage(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ashion-master/checkout.jsp");
        try {
            if (session.getAttribute("user") != null) {
                requestDispatcher.forward(request, response);
            }else {
                response.sendRedirect("/");
            }
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void getCartData(HttpServletRequest request, HttpServletResponse response) {
        session = request.getSession();
        Account account = (Account) session.getAttribute("user");
        if (account==null){
            try {
                response.sendRedirect("/");
                return;
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Order orderInCart = orderService.findOrderInCart(account.getId());
        if (orderInCart == null){
            orderService.create(new Order(account.getId(), 1));
            orderInCart = orderService.findOrderInCart(account.getId());
        }
        HashMap<Integer, OrderDetail> orderDetailHashMap = orderDetailService.findByOrderId(orderInCart.getId());
        String bookData = gson.toJson(orderDetailHashMap.values());
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        out.print(bookData);
        out.flush();
    }

    private void showShopCart(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/ashion-master/shop-cart.jsp");
        if (session.getAttribute("user") != null) {
            requestDispatcher.forward(request, response);
        }else {
            response.sendRedirect("/");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        String action = "";
        action = request.getParameter("action");

        if (action == null) {
            action = "";
        }

        switch (action) {
            case "addToCart":
                addBookToCart(request, response);
            default:
        }
    }

    private void addBookToCart(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") != null) {
            Account user = (Account) session.getAttribute("user");
            Order cart = orderService.findOrderInCart(user.getId());
            HashMap<Integer,OrderDetail> orderDetailHashMap = orderDetailService.findByOrderId(cart.getId());
            int quantity = Integer.parseInt(request.getParameter("quantity"));
            int bookId = Integer.parseInt(request.getParameter("bookId"));
            if (orderDetailHashMap.containsKey(bookId)){
                int preQuantity = orderDetailHashMap.get(bookId).getQuantity();
                OrderDetail existedItem = orderDetailHashMap.get(bookId);
                existedItem.setQuantity(preQuantity+quantity);
                orderDetailService.update(existedItem);
            }else {
                OrderDetail orderDetail = new OrderDetail(quantity, cart.getId(), 0,new Book(bookId));
                orderDetailService.create(orderDetail);
            }
            try {
                response.sendRedirect("shop-carts");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                response.sendRedirect("/");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
