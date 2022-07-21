package com.codegym.case_module3.model;

import java.sql.Date;

public class Order {
    private int id;
    private Date createTime;
    private double totalPrice;
    private int accountId;
    private int orderStatusId;

    public Order() {
    }

    public Order(int accountId, int orderStatusId) {
        this.accountId = accountId;
        this.orderStatusId = orderStatusId;
    }

    public Order(int id, Date createTime, double totalPrice, int accountId, int orderStatusId) {
        this.id = id;
        this.createTime = createTime;
        this.totalPrice = totalPrice;
        this.accountId = accountId;
        this.orderStatusId = orderStatusId;
    }

    public Order(Date createTime, double totalPrice, int accountId, int orderStatusId) {
        this.createTime = createTime;
        this.totalPrice = totalPrice;
        this.accountId = accountId;
        this.orderStatusId = orderStatusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Override
    public String toString() {
        return "" + createTime + ", " + totalPrice + ", '" + accountId + "', " + orderStatusId ;
    }

    public String getColumns() {
        return "create_time, total_price, account_id, order_status_id";
    }
}
