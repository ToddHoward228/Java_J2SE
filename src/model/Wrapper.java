package model;

public class Wrapper implements Packing {
    String description;
    public Wrapper(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }
}
