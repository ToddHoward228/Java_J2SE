public class VegBurger extends Burger {
    private float price = 67.3f;
    private String name = "Veg Burger";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
