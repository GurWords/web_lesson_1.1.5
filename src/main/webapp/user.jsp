<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  Created by IntelliJ IDEA.
  User: GEORGY
  Date: 01.05.2020
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<ul>
    <li>
        <c:out value="${requestScope.get(\"user\").getName()}"/>
    </li>
    <li>
        <c:out value="${requestScope.get(\"user\").getAge()}"/>
    </li>
    <li>
        <c:out value="${requestScope.get(\"user\").getPassword()}"/>
    </li>
    <li>
        <c:out value="${requestScope.get(\"user\").getRole()}"/>
    </li>
</ul>

</body>
</html>
