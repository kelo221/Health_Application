package com.terveyssovellus.softa.profile;

import com.terveyssovellus.softa.plan.Plan;

import java.util.Calendar;
import java.util.Date;

public class Profile {
    private String name;
    private int age, position;
    //private Date creationTime;
    private Boolean hasBeenCreated;
    //private Plan plan;
    private static Profile information;

    public static Profile getInstance(){
        if (information == null) {
            information = new Profile();
        }
        return information;
    }

    private Profile(){
        //this.name = "";
        //this.age = 0;
        //this.position = -1;
        //this.creationTime = Calendar.getInstance().getTime();
        //this.hasBeenCreated = false;
    }

    public void setProfile(String name, int age, int position, Boolean hasBeenCreated){
        this.name = name;
        this.age = age;
        this.position = position;
        this.hasBeenCreated = true;
        //this.creationTime = Calendar.getInstance().getTime();
    }

    public void setProfile(Profile profile){
        setProfile(profile.name,profile.age,profile.position,true);
    }

    public void resetProfile(){
        this.name = "reset";
        this.age = 0;
        this.position = -1;
        //this.creationTime = Calendar.getInstance().getTime();
        this.hasBeenCreated = false;
    }

    public Boolean hasBeenCreated(){return this.hasBeenCreated;}
    public void setHasBeenCreated(){this.hasBeenCreated = true;}

    public String getName()      {return this.name;}
    public int getAge()          {return this.age;}
    public int getPosition()     {return this.position;}
    //public Date getCreationTime(){return this.creationTime;}
    //public Plan getPlan()        {return this.plan;}

    public void setName(String name)     {this.name = name;}
    public void setAge(int age)          {this.age = age;}
    public void setPosition(int position){this.position = position;}
    //public void setPlan(Plan plan)       {this.plan = plan;}
}

