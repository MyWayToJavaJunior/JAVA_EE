<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 13.01.2017
  Time: 18:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Автор:
${comment.author} (${comment.gender})
 знает языки
<c:forEach items="${comment.languages}" var="lang">
        ${lang},
</c:forEach>
<hr/>
${comment.message}
</body>
</html>
