package com.terveyssovellus.softa.plan;

public class Forbidden {
    private String description;
    private int startHour; // -1 if none
    private int endHour;   // -1 if none

    public Forbidden(String description, int startHour, int endHour){
        this.description = description;
        this.startHour = startHour;
        this.endHour = endHour;
    }


}
