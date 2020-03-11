package com.terveyssovellus.softa.plan;

import java.util.List;

public class Treatment {
    private String name;
    private int startHour;
    private int endHour;
    private List<Integer> repeatHours; // for example 8,10,12,14,18,20

    public Treatment(String name, int startHour, int endHour, List<Integer> repeatHours){
        this.name = name;
        this.startHour = startHour;
        this.endHour = endHour;
        this.repeatHours = repeatHours;
    }


}
