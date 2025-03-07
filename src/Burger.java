abstract public class Burger implements Item{
    @Override
    public Packing getPacking() {
        return new Wrapper("Paper wrapper");
    }
}
