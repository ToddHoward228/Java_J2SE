package Facade;

abstract public class Shape implements Cloneable {
    String id;
    String type;


    String getId() {
        return id;
    }

    String getType() {
        return type;
    }

    void setId(String id) {
        this.id = id;
    }
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
