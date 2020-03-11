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

    @Override
    public String toString(){
        String condition = "";
        switch(this.mood){
            case 1:
                condition = "good";
                break;
            case 0:
                condition = "neutral";
                break;
            case -1:
                condition = "bad";
                break;
        }
        String output = this.creationTime.toString() + " " + condition;
        return output;
    }
}
