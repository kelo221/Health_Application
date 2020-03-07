package com.terveyssovellus.softa.plan;

import java.util.ArrayList;
import java.util.List;

public class PlanArchive {
    private List<Plan> plans;
    private static final PlanArchive ourInstance = new PlanArchive();

    public static PlanArchive getInstance() {
        return ourInstance;
    }

    private PlanArchive(){
        plans = new ArrayList<>();
        //plans.add(new Plan(R.string.,""));
    }
}
