package com.codegym.case_module3.service.order;

import com.codegym.case_module3.model.Order;
import com.codegym.case_module3.model.OrderDetail;
import com.codegym.case_module3.model.OrderStatus;
import com.codegym.case_module3.service.DatabaseHandler;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class OrderStatusService implements IOrderStatusService {
    private final String ORDER_STATUS_TABLE = "order_status";
    private DatabaseHandler<Order> orderStatusDBHandler = DatabaseHandler.getInstance();
    private static OrderService instance;

    public OrderStatusService() {
    }

    @Override
    public boolean create(OrderStatus orderStatus) {
        return false;
    }

    @Override
    public HashMap<Integer, OrderStatus> find(String condition) {
        ResultSet rs = orderStatusDBHandler.findAllByCondition(ORDER_STATUS_TABLE,condition);
        HashMap<Integer, OrderStatus> orderStatusHashMap = new HashMap<>();
        try {
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                OrderStatus orderStatus = new OrderStatus(id, name);
                orderStatusHashMap.put(id, orderStatus);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderStatusHashMap;
    }

    @Override
    public OrderStatus findById(int id) {
        String condition = "Where id = " + id;
        return find(condition).get(id);
    }

    @Override
    public boolean update(OrderStatus orderStatus) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
