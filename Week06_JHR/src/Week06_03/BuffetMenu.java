package Week06_03;

import java.util.ArrayList;
import java.util.List;

class Food {
    private String name;
    private int calories;
    private boolean isVegetarian;

    public Food(String name, int calories, boolean isVegetarian) {
        this.name = name;
        this.calories = calories;
        this.isVegetarian = isVegetarian;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }
}

public class BuffetMenu {
    public static void main(String[] args) {
        List<Food> buffetMenu = new ArrayList<>();
        buffetMenu.add(new Food("Salad", 150, true));
        buffetMenu.add(new Food("Steak", 500, false));
        buffetMenu.add(new Food("Pasta", 350, true));
        buffetMenu.add(new Food("Fruit Salad", 200, true));
        buffetMenu.add(new Food("Pizza", 800, true));

        List<String> vegetarianLowCalorieFoods = new ArrayList<>();
        for (Food food : buffetMenu) {
            if (food.getCalories() <= 300 && food.isVegetarian()) {
                vegetarianLowCalorieFoods.add(food.getName());
            }
        }

        System.out.println("칼로리 300 이하의 채식 메뉴:");
        for (String foodName : vegetarianLowCalorieFoods) {
            System.out.println(foodName);
        }
    }
}

