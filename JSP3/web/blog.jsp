<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 14.12.16
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="blog" class="ru.sstu.BlogBean" scope="application"/>
<jsp:useBean id="auth" class="ru.sstu.AuthBean" scope="session"/>

<jsp:setProperty name="auth" property="login" value="${param.login}"/>


<jsp:setProperty name="blog" property="login" value="${auth.login}"/>
<jsp:setProperty name="blog" property="newComment" value="${param.commentText}"/>

<html>
<head>
    <title><jsp:getProperty name="blog" property="title"/></title>
</head>
<body>
<c:if test="${!auth.authorized}">
    <div>
        Авторизация:
        <form method="post">
            <p>логин:<input type="text" name="login"/></p>
            <p><button type="submit">Авторизация</button></p>
        </form>
    </div>
</c:if>

<h1><jsp:getProperty name="blog" property="title"/></h1>

<div><jsp:getProperty name="blog" property="post"/></div>

<c:if test="${auth.authorized}">
    Оставьте комментарий:
    <form method="post">
        <p><textarea name="commentText"></textarea></p>
        <p><button type="submit">Отправить</button></p>
    </form>
</c:if>

Комментарии:
<c:if test="${blog.comments.size() == 0}">
    Комментариев пока нет...
</c:if>
<c:if test="${blog.comments.size() > 0}">
    <c:forEach items="${blog.comments}" var="comment">
        <div>
            <div><c:out value="${comment.author}"/> написал(-а) [<c:out value="${comment.added}"/>]</div>
            <div>
                <c:out value="${comment.content}"/>
            </div>
        </div>
    </c:forEach>
</c:if>
</body>
</html>
