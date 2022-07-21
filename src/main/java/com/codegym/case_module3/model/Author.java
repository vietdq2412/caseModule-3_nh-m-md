package com.codegym.case_module3.model;

import java.sql.Date;

public class Author {
    private int id;
    private String name;
    private Date dateOfBirth;
    private int numberOfArts;
    private String nation;
    private String image;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public Author(int id, String name, Date dateOfBirth, int numberOfArts, String nation, String image) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.numberOfArts = numberOfArts;
        this.nation = nation;
        this.image = image;
    }

    public Author(String name, Date dateOfBirth, int numberOfArts, String nation, String image) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.numberOfArts = numberOfArts;
        this.nation = nation;
        this.image = image;
    }
    public Author(String name, int numberOfArts, String nation, String image) {
        this.name = name;
        this.dateOfBirth = Date.valueOf("2001-07-01");
        this.numberOfArts = numberOfArts;
        this.nation = nation;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getNumberOfArts() {
        return numberOfArts;
    }

    public void setNumberOfArts(int numberOfArts) {
        this.numberOfArts = numberOfArts;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "'" + name + "', " + dateOfBirth + ", '" + numberOfArts + "', '" + nation + "', '" + image + "'";
    }

    public String getColumns() {
        return "name, date_of_birth, number_of_arts, nation, image";
    }
}
