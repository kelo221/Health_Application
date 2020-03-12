package com.terveyssovellus.softa.plan;

/**
 * This class is used for creating Plan objects. The name is SimplePlan because this is the simple
 * way to create what is needed. More complex, and ultimately smarter way would be having plan
 * contents as Lists of each type (Symptom, Treatment, Avoidable/Forbidden).
 *
 * This class is used for storing objects created from it in the PlanList, evaluating inputted plan
 * codes and displaying plan contents in instructions fragment.
 *
 * @author Minji Choi
 * @author Jere Lampola
 */
public class SimplePlan {
    private String name, id;
    private int contents;
    private int image;
    private int qrCode;

    /**
     * Constructor for the class
     *
     * @param name String, name of the plan
     * @param id int, identifier, will be compared with Profile.planString in some cases
     * @param contents int, R.string.-returned pointer for plan contents
     * @param image int, R.drawable.-returned pointer for an image related to plan
     * @param qrCode int, R.drawable.-pointer to the QR-code drawable of plan, id is encoded in QR
     */
    public SimplePlan(String name, String id, int contents, int image, int qrCode){
        this.name = name;
        this.id = id;
        this.contents = contents;
        this.image = image;
        this.qrCode = qrCode;
    }

    /**
     *
     * @return id of the plan
     */
    public String getId(){return id;}

    /**
     *
     * @return contents (symptoms, treatments, avoidable things) of the plan
     */
    public int getContents(){return contents;}

    /**
     *
     * @return name of the plan, used for listing
     */
    public String getName(){return name;}

    /**
     *
     * @return integer id of the drawable associated with the plan
     */
    public int getImage(){return image;}

    /**
     *
     * @return integer id of the drawable (QR-code file) that links to plan id
     */
    public int getQrCode(){return qrCode;}

    /**
     *
     * @return default string of the plan, just the name, used mainly in list view
     */
    @Override
    public String toString(){
        return this.name;
    }
}
