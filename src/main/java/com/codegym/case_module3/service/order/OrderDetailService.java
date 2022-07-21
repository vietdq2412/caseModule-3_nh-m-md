package com.codegym.case_module3.service.order;

import com.codegym.case_module3.model.Book;
import com.codegym.case_module3.model.OrderDetail;
import com.codegym.case_module3.service.DatabaseHandler;
import com.codegym.case_module3.service.book.BookService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

public class OrderDetailService implements IOrderDetailService {
    private final String ORDER_DETAIL_TABLE = "order_detail";
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
                int orderId = rs.getInt("order_id");
                double totalPrice = rs.getDouble("total_price");
                int bookId = rs.getInt("book_id");
                Book book = BookService.getInstance().findById(bookId);
                OrderDetail orderDetail = new OrderDetail(id, quantity, orderId, totalPrice, book);
                orderDetailHashMap.put(id, orderDetail);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return orderDetailHashMap;
    }

    public HashMap<Integer, OrderDetail> finItemsInCart(String condition){
        ResultSet rs = orderDetailDBHandler.findAllByCondition(ORDER_DETAIL_TABLE,condition);
        HashMap<Integer, OrderDetail> orderDetailHashMap = new HashMap<>();
        try {
            while (rs.next()){
                int id = rs.getInt("id");
                int quantity = rs.getInt("quantity");
                int orderId = rs.getInt("order_id");
                double totalPrice = rs.getDouble("total_price");
                int bookId = rs.getInt("book_id");
                Book book = BookService.getInstance().findById(bookId);
                OrderDetail orderDetail = new OrderDetail(id, quantity, orderId, totalPrice, book);
                orderDetailHashMap.put(bookId, orderDetail);
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

    public HashMap<Integer, OrderDetail> findByOrderId(int orderId) {
        HashMap<Integer, OrderDetail> orderDetailList;
        String condition = "where order_id = " + orderId;
        orderDetailList = finItemsInCart(condition);
        return orderDetailList;
    }
}
