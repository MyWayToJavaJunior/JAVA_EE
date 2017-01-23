<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 13.01.2017
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Комментарии</title>
</head>
<body>
<ul>
    <c:forEach items="${comments}" var="comment">
        <li>${comment.message}</li>
    </c:forEach>
</ul>
</body>
</html>
