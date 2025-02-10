package ru.javawebinar.topjava.web;

import org.slf4j.Logger;
import ru.javawebinar.topjava.dao.InMemoryMealDao;
import ru.javawebinar.topjava.dao.MealDao;
import ru.javawebinar.topjava.util.MealsUtil;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

import static org.slf4j.LoggerFactory.getLogger;

public class MealServlet extends HttpServlet {
    private static final Logger log = getLogger(MealServlet.class);
    private static final int CALORIES_PER_DAY = 2000;
    private final MealDao mealDao = new InMemoryMealDao();
    //Navigation
    private static final String UPSERT = "/meal.jsp";
    private static final String LIST_MEALS = "/meals.jsp";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward =LIST_MEALS;
        String action = request.getParameter("action");

        if (action == null) {
            log.debug("load meals");
            forward = LIST_MEALS;
        } else if (action.equalsIgnoreCase("delete")){
            log.debug("delete meal");
            int mealId = Integer.parseInt(request.getParameter("id"));
            log.debug(String.valueOf(mealId));
            mealDao.deleteMeal(mealId);
        } else if (action.equalsIgnoreCase("edit")){
            //TODO
            log.debug("edit meal");
            request.setAttribute("meal",MealsUtil.createTo(mealDao.getMealById(Integer.parseInt(request.getParameter("id"))), false));
            forward = UPSERT;
        }
        request.setAttribute("mealsTo", MealsUtil.filteredByStreams(mealDao.getAllMeals(), LocalTime.MIN, LocalTime.MAX, CALORIES_PER_DAY));
        request.getRequestDispatcher(forward).forward(request, response);
    }
}
