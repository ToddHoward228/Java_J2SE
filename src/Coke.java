public class Coke extends ColdDrink {
    private float price = 35.5f;
    private String name = "Coka Cola";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
