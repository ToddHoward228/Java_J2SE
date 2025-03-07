public class BuilderPatternDemo {


    public static void main(String[] args) {
        MealBuilder mealBuilder = MealBuilder.getInstance();

        Meal order1 = mealBuilder.prepareVegMeal();

        System.out.println("\tOrder 1");
        System.out.println("Cost = " + order1.getCost());
        order1.showItems();

        Meal order2 = mealBuilder.prepareVegMeal();

        System.out.println("\tOrder 2");
        System.out.println("Cost = " + order2.getCost());
        order2.showItems();

        Meal order3 = mealBuilder.prepareNonVegMeal();
        System.out.println("\tOrder 3");
        System.out.println("Cost = " + order3.getCost());
        order3.showItems();

        Meal order4 = mealBuilder.prepareNonVegMeal();
        System.out.println("\tOrder 4");
        System.out.println("Cost = " + order4.getCost());
        order4.showItems();

    }
}