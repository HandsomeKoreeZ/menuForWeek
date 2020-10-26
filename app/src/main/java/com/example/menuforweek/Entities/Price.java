package com.example.menuforweek.Entities;

import java.io.Serializable;

/**
 * показывае цену за еденицу объёма.
 * тип объёма берёт из предоставленного продукта.
 */

public class Price implements Serializable {
    private int id;
    private Product_raw prod;
    private String volType;
    private int volume;
    private Double value;

    public Price() {}

    public Price(Product_raw prod, int volume, Double value) {
        this.prod = prod;
        this.volType = prod.getVolType();
        this.volume = volume;
        this.value = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product_raw getProd() {
        return prod;
    }

    public void setProd(Product_raw prod) {
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
