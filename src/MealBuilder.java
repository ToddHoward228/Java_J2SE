import java.util.Random;

public class MealBuilder {

    private static MealBuilder mealBuilder;

    private MealBuilder(){}

    public static MealBuilder getInstance(){
        if(mealBuilder == null){
            mealBuilder = new MealBuilder();
        }
        return mealBuilder;
    }

    Random rand = new Random();

    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());

        if(rand.nextBoolean())
            meal.addItem(new Pepsi());
        else
            meal.addItem(new Coke());

        return meal;
    }

    public Meal prepareNonVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());

        if(rand.nextBoolean())
            meal.addItem(new Pepsi());
        else
            meal.addItem(new Coke());

        return meal;
    }
}
