package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.MealsUtil;

import java.util.ArrayList;
import java.util.List;

public class InMemoryMealDao implements MealDao {
    //HashMap is probably better, but here we are
    private final List<Meal> meals;
    public InMemoryMealDao() {
        meals = new ArrayList<>(MealsUtil.generateSampleMeals());
    }
    public List<Meal> getAllMeals() {
        return meals;
    }

    public void addMeal(Meal meal) {
        meals.add(meal);
    }

    public void updateMeal(Meal meal) {
        meals.set(meals.indexOf(getMealById(meal.getId())), meal);
    }

    public void deleteMeal(int id) {
        meals.remove(getMealById(id));
    }

    public Meal getMealById(int id) {
        return meals.stream().filter(meal -> meal.getId().equals(id)).findFirst().orElse(null);
    }
}
