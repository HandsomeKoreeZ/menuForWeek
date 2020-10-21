package com.example.menuforweek.Entities;

import java.io.Serializable;

public class WeekSchedule implements Serializable {

    private final DAY[] schedule;

    public WeekSchedule() {
        schedule = new DAY[7];
    }

    public void updateDAY(DAY d, int pos) {
        this.schedule[pos] = d;
    }

    public DAY getDAY(int pos){
        return schedule[pos];
    }

}
