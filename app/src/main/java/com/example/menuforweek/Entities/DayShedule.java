package com.example.menuforweek.Entities;

import com.example.menuforweek.Interface.Period;

import java.io.Serializable;

public class DayShedule implements Serializable {

    private int id;
    private Period[] dayschedule;

    public DayShedule() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Period[] getDayschedule() {
        return dayschedule;
    }

    public void setDayschedule(Period[] dayschedule) {
        this.dayschedule = dayschedule;
    }

    public void setPeriod(Period meal, int pos){
        dayschedule[pos]=meal;
    }
}
