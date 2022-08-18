package com.codegym.case_module3.model;

public class Book {
    private int id;
    private String title;
    private Author authorId;
    private Category categoryId;
    private int publishYear;
    private String image;
    private String description;
    private double price;
    private int views;
    private int quantity;

    public Book() {
    }

    public Book(int id) {
        this.id = id;
    }

    public Book(int id, String title, Author authorId, Category categoryId, int publishYear, String image, String description, double price, int views, int quantity) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.categoryId = categoryId;
        this.publishYear = publishYear;
        this.image = image;
        this.description = description;
        this.price = price;
        this.views = views;
        this.quantity = quantity;
    }

    public Book(String title, Author authorId, Category categoryId, int publishYear, String image, String description, double price, int views, int quantity) {
        this.title = title;
        this.authorId = authorId;
        this.categoryId = categoryId;
        this.publishYear = publishYear;
        this.image = image;
        this.description = description;
        this.price = price;
        this.views = views;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Author authorId) {
        this.authorId = authorId;
    }

    public Category getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Category categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
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
