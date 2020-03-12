package com.terveyssovellus.softa.profile;

import java.util.List;

/**
 * This is a singleton class containing user profile data.
 *
 * @author Minji Choi
 * @author Jere Lampola
 */
public class Profile {
    private String name,language,planString;
    private int age, position;
    private Boolean hasBeenCreated,planSelected;
    private static Profile information;
    private List<Mood> moodList;

    /**
     *
     * @return instance of the singleton, create new if null
     */
    public static Profile getInstance(){
        if(information == null) {
            information = new Profile();
        }
        return information;
    }

    private Profile(){}

    /**
     * This method basically rewrites the whole singleton. Used for profile creation form and when
     * the profile is retrieved from SharedPreferences (with one extra step).
     *
     * @param name String, name of the user
     * @param age int, age of the user
     * @param position int, position of the user, 0:patient and 1:doctor
     * @param lang String, ISO-code of the locale (language)
     * @param planString String, id of the current plan
     * @param moodList List,Mood, history log of mood entries
     */
    public void setProfile(
            String name,
            int age,
            int position,
            boolean planSelected,
            String lang,
            String planString,
            List<Mood> moodList
                          ){
        this.name = name;
        this.age = age;
        this.position = position;
        this.hasBeenCreated = true;
        this.planSelected = planSelected;
        this.language = lang;
        this.planString = planString;
        this.moodList = moodList;
    }

    /**
     * This method replaces Profiles contents with contents of another instance of Profile. Mainly
     * used for retrieving SavedPreferences data.
     *
     * @param profile contains an instance of profile with which Profile will be replaced with
     */
    public void setProfile(Profile profile){
        setProfile(profile.name,
                   profile.age,
                   profile.position,
                   profile.planSelected,
                   profile.language,
                   profile.planString,
                   profile.moodList
                  );
    }

    /**
     * This method reset the profile to basic values, these will never likely be used because user
     * isn't supposed to use the app without inputting profile information.
     */
    public void resetProfile(){
        this.name = "";
        this.age = 0;
        this.position = -1;
        this.hasBeenCreated = false;
        this.planSelected = false;
    }

    /**
     * Adding mood to a list so that they can be accessed later.
     *
     * @param mood Mood, user inputted mood/feeling to be added to log/history
     */
    public void addMood(Mood mood){
        this.moodList.add(mood);
    }

    /**
     *
     * @return true if hasBeenCreated is set as true
     */
    public Boolean hasBeenCreated(){return this.hasBeenCreated;}

    /**
     *
     * @return true if planSelected is set as true
     */
    public Boolean planSelected(){return this.planSelected;}

    /**
     *
     * @return String name of the of user
     */
    public String getName(){return this.name;}

    /**
     *
     * @return int age of the user
     */
    public int getAge(){return this.age;}

    /**
     *
     * @return int position of the user, 0:patient and 1:doctor
     */
    public int getPosition(){return this.position;}

    /**
     *
     * @return String ISO-code of the locale (language)
     */
    public String getLanguage(){return this.language;}

    /**
     *
     * @return String id of the current plan
     */
    public String getPlanString(){return this.planString;}

    /**
     *
     * @return List,Mood, history log of saved feelings
     */
    public List<Mood>getMoodList(){return this.moodList;}

    /**
     * Setting a flag that the profile needs to be (re)created
     */
    public void setHasBeenCreated(){this.hasBeenCreated = true;}

    /**
     * Setting a flag that the plan needs to be selected
     */
    public void setPlanSelectedFalse(){this.planSelected = false;}

    /**
     *
     * @param name String, rename the profile
     */
    public void setName(String name){this.name = name;}

    /**
     *
     * @param age int, set the age
     */
    public void setAge(int age){this.age = age;}

    /**
     *
     * @param position int choose position of the user
     */
    public void setPosition(int position){this.position = position;}

    /**
     *
     * @param lang String change language of ht e user
     */
    public void setLanguage(String lang){this.language = lang;}

    /**
     * Choose new plan for the profile and also set the planSelected flag true
     *
     * @param planString id of the new plan
     */
    public void setPlanString(String planString){
        this.planString = planString;
        this.planSelected = true;
    }

}
