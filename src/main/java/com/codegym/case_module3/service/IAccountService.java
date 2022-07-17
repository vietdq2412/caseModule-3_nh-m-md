package com.codegym.case_module3.service;

import com.codegym.case_module3.model.Account;

import java.sql.SQLException;
import java.util.List;

public interface IAccountService extends Icrud<Account> {
    @Override
    List<Account> selectAll();
    @Override
    Account selectById(int id) throws SQLException;
    @Override
    void insert(Account account) throws SQLException;
    @Override
    boolean delete(int id) throws SQLException;
    @Override
    boolean update(Account account) throws SQLException;

    Account selectByEmailAndPass(String email, String password);

}
