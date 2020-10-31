package com.example.menuforweek.Entities;

import java.io.Serializable;
import java.util.ArrayList;

public class DaySchedule implements Serializable {

    private int id;
    private String name;
    private ArrayList<Meal> dayschedule;

    public DaySchedule() {}

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

    public ArrayList<Meal> getDayschedule() {
        return dayschedule;
    }

    public void setDayschedule(ArrayList<Meal> dayschedule) {
        this.dayschedule = dayschedule;
    }

    public void addMeal(Meal meal){
       this.dayschedule.add(meal);
    }


}
