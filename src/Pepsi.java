public class Pepsi extends ColdDrink{
    private float price = 30.5f;
    private String name = "Pepsi";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public float getPrice() {
        return price;
    }
}
