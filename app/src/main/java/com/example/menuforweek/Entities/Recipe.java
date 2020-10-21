package com.example.menuforweek.Entities;

import com.example.menuforweek.Interface.Period;

import java.io.Serializable;
import java.util.ArrayList;

public class Recipe implements Serializable, Period {

    private int id;
    private ArrayList<Product> details;
    private String text;
}
