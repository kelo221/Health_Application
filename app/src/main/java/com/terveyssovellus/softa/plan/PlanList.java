package com.terveyssovellus.softa.plan;

import com.terveyssovellus.softa.R;
import java.util.ArrayList;
import java.util.List;

/**
 * This is a singleton class containing list of all plans.
 *
 * @author Minji Choi
 * @author Jere Lampola
 */
public class PlanList {
    private List<SimplePlan> plans;
    private static final PlanList archive = new PlanList();

    /**
     *
     * @return instance of the singleton
     */
    public static PlanList getInstance(){
        return archive;
    }

    /**
     * This constructor initializes the singleton with the plans.
     */
    private PlanList(){
        plans = new ArrayList<>();

        plans.add(new SimplePlan("Nasal", "222", R.string.plan_content_nasal, R.drawable.nenakannu, R.drawable.nasal));
        plans.add(new SimplePlan("Septoplasty","444",R.string.plan_content_septoplasty,R.drawable.nenakannu,R.drawable.secto));
        plans.add(new SimplePlan("Polvileikkaus","666",R.string.plan_content_knee,R.drawable.jumppaohje,R.drawable.knee));
    }

    /**
     *
     * @return plans in the singleton as a List
     */
    public List<SimplePlan> getPlans() {
        return plans;
    }

    /**
     * This method checks if the inputted plan id is found in the singleton's plan list
     *
     * @param planString String, plan id to be check
     * @return boolean true if plan exists in the singleton, false if it doesn't
     */
    public boolean planExists(String planString){
        boolean planExists = false;
        for(int i=0;i<plans.size();i++){
            if(planString.equals(plans.get(i).getId())){
                planExists = true;
            }
        }
        return planExists;
    }
}
