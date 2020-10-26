package com.example.menuforweek.Entities;

import com.example.menuforweek.Interface.Product;

import java.io.Serializable;

public class Product_raw implements Serializable, Product {

    private int id;
    private String prodCategory;
    private String volType;
    private String name;

    public Product_raw() {}
    public Product_raw(String prodCategory, String volType, String name) {
        this.prodCategory = prodCategory;
        this.volType = volType;
        this.name = name;
    }

    @Override
    public int getID() {
        return this.id;
    }

    @Override
    public void setID(int id) {
        this.id = id;
    }

    @Override
    public String getProdCategory() {
        return prodCategory;
    }

    @Override
    public void setProdCategory(String prodCategoryID) {
        this.prodCategory = prodCategoryID;
    }

    @Override
    public String getVolType() {
        return volType;
    }

    @Override
    public void setVolType(String volID) {
        this.volType = volID;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
