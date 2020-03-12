package com.terveyssovellus.softa.plan;

import android.content.res.Resources;
import com.terveyssovellus.softa.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlanArchive {
    private List<Plan> plans;
    private static PlanArchive archive = new PlanArchive();

    public static PlanArchive getInstance(){
        if(archive == null) {
            archive = new PlanArchive();
        }
        return archive;
    }

    private PlanArchive(){
        plans = new ArrayList<>();
/*
        List<Treatment> nasalPolypTreatment = new ArrayList<>();
        nasalPolypTreatment.add(new Treatment(Resources.getSystem().getString(R.string.treatment_nasal_jug),0,48, Arrays.asList(8,10,12,14,16,18,20)));
        nasalPolypTreatment.add(new Treatment(Resources.getSystem().getString(R.string.treatment_nasal_jug),48,168, Arrays.asList(8,12,16,20)));
        List<Forbidden> nasalPolypForbidden = new ArrayList<>();
        nasalPolypForbidden.add(new Forbidden(Resources.getSystem().getString(R.string.forbidden_driving),0,24));
        nasalPolypForbidden.add(new Forbidden(Resources.getSystem().getString(R.string.forbidden_sauna),0,168));
        List<Symptom> nasalPolypSymptoms = new ArrayList<>();
        nasalPolypSymptoms.add(new Symptom(Resources.getSystem().getString(R.string.symptom_clogged_nasal_passages),0));
        nasalPolypSymptoms.add(new Symptom(Resources.getSystem().getString(R.string.symptom_heavy_bleeding),1));

        plans.add(new Plan(222,Resources.getSystem().getString(R.string.plan_nasal_polyop_removal),nasalPolypTreatment,nasalPolypForbidden,nasalPolypSymptoms));

 */
    }

    public List<Plan> getPlans(){
        return plans;
    }
}
