package com.terveyssovellus.softa.plan;

public class SimplePlan {
    private String name, id;
    private int contents;
    private int image;
    private int qrCode;

    public SimplePlan(String name, String id, int contents, int image, int qrCode){
        this.name = name;
        this.id = id;
        this.contents = contents;
        this.image = image;
        this.qrCode = qrCode;
    }

    public String getId() {return id;}
    public int getContents() {return contents;}
    public String getName(){return name;}
    public int getImage(){return image;}
    public int getQrCode(){return qrCode;}

    @Override
    public String toString(){
        return this.name;
    }
}
