package com.terveyssovellus.softa;

public class Symptom {
    private String name;
    private String description;
    private int level; // 0: normal, 1: alarming
    private String treatment;

    public Symptom(String name, String description, int level, String treatment){
        this.name = name;
        this.description = description;
        this.level = level;
        this.treatment = treatment;
    }


}
