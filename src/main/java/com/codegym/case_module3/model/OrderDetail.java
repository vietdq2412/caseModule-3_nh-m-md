package com.codegym.case_module3.model;

public class OrderDetail {
    private int id;
    private int quantity;
    private int orderId;
    private double totalPrice;
    private Book book;

    public OrderDetail() {
    }

    public OrderDetail(int id, int quantity, int orderId, double totalPrice, Book book) {
        this.id = id;
        this.quantity = quantity;
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.book = book;
    }

    public OrderDetail(int quantity, int orderId, double totalPrice, Book book) {
        this.quantity = quantity;
        this.orderId = orderId;
        this.totalPrice = totalPrice;
        this.book = book;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "'" + quantity + "', " + orderId + ", '" + totalPrice + "', '" + book.getId() + "'";
    }

    public String getColumns() {
        return "quantity, orderId, totalPrice, bookId";
    }
}
