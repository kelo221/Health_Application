package com.terveyssovellus.softa.plan;

public class SimplePlan {
    private String name, id;
    private int contents;
    private int image;

    public SimplePlan(String name, String id, int contents, int image){
        this.name = name;
        this.id = id;
        this.contents = contents;
        this.image = image;
    }

    public String getId() {return id;}
    public String getContents() {return Integer.toString(contents);}
    public String getName(){return name;}
    public int getImage(){return image;}
}
