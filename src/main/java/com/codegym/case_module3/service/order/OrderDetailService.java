package com.codegym.case_module3.service.order;

import com.codegym.case_module3.model.OrderDetail;
import com.codegym.case_module3.service.DatabaseHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class OrderDetailService implements IOrderDetailService {
    private final String ORDER_DETAIL_TABLE = "order-detail";
    private DatabaseHandler<OrderDetail> orderDetailDBHandler = DatabaseHandler.getInstance();
    private static OrderDetailService instance;

    public OrderDetailService() {

    }

    public static OrderDetailService getInstance() {
        if (instance == null) {
            instance = new OrderDetailService();
            return instance;
        }
        return instance;
    }

    @Override
    public boolean create(OrderDetail orderDetail) {
        return orderDetailDBHandler.insertData(ORDER_DETAIL_TABLE, orderDetail, orderDetail.getColumns());
    }

    @Override
    public HashMap<Integer, OrderDetail> find(String condition) {
        ResultSet rs = orderDetailDBHandler.findAllByCondition(ORDER_DETAIL_TABLE,condition);
        HashMap<Integer, OrderDetail> orderDetailHashMap = new HashMap<>();
        try {
            while (rs.next()){
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                int orderId = rs.getInt("orderId");
                double totalPrice = rs.getDouble("totalPrice");
                int bookId = rs.getInt("bookId");
                OrderDetail order = new OrderDetail(id, quantity, orderId, totalPrice, bookId);
                orderDetailHashMap.put(id, order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailHashMap;
    }

    @Override
    public OrderDetail findById(int id) {
        String condition = "Where id = " + id;
        return find(condition).get(id);
    }

    @Override
    public boolean update(OrderDetail orderDetail) {
        String sql = "update " + ORDER_DETAIL_TABLE + " set  = quantity'" + orderDetail.getQuantity() +
                "', order_id = '" + orderDetail.getOrderId() +
                "', total_price = " + orderDetail.getTotalPrice() +
                ", book_id = '" + orderDetail.getTotalPrice() + ";";
        return orderDetailDBHandler.updateData(sql);
    }

    @Override
    public boolean delete(int id) {
        String sql = "delete from " + ORDER_DETAIL_TABLE + " where id = " + id;
        return orderDetailDBHandler.deleteData(sql);
    }
}
