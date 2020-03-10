package com.terveyssovellus.softa.profile;

import com.terveyssovellus.softa.plan.Plan;

public class Profile {
    private String name,language;
    private int age, position;
    private Boolean hasBeenCreated;
    private Plan plan;
    private static Profile information;

    public static Profile getInstance(){
        if (information == null) {
            information = new Profile();
        }
        return information;
    }

    private Profile(){}

    public void setProfile(String name, int age, int position, Boolean hasBeenCreated, String lang){
        this.name = name;
        this.age = age;
        this.position = position;
        this.hasBeenCreated = true;
        this.language = lang;
    }

    public void setProfile(Profile profile){
        setProfile(profile.name,profile.age,profile.position,true,profile.language);
    }

    public void resetProfile(){
        this.name = "";
        this.age = 0;
        this.position = -1;
        this.hasBeenCreated = false;
    }

    public Boolean hasBeenCreated(){return this.hasBeenCreated;}
    public void setHasBeenCreated(){this.hasBeenCreated = true;}

    public String getName()    {return this.name;}
    public int getAge()        {return this.age;}
    public int getPosition()   {return this.position;}
    public Plan getPlan()      {return this.plan;}
    public String getLanguage(){return this.language;}

    public void setName(String name)     {this.name = name;}
    public void setAge(int age)          {this.age = age;}
    public void setPosition(int position){this.position = position;}
    public void setPlan(Plan plan)       {this.plan = plan;}
    public void setLanguage(String lang) {this.language = lang;}
}
