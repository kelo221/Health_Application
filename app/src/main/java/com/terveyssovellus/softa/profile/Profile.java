package com.terveyssovellus.softa.profile;

import com.terveyssovellus.softa.plan.Plan;
import java.util.List;

/**
 *
 * javadoc
 */
public class Profile {
    private String name,language,planString;
    private int age, position;
    private Boolean hasBeenCreated,planSelected;
    private Plan plan;
    private static Profile information;
    private List<Mood> moodList;

    public static Profile getInstance(){
        if(information == null) {
            information = new Profile();
        }
        return information;
    }

    private Profile(){}

    public void setProfile(
            String name,
            int age,
            int position,
            Boolean hasBeenCreated,
            String lang,
            Plan plan,
            String planString,
            List<Mood> moodList
                          ){
        this.name = name;
        this.age = age;
        this.position = position;
        this.hasBeenCreated = true;
        this.planSelected = true;
        this.language = lang;
        this.plan = plan;
        this.planString = planString;
        this.moodList = moodList;
    }

    public void setProfile(Profile profile){
        setProfile(profile.name,
                   profile.age,
                   profile.position,
                   true, // <--------------- hasBeenCreated will always be true when setting profile
                   profile.language,
                   profile.plan,
                   profile.planString,
                   profile.moodList
                  );
    }

    public void resetProfile(){
        this.name = "";
        this.age = 0;
        this.position = -1;
        this.hasBeenCreated = false;
        this.planSelected = false;
    }

    public void addMood(Mood mood){
        this.moodList.add(mood);
    }

    public Boolean hasBeenCreated(){return this.hasBeenCreated;}
    public void setHasBeenCreated(){this.hasBeenCreated = true;}

    public Boolean planSelected(){return this.planSelected;}
    public void setPlanSelectedFalse(){this.planSelected = false;}

    public String getName()     {return this.name;}
    public int getAge()         {return this.age;}
    public int getPosition()    {return this.position;}
    public Plan getPlan()       {return this.plan;}
    public String getLanguage() {return this.language;}
    public String getPlanString(){return this.planString;}

    public void setName(String name)     {this.name = name;}
    public void setAge(int age)          {this.age = age;}
    public void setPosition(int position){this.position = position;}
    public void setPlan(Plan plan)       {this.plan = plan; this.planSelected = true;}
    public void setLanguage(String lang) {this.language = lang;}

    public void setPlanString(String planString){
        this.planString = planString;
        this.planSelected = true;
    }

}
