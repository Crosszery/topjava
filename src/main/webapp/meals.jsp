<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<style>
    table, th, td {
        border: 1px solid;
        border-color: black;
    }
    table {
        border-spacing: 1px;
    }
    td {
        padding: 5px;
    }
    .td_button_edit {
        border-radius: 5px;
        background-color: aquamarine;

    }
    .td_button_delete {
        border-radius: 5px;
        background-color: indianred;

    }
    .a_td_button {
        text-decoration: none;
        color: black;
    }
</style>

<html lang="ru">
<head>
    <title>Meals</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<h3><a href="index.html">Home</a></h3>
<hr>
<h2>Meals</h2>
<table>
    <tr>
        <td><b>Id</b></td>
        <td><b>DateTime</b></td>
        <td><b>Description</b></td>
        <td><b>Calories</b></td>
    </tr>
    <c:set var="dateTimeFormatter" value="${DateTimeFormatter.ofPattern(\"yyyy-MM-dd HH:mm\")}"/>
    <c:forEach items="${requestScope.mealsTo}" var="meal">
        <tr style="color: ${meal.excess ? "red" : "green"}">
            <td>${meal.id}</td>
            <td>${meal.dateTime.format(dateTimeFormatter)}</td>
            <td>${meal.description}</td>
            <td>${meal.calories}</td>
            <td class="td_button_edit"><a class="a_td_button" href="meals?action=edit&id=${meal.id}">Update</a></td>
            <td class="td_button_delete"><a class="a_td_button" href="meals?action=delete&id=${meal.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>