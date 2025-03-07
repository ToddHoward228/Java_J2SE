public class ChickenBurger extends Burger{

    private float price = 52.3f;
    private String name = "Chicken Burger";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
