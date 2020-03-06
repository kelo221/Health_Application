package com.terveyssovellus.softa;

import java.util.Calendar;
import java.util.Date;

public class Profile {
    private String name;
    private int age, position;
    private Date creationTime;
    //private Plan plan;

    public Profile(String name, int age, int position){
        this.name = name;
        this.age = age;
        this.position = position;
        this.creationTime = Calendar.getInstance().getTime();
    }

    public String getName()      {return this.name;}
    public int getAge()          {return this.age;}
    public int getPosition()     {return this.position;}
    public Date getCreationTime(){return this.creationTime;}
    //public Plan getPlan()        {return this.plan;}

    public void setName(String name)     {this.name = name;}
    public void setAge(int age)          {this.age = age;}
    public void setPosition(int position){this.position = position;}
    //public void setPlan(Plan plan)       {this.plan = plan;}
}

