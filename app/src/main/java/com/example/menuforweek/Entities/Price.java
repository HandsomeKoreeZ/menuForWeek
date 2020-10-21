package com.example.menuforweek.Entities;

import java.io.Serializable;

public class Price implements Serializable {
    private int id;
    private Product prod;
    private String volType;
    private int volume;
    private Double value;

    public Price() {}

    public Price(Product prod, String volType, int volume, Double value) {
        this.prod = prod;
        this.volType = volType;
        this.volume = volume;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProd() {
        return prod;
    }

    public void setProd(Product prod) {
        this.prod = prod;
    }

    public String getVolType() {
        return volType;
    }

    public void setVolType(String volType) {
        this.volType = volType;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }


}
