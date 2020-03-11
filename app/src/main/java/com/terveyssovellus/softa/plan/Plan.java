package com.terveyssovellus.softa.plan;

import java.util.List;

public class Plan {
    private int id;
    private String name;
    private String description;
    private List<Treatment> treatments;
    private List<Forbidden> prohibited;
    private List<Symptom> symptoms;

    public Plan(int id,
                String name,
                List<Treatment> treatments,
                List<Forbidden> prohibited,
                List<Symptom> symptoms){
        this.id = id;
        this.name = name;
        this.treatments = treatments;
        this.prohibited = prohibited;
        this.symptoms = symptoms;
    }

    public Plan(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Treatment> getTreatments() {
        return treatments;
    }

    public void setTreatments(List<Treatment> treatments) {
        this.treatments = treatments;
    }

    public List<Forbidden> getProhibited() {
        return prohibited;
    }

    public void setProhibited(List<Forbidden> prohibited) {
        this.prohibited = prohibited;
    }

    public List<Symptom> getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(List<Symptom> symptoms) {
        this.symptoms = symptoms;
    }
}