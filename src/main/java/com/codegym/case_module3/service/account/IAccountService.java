package com.codegym.case_module3.service.account;

import com.codegym.case_module3.model.Account;
import com.codegym.case_module3.service.IService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface IAccountService extends IService<Account> {
    @Override
    boolean create(Account account);
    @Override
    HashMap<Integer, Account> find(String condition);
    @Override
    Account findById(int id);
    @Override
    boolean delete(int id);
    @Override
    boolean update(Account account);
    Account findByEmailAndPass(String email, String password);

}
