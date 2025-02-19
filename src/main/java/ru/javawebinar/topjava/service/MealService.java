package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.repository.MealRepository;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ru.javawebinar.topjava.util.ValidationUtil.checkNotFound;

@Service
public class MealService {

    private final MealRepository repository;

    @Autowired
    public MealService(MealRepository repository) {
        this.repository = repository;
    }

    public MealTo create(Meal meal, int userId) {
        return MealsUtil.createTo(repository.save(meal, userId), false);
    }

    public void delete(int id, int userId) {
        checkNotFound(repository.delete(id, userId), id);
    }

    public MealTo get(int id, int userId) {
        return MealsUtil.createTo(checkNotFound(repository.get(id, userId), id), false);
    }

    public List<MealTo> getAll(int userId) {
        return repository.getAll(userId)
                .stream()
                .map(m -> MealsUtil.createTo(m, false))
                .collect(Collectors.toList());
    }

    public void update(Meal meal, int userId) {
        checkNotFound(repository.save(meal, userId), meal.getId());
    }

    public List<MealTo> getFiltered(int userId, LocalDateTime startTime, LocalDateTime endTime) {
        Predicate<Meal> mealDatesPredicate = meal -> meal.getDateTime().isAfter(startTime) && meal.getDateTime().isBefore(endTime);
        return MealsUtil.filterByPredicate(repository.getAll(userId), MealsUtil.DEFAULT_CALORIES_PER_DAY, mealDatesPredicate);
    }
}