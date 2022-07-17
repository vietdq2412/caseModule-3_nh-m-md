package com.codegym.case_module3.service.account;

import com.codegym.case_module3.model.Account;

import java.sql.*;
import java.util.List;

public class AccountService implements IAccountService {
    @Override
    public void insert(Account account) throws SQLException {

    }

    @Override
    public Account selectById(int id) throws SQLException {
        return null;
    }

    @Override
    public Account selectByEmailAndPass(String email, String password) {
        return null;
    }

    @Override
    public List<Account> selectAll() {
        return null;
    }

    @Override
    public boolean delete(int id) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Account account) throws SQLException {
        return false;
    }

//    ConnectionMySQL connectionMySQL = new ConnectionMySQL();
//
//    @Override
//    public void insert(Account account) throws SQLException {
//        String insert = "INSERT INTO account (full_name, username, password, address, email, phone_number, role_id) " +
//                    "VALUES (?, ?, ?, ?, ?, ?, ?);";
//
//        try (Connection connection = connectionMySQL.getConnection();
//             PreparedStatement pre = connection.prepareStatement(insert)) {
//            pre.setString(1, account.getFullName());
//            pre.setString(2, account.getUsername());
//            pre.setString(3, account.getPassword());
//            pre.setString(4, account.getAddress());
//            pre.setString(5, account.getEmail());
//            pre.setString(6, account.getPhoneNumber());
//            pre.setInt(7, account.getRoleId());
//
//            System.out.println(pre);
//            pre.executeUpdate();
//        }
//
//
//    }
//
//    @Override
//    public Account selectById(int id) throws SQLException {
//        String selectById = "select * from account where id = ?";
//        Account account = null;
//        try(Connection connection = connectionMySQL.getConnection();
//        PreparedStatement pre = connection.prepareStatement(selectById);){
//            pre.setInt(1, id);
//            ResultSet rs = pre.executeQuery();
//
//            while (rs.next()){
//                account = getAllAccount(rs);
//            }
//        }
//        return account;
//    }
//
//    private Account getAllAccount(ResultSet rs) throws SQLException {
//        Account account = null;
//        int id = rs.getInt("id");
//        String fullName = rs.getString("full_name");
//        String username = rs.getString("username");
//        String pass = rs.getString("password");
//        String address = rs.getString("address");
//        String email = rs.getString("email");
//        String phone = rs.getString("phone_number");
//        int roleId = rs.getInt("role_id");
//        account = new Account(id, fullName, username, pass, address, email, phone, roleId);
//        return account;
//    }
//
//    @Override
//    public Account selectByEmailAndPass(String email, String password) {
//        String selectAccount = "select * from account where email = ? and password = ?; ";
//        Account account = null;
//        try(Connection con = connectionMySQL.getConnection();
//            PreparedStatement pre = con.prepareStatement(selectAccount)){
//            pre.setString(1, email);
//            pre.setString(2, password);
//            ResultSet rs =pre.executeQuery();
//
//            while (rs.next()){
//               account = getAllAccount(rs);
//            }
//            if(account != null){
//                return account;
//            }
//        }catch (SQLException e){
//        }
//        return account;
//    }
//
//    @Override
//    public List<Account> selectAll() {
//        String selectAll = "select * from account;";
//        List<Account> accounts = new ArrayList<>();
//        try (Connection connection = connectionMySQL.getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(selectAll)) {
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//
//            while (rs.next()) {
//               Account account = getAllAccount(rs);
//                accounts.add(account);
//            }
//        } catch (SQLException e) {
//        }
//        return accounts;
//    }
//
//    @Override
//    public boolean delete(int id) throws SQLException {
//        String delete = "delete from account WHERE id = ?;";
//        boolean rowDelete = false;
//        try(Connection connection = connectionMySQL.getConnection();
//            PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
//            preparedStatement.setInt(1, id);
//            rowDelete = preparedStatement.executeUpdate() > 0;
//        }
//
//        return rowDelete;
//    }
//
//    @Override
//    public boolean update(Account account) throws SQLException {
//        String update = "update account set full_name = ?, username = ?, password = ?, address = ?," +
//                " email = ?, phone_number = ?, role_id = ? where (id = ?);";
//        boolean updateRow = false;
//        try(Connection connection = connectionMySQL.getConnection();
//            PreparedStatement pre = connection.prepareStatement(update);) {
//            pre.setString(1, account.getFullName());
//            pre.setString(2, account.getUsername());
//            pre.setString(3, account.getPassword());
//            pre.setString(4, account.getAddress());
//            pre.setString(5, account.getEmail());
//            pre.setString(6, account.getPhoneNumber());
//            pre.setInt(7, account.getRoleId());
//            pre.setInt(8,account.getId());
//            updateRow = pre.executeUpdate() > 0;
//        }
//        return updateRow;
//    }
}
