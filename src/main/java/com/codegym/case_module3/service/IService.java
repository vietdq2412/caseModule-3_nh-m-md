package com.codegym.case_module3.service;

import java.util.HashMap;

public interface IService<T> {
    boolean create(T t);
    HashMap<Integer, T> find(String condition);
    T findById(int id);
    boolean update(T t);
    boolean delete(int id);
}
