package com.terveyssovellus.softa.plan;

import com.terveyssovellus.softa.R;

import java.util.ArrayList;
import java.util.List;

public class PlanList {
    private List<SimplePlan> plans;
    private static final PlanList archive = new PlanList();

    public static PlanList getInstance(){
        return archive;
    }

    private PlanList(){
        plans = new ArrayList<>();

        plans.add(new SimplePlan("Nasal", "222", R.string.plan_content_nasal, R.drawable.nenakannu, R.drawable.nasal));
        plans.add(new SimplePlan("Septoplasty","444",R.string.plan_content_septoplasty,R.drawable.nenakannu,R.drawable.secto));

    }

    public List<SimplePlan> getPlans() {
        return plans;
    }

    public Boolean planExists(String planString){
        Boolean planExists = false;
        for(int i=0;i<plans.size();i++){
            if(planString.equals(plans.get(i).getId())){
                planExists = true;
            }
        }
        return planExists;
    }
}
