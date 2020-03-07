package com.terveyssovellus.softa.plan;

import java.util.List;

public class Plan {
    private String name;
    private String description;
    private List<Treatment> treatments;
    private List<Forbidden> prohibited;
    private List<Symptom> symptoms;


    public Plan(String name,
                String description,
                List<Treatment> treatments,
                List<Forbidden> prohibited,
                List<Symptom> symptoms){
        this.name = name;
        this.description = description;
        this.treatments = treatments;
        this.prohibited = prohibited;
        this.symptoms = symptoms;
    }



}