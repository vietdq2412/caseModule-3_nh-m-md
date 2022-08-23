package com.codegym.case_module3.service.account;

import com.codegym.case_module3.connect.ConnectionMySQL;
import com.codegym.case_module3.model.Account;
import com.codegym.case_module3.model.Role;

import java.sql.*;
import java.util.HashMap;

public class AccountService implements IAccountService {

    ConnectionMySQL connectionMySQL = new ConnectionMySQL();

    private PreparedStatement setPreparedStatement(PreparedStatement pre, Account account) throws SQLException {
        pre.setString(1, account.getFullName());
        pre.setString(2, account.getUsername());
        pre.setString(3, account.getPassword());
        pre.setString(4, account.getAddress());
        pre.setString(5, account.getEmail());
        pre.setString(6, account.getPhoneNumber());
        pre.setInt(7, account.getRole().getId());

        return pre;
    }

    @Override
    public boolean create(Account account) {
        boolean createRow = false;
        String insert = "INSERT INTO account (full_name, username, password, address, email, phone_number, role_id) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?);";

        try (Connection connection = connectionMySQL.getConnection();
             PreparedStatement pre = connection.prepareStatement(insert)) {
            createRow = setPreparedStatement(pre, account).executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return createRow;

    }

    @Override
    public Account findById(int id) {
        String selectById = "select * from account where id = ?";
        Account account = null;
        try(Connection connection = connectionMySQL.getConnection();
        PreparedStatement pre = connection.prepareStatement(selectById);){
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();

            while (rs.next()){
                account = getAllAccount(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return account;
    }
    @Override
    public HashMap<Integer, Account> findByRole(int role) {
        String selectByRole = "select * from account where role_id = ?;";
        HashMap<Integer, Account> accounts = new HashMap<>();
        try (Connection connection = connectionMySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByRole)) {
            preparedStatement.setInt(1, role);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Account account = getAllAccount(rs);
                accounts.put(account.getId(),account);
            }
        } catch (SQLException e) {
        }
        return accounts;
    }

    @Override
    public HashMap<Integer, Account> findByName(String name) {
        String selectByName = "select * from account where (full_name like ?) or (username like ?)" ;
        HashMap<Integer, Account> accounts = new HashMap<>();
        try (Connection connection = connectionMySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectByName)) {
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, name);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                Account account = getAllAccount(rs);
                accounts.put(account.getId(),account);
            }
        } catch (SQLException e) {
        }
        return accounts;
    }

    private Account getAllAccount(ResultSet rs) throws SQLException {
        Account account = null;
        int id = rs.getInt("id");
        String fullName = rs.getString("full_name");
        String username = rs.getString("username");
        String pass = rs.getString("password");
        String address = rs.getString("address");
        String email = rs.getString("email");
        String phone = rs.getString("phone_number");
        int roleId = rs.getInt("role_id");
        Role role;
        if(roleId == 1){
            role = new Role(1,"ROLE_ADMIN");
        }
        else {
            role = new Role(2, "ROLE_USER");
        }
        account = new Account(id, fullName, username, pass, address, email, phone, role);
        return account;
    }

    @Override
    public Account findByEmailAndPass(String email, String password) {
        String selectAccount = "select * from account where email = ? and password = ?; ";
        Account account = null;
        try(Connection con = connectionMySQL.getConnection();
            PreparedStatement pre = con.prepareStatement(selectAccount)){
            pre.setString(1, email);
            pre.setString(2, password);
            ResultSet rs =pre.executeQuery();

            while (rs.next()){
               account = getAllAccount(rs);
            }
            if(account != null){
                return account;
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        return account;
    }

    @Override
    public HashMap<Integer, Account> find(String condition) {
        String selectAll = "select * from account order by id asc "+condition;
        HashMap<Integer, Account> accounts = new HashMap<>();
        try (Connection connection = connectionMySQL.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(selectAll)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
               Account account = getAllAccount(rs);
                accounts.put(account.getId(),account);
            }
        } catch (SQLException e) {
        }
        return accounts;
    }

    @Override
    public boolean delete(int id) {
        String delete = "delete from account WHERE id = ?;";
        boolean rowDelete = false;
        try(Connection connection = connectionMySQL.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(delete)) {
            preparedStatement.setInt(1, id);
            rowDelete = preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return rowDelete;
    }

    @Override
    public boolean update(Account account) {
        String update = "update account set full_name = ?, username = ?, password = ?, address = ?," +
                " email = ?, phone_number = ?, role_id = ? where (id = ?);";
        boolean updateRow = false;
        try(Connection connection = connectionMySQL.getConnection();
            PreparedStatement pre = connection.prepareStatement(update);) {
            PreparedStatement preparedStatement = setPreparedStatement(pre, account);
            preparedStatement.setInt(8, account.getId());

            updateRow = preparedStatement.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return updateRow;
    }
}
