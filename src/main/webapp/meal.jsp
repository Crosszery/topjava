<%-- TODO --%>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<style>

</style>

<html lang="ru">
<head>
    <title>Meals</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Create or edit existing meal</h2>
<form method="POST" action="meals.jsp" name="upsertMealForm">
    DateTime : <input
        type="text" name="dateTime"
        value="${requestScope.meal.dateTime}" /> <br />
    Description : <input
        type="text" name="description"
        value="${requestScope.meal.description}" /> <br />
    Calories : <input
        type="text" name="calories"
        value="${requestScope.meal.calories}" /> <br />
    <input type="submit" value="Submit">
</form>
</body>
</html>