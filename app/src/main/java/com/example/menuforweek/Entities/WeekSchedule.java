package com.example.menuforweek.Entities;

import java.io.Serializable;

public class WeekSchedule implements Serializable {

    private final DaySchedule[] schedule;

    public WeekSchedule() {
        schedule = new DaySchedule[7];
    }

    public void updateDAY(DaySchedule d, int pos) {
        this.schedule[pos] = d;
    }

    public DaySchedule getDAY(int pos){
        return schedule[pos];
    }

}
