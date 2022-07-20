package com.codegym.case_module3.service.category;


import com.codegym.case_module3.model.Category;
import com.codegym.case_module3.service.IService;

import java.util.HashMap;

public interface ICategoryService extends IService<Category> {
    HashMap<Integer, Integer> findQuantity();
}
