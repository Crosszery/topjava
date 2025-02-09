<%@ page import="ru.javawebinar.topjava.model.MealTo" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ru">
<head>
    <title>Meals</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<table style="border-spacing: 10px">
    <tr>
        <td><b>DateTime</b></td>
        <td><b>Description</b></td>
        <td><b>Calories</b></td>
    </tr>
    <%
        //Could be done here directly
        //final int CALORIES_PER_DAY = 2000;
        //List<MealTo> mealsTo = MealsUtil.controlExcessCalories(MealsUtil.generateSampleMeals(), CALORIES_PER_DAY);

        @SuppressWarnings("unchecked")
        List<MealTo> mealsTo = (List<MealTo>) request.getAttribute("mealsTo");
        for (MealTo mealTo : mealsTo)
        {
            %>
                <tr style="color: <%=mealTo.isExcess() ? "red" : "green" %>">
                    <td><%=mealTo.getDate() %></td>
                    <td><%=mealTo.getDescription() %></td>
                    <td><%=mealTo.getCalories() %></td>
                </tr>
            <%
        }
    %>
</table>
</body>
</html>