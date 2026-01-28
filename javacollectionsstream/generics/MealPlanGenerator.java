/**
 * This Program implements a Meal Planning System where different types of
 * meals are categorized and managed together. It uses Java Generics and
 * wildcards to allow multiple meal types to coexist in a single structure
 * while ensuring type safety, flexibility, and code reusability.
 *
 * @author gopal
 */
package generics;

import java.util.ArrayList;
import java.util.List;

/**
 * This interface serves as the main blueprint for all meal types.
 * Any class implementing this interface must define the
 * getDescription() method to describe the meal.
 */
interface MealPlan{
    String getDescription();
}

/**
 * This class implements the MealPlan interface and represents
 * a vegetarian meal option.
 */
class VegetarianMeal implements MealPlan{
    @Override
    public String getDescription(){
        return "Meal with no meat or fish";
    }
}

/**
 * This class implements the MealPlan interface and represents
 * a vegan meal option.
 */
class VeganMeal implements MealPlan{
    @Override
    public String getDescription(){
        return "Meal with no mean or any animal products at all";
    }
}

/**
 * This class implements the MealPlan interface and represents
 * a ketogenic meal option.
 */
class KetoMeal implements MealPlan{
    @Override
    public String getDescription(){
        return "Meal with high-fat, very low-carbohydrate, and moderate-protein designed to induce nutritional ketosis";
    }
}

/**
 * This class implements the MealPlan interface and represents
 * a high-protein meal option.
 */
class HighProteinMeal implements MealPlan{
    @Override
    public String getDescription(){
        return "Meal with High protein from plant or animal sources designed to enhance satiety and support muscle maintenance";
    }
}

/**
 * This class creates and manages a list of meal plans.
 * It uses generics to allow any class that implements
 * the MealPlan interface to be stored.
 *
 * @param <T> The specific MealPlan type that this class
 *            is instantiated with, improving reusability
 *            and type safety.
 */
class Meal<T extends MealPlan>{
    // List to store meal plans
    private List<T> mealList = new ArrayList<>();

    /**
     * Adds a meal plan to the list after validating
     * that it follows the MealPlan interface.
     *
     * @param meal the meal plan to be added
     */
    void addMealPlan(T meal){
        // validation logic
        if(meal instanceof MealPlan) {
            // if validation passes, add meal to the list
            mealList.add(meal);
        }
        else{
            System.out.println("given instance is not using MealPlan");
        }
    }

    /**
     * Getter method to retrieve the list of meal plans.
     *
     * @return list containing all meal plans
     */
    List<T> getMealList(){
        return mealList;
    }

    /**
     * Setter method to replace the existing meal list.
     *
     * @param mealList list of meal plans to be assigned
     */
    void getMealList(List<T> mealList){
        this.mealList = mealList;
    }

    /**
     * This method takes a list containing subclasses of MealPlan
     * and prints their descriptions to the console.
     *
     * @param mealList list containing meal plan objects
     * @param <P> generic parameter allowing flexibility
     *            for different MealPlan implementations
     */
    <P extends MealPlan> void printMealPlans(List<P> mealList){
        for(MealPlan i : mealList){
            System.out.println(i.getDescription());
        }
    }
}

/**
 * This class contains the main method and demonstrates
 * the usage of the Meal Planning System.
 */
public class MealPlanGenerator {
    // main method
    public static void main(String[] args){
        // object creation for managing meal plans
        Meal<MealPlan> meal1 = new Meal<>();

        // adding different meal types
        meal1.addMealPlan(new KetoMeal());
        meal1.addMealPlan(new HighProteinMeal());
        meal1.addMealPlan(new VeganMeal());
        meal1.addMealPlan(new VegetarianMeal());

        // printing all meal descriptions
        meal1.printMealPlans(meal1.getMealList());
    }
}
