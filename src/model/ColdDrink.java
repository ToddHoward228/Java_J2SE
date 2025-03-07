package model;

abstract public class ColdDrink implements Item{
    @Override
    public Packing getPacking() {
        return new Bottle("Plastic model.Bottle");
    }
}
