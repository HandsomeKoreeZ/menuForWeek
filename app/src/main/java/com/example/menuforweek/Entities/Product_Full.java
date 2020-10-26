package com.example.menuforweek.Entities;

import com.example.menuforweek.Interface.Product;

import java.io.Serializable;

public class Product_Full implements Serializable, Product {
    private int id;
    private String prodCategory;
    private String volType;
    private String name;
    private int volume;

    public Product_Full() {}
    public Product_Full(Product product, int volume){
        this.volume = volume;
    }
    public Product_Full(String prodCategory, String volType, String name, int volume) {
        this.prodCategory = prodCategory;
        this.volType = volType;
        this.name = name;
        this.volume=volume;
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
        return this.prodCategory;
    }

    @Override
    public void setProdCategory(String category) {
        this.prodCategory=category;
    }

    @Override
    public String getVolType() {
        return this.volType;
    }

    @Override
    public void setVolType(String volType) {
        this.volType = volType;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public int getVolume(){
        return this.volume;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }
}
