<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="service.UserImplService.UsersService" %><%--
  Created by IntelliJ IDEA.
  User: GEORGY
  Date: 24.04.2020
  Time: 16:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h4>Добавить пользователя:</h4>
<form action="/addusers" method="post">
    Name:
    <input name="name" type="text">
    Age:
    <input name="age" type="number">
    Password:
    <input name="password" type="text">
    Role:
    <input name="role" type="text">
    <button type="submit">Добавить</button>
</form>

<c:forEach var="i" items="${requestScope.userlist}">
    <table>
        <tr>
            <label>Имя: ${i.name} </label>
        </tr>
        <tr>
            <label>Возраст: ${i.age} </label>
        </tr>
        <tr>
            <form name="updateUser" action="/updateusers" method="get">
                <input type="hidden" name="name_old" value="${i.name}">
                <input type="hidden" name="age_old" value="${i.age}">
                <button type="submit" >Обновить</button>
            </form>
        </tr>
        <tr>
            <form action="/deleteusers" method="post">
                <input type="hidden" name="nameDelete" value="${i.name}">
                <input type="hidden" name="ageDelete" value="${i.age}">
                <button type="submit">Удалить</button>
            </form>
        </tr>
    </table>
</c:forEach>
</body>
</html>
