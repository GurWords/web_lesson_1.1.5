<%--
  Created by IntelliJ IDEA.
  User: GEORGY
  Date: 02.05.2020
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="/addusers" method="post">
    Name:
    <input name="name" type="text">
    Age:
    <input name="age" type="number">
    Password:
    <input name="password" type="text">
    Role:
    <input name="role" type="text">
    <input type="submit">
</form>
</body>
</html>
