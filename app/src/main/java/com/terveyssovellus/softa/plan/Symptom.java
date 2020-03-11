package com.terveyssovellus.softa.plan;

public class Symptom {
    private String name;
    private String description;
    private int level; // 0: normal, 1: alarming
    private String treatment;

    public Symptom(String name, int level){
        this.name = name;
        this.level = level;
    }
}
