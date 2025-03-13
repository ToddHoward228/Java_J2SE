package builder;

import model.*;

public class MealBuilder {

    private static MealBuilder mealBuilder;

    private MealBuilder(){}

    public static MealBuilder getInstance(){
        if(mealBuilder == null){
            mealBuilder = new MealBuilder();
        }
        return mealBuilder;
    }


    public Meal prepareVegMeal(String coldDrink) {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());

        if(coldDrink.equals("Pepsi"))
            meal.addItem(new Pepsi());
        else if (coldDrink.equals("Coke"))
            meal.addItem(new Coke());

        return meal;
    }

    public Meal prepareNonVegMeal(String coldDrink) {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());

        if(coldDrink.equals("Pepsi"))
            meal.addItem(new Pepsi());
        else if (coldDrink.equals("Coke"))
            meal.addItem(new Coke());

        return meal;
    }
}
