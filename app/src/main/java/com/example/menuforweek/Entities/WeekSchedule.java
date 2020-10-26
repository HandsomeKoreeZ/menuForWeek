package com.example.menuforweek.Entities;

import java.io.Serializable;

public class WeekSchedule implements Serializable {

    private final DayShedule[] schedule;

    public WeekSchedule() {
        schedule = new DayShedule[7];
    }

    public void updateDAY(DayShedule d, int pos) {
        this.schedule[pos] = d;
    }

    public DayShedule getDAY(int pos){
        return schedule[pos];
    }

}
