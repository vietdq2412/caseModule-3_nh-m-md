package com.codegym.case_module3.model;

public class Author {
    private int id;
    private String name;

    public Author(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "\"" + name + "\"";
    }

    public String getColumns() {
        return "name";
    }
}
