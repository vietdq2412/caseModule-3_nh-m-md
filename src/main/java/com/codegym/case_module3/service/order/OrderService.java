package com.codegym.case_module3.service.order;

import com.codegym.case_module3.model.Order;
import com.codegym.case_module3.service.DatabaseHandler;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

public class OrderService implements IOrderService{
    private final String ORDER_TABLE = "`order`";
    private DatabaseHandler<Order> orderDBHandler = DatabaseHandler.getInstance();
    private static OrderService instance;

    public OrderService() {

    }

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
            return instance;
        }
        return instance;
    }

    @Override
    public boolean create(Order order) {
        return orderDBHandler.insertData(ORDER_TABLE, order, order.getColumns());
    }

    @Override
    public HashMap<Integer, Order> find(String condition) {
        ResultSet rs = orderDBHandler.findAllByCondition(ORDER_TABLE,condition);
        HashMap<Integer, Order> orderHashMap = new HashMap<>();
        try {
            while (rs.next()){
                int id = rs.getInt("id");
                Date createTime = rs.getDate("createTime");
                double totalPrice = rs.getDouble("totalPrice");
                int accountId = rs.getInt("accountId");
                int orderStatusId = rs.getInt("orderStatusId");
                Order order = new Order(id, createTime, totalPrice, accountId, orderStatusId);
                orderHashMap.put(id, order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderHashMap;
    }

    public int findOrder(String condition) {
        ResultSet rs = orderDBHandler.findAllByCondition(ORDER_TABLE,condition);
        List<Integer> list = new ArrayList<>();
        try {
            while (rs.next()){
                int id = rs.getInt("id");
                Date createTime = rs.getDate("create_time");
                double totalPrice = rs.getDouble("total_price");
                int accountId = rs.getInt("account_id");
                int orderStatusId = rs.getInt("order_status_id");
                return id;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public Order findById(int id) {
        String condition = "Where id = " + id;
        return find(condition).get(id);
    }

    @Override
    public boolean update(Order order) {
        String sql = "update " + ORDER_TABLE + " set create_time = '" + order.getCreateTime() +
                "', total_price = '" + order.getTotalPrice() +
                "', account_id = " + order.getAccountId() +
                ", order_status_id = '" + order.getOrderStatusId() + ";";
        return orderDBHandler.updateData(sql);
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from " + ORDER_TABLE + " where id = " + id;
        return orderDBHandler.deleteData(sql);
    }

    public int findAllByUserId(int userId) {
        String condition = "where account_id = " + userId + " and order_status_id = 1";
        return findOrder(condition);
    }

}
