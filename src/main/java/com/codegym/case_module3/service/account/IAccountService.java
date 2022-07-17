package com.codegym.case_module3.service.account;

import com.codegym.case_module3.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService {
    public void insert(Account account) throws SQLException;

    public Account selectById(int id) throws SQLException;

    public Account selectByEmailAndPass(String email, String password);

    public List<Account> selectAll();

    public boolean delete(int id) throws SQLException;

    public boolean update(Account account) throws SQLException;

}
