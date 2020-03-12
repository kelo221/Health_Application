package com.terveyssovellus.softa.profile;

import java.util.Date;

/**
 * This class is for creating mood objects. The user is prompted if they feel good, neutral or bad,
 * once they select their answer the time is saved with the given mood. 1 means good, 0 means
 * neutral and -1 means bad. Mood logs stored in the profile's moodList for example.
 *
 * @author Jere Lampola
 */
public class Mood {
    private int mood; // 1:good | 0:neutral | -1:bad
    private Date creationTime;

    /**
     * Constructor of this class
     *
     * @param mood int, how the user feels right now 1:good | 0:neutral | -1:bad
     */
    public Mood(int mood){
        this.mood = mood;
        this.creationTime = new Date();
    }

    public int getMood(){return this.mood;}
    public Date getCreationTime(){return this.creationTime;}

    /**
     * Overridden toString method to get custom output to list views for example
     *
     * @return String containing creation time and mood
     */
    @Override
    public String toString(){
        String feeling = "";
        switch(this.mood){
            case 1:
                feeling = "good";
                break;
            case 0:
                feeling = "neutral";
                break;
            case -1:
                feeling = "bad";
                break;
        }
        String output = this.creationTime.toString() + " " + feeling;
        return output;
    }
}
