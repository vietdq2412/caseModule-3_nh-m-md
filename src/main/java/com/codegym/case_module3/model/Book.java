package com.codegym.case_module3.model;

public class Book {
    private String title;
    private int authorId;
    private int categoryId;
    private String image;
    private String description;
    private int price;
    private int views;


    private int quantity;

    public Book(String title, int authorId, int categoryId, String image, int price, String description, int quantity,int views) {
        this.title = title;
        this.authorId = authorId;
        this.categoryId = categoryId;
        this.image = image;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
        this.views = views;
    }

    @Override
    public String toString() {
        return "\"" + title + "\", " + authorId + ", " + categoryId + ", '" +
                image +"', "+ price+", \""+description+"\", "+quantity+", "+ views;
    }

    public String getColumns() {
        return "title, author_id, category_id, image, price, description, quantity, views";
    }

}
