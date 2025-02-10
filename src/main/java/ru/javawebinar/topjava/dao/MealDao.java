package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealDao {
    public List<Meal> getAllMeals();

    public void addMeal(Meal meal);

    public void updateMeal(Meal meal);

    public void deleteMeal(int id);

    public Meal getMealById(int id);
}
