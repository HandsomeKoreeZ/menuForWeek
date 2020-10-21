package com.example.menuforweek.Entities;

import com.example.menuforweek.Interface.Period;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable, Period {

    private int id;
    private ArrayList<Product> details;
    private String text;

    public Recipe(ArrayList<Product> details, String text) {
        this.details = details;
        this.text = text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Product> getDetails() {
        return details;
    }

    public void setDetails(ArrayList<Product> details) {
        this.details = details;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void addProduct(Product product){
        details.add(product);
    }
}
