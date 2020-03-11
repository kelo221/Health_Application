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

        plans.add(new SimplePlan("Nasal", "444", R.string.plan_content_nasal, R.drawable.nenakannu));
        plans.add(new SimplePlan("Septoplasty","222",R.string.plan_content_septoplasty,R.drawable.nenakannu));


    }

    public List<SimplePlan> getPlans() {
        return plans;
    }
}
