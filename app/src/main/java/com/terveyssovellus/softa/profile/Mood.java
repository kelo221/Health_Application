package com.terveyssovellus.softa.profile;

import java.util.Date;

public class Mood {
    private int mood; // 1:good | 0:neutral | -1:bad
    private Date creationTime;

    public Mood(int mood){
        this.mood = mood;
        this.creationTime = new Date();
    }

    public int getMood()         {return this.mood;}
    public Date getCreationTime(){return this.creationTime;}
}
