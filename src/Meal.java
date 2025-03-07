import java.util.ArrayList;

public class Meal {
    ArrayList<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }
    public float getCost(){
        float cost = 0;
        for (Item item : items) {
            cost += item.getPrice();
        }
        return cost;
    }
    public void showItems(){
        for(Item item : items){
            System.out.println("Name: " + item.getName() + "\nPacking: " + item.getPacking().getDescription() + "\nPrice: " + item.getPrice());
        }
    }
}
