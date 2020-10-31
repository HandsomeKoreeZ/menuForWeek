package com.example.menuforweek.Entities;

public class Meal {
    private String period;
    private Recipe dish;

    public Meal(){}
    public Meal(String period, Recipe dish) {
        this.period = period;
        this.dish = dish;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public Recipe getDish() {
        return dish;
    }

    public void setDish(Recipe dish) {
        this.dish = dish;
    }
}
