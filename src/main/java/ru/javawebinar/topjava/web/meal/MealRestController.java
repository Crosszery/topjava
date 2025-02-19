package ru.javawebinar.topjava.web.meal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;
import ru.javawebinar.topjava.to.MealTo;
import ru.javawebinar.topjava.web.SecurityUtil;

import java.util.List;

import static ru.javawebinar.topjava.util.ValidationUtil.assureIdConsistent;
import static ru.javawebinar.topjava.util.ValidationUtil.checkIsNew;

@Controller
public class MealRestController {

    private static final Logger log = LoggerFactory.getLogger(MealRestController.class);

    @Autowired
    private MealService service;

    public List<MealTo> getAll() {
        log.info("Getting all meals");
        return service.getAll(SecurityUtil.authUserId());
    }

    public MealTo get(int id) {
        log.info("Getting meal with id {}", id);
        return service.get(id, SecurityUtil.authUserId());
    }

    public MealTo create(Meal meal) {
        log.info("Creating meal {}", meal);
        checkIsNew(meal);
        return service.create(meal, SecurityUtil.authUserId());
    }

    public void delete(int id) {
        log.info("Deleting meal with id {}", id);
        service.delete(id, SecurityUtil.authUserId());
    }

    public void update(Meal meal) {
        log.info("Updating meal {}", meal);
        assureIdConsistent(meal, meal.getId());
        service.update(meal, SecurityUtil.authUserId());
    }
}