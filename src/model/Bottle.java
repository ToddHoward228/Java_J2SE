package model;

public class Bottle implements Packing{
    String description;
    public Bottle(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
