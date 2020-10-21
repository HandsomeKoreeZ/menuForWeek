package com.example.menuforweek.Entities;

import java.io.Serializable;

public class Product implements Serializable {

    private int id;
    private String prodCategory;
    private String volType;
    private String name;

    public Product() {}
    public Product(String prodCategoryID, String volID, String name) {
        this.prodCategory = prodCategoryID;
        this.volType = volID;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProdCategoryID() {
        return prodCategory;
    }

    public void setProdCategoryID(String prodCategoryID) {
        this.prodCategory = prodCategoryID;
    }

    public String getVolID() {
        return volType;
    }

    public void setVolID(String volID) {
        this.volType = volID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
