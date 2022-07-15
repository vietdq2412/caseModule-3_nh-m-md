package com.codegym.case_module3.model;

public class Category {
    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "'" + name + "'";
    }

    public String getColumns() {
        return "name";
    }
}
