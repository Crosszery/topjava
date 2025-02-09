package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.MealTo;
import ru.javawebinar.topjava.util.MealsUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        log.debug("redirect to meals");
        final int CALORIES_PER_DAY = 2000;
        //Список выводим БЕЗ фильтрации. Технически, если взять весь диапазон, то получается без фильтрации
        //List<MealTo> mealsTo = MealsUtil.filteredByStreams(MealsUtil.generateSampleMeals(), LocalTime.of(0, 0), LocalTime.of(23, 59), CALORIES_PER_DAY);
        List<MealTo> mealsTo = MealsUtil.controlExcessCalories(MealsUtil.generateSampleMeals(), CALORIES_PER_DAY);

        request.setAttribute("mealsTo", mealsTo);
        request.getRequestDispatcher("/meals.jsp").forward(request, response);
    }
}
