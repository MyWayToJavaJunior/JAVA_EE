<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 12.12.16
  Time: 17:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Tags</title>
</head>
<body>
<jsp:useBean id="my" class="ru.sstu.MyBean"/>
<h1>Tags page!</h1>
<%--<jsp:forward page="index.jsp"/>--%>

JSP Tag Include: <jsp:include page="part.jsp"/>
JSP Directive Include: <%@include file="part.jsp"%>

<h1>JSTL</h1>

<h2>c:out</h2>
message1 = <c:out value="${my.message1}"/><br/>
message2 = <c:out value="${my.message2}" default="NO MESSAGE"/><br/>
message2 = <c:out value="${my.message2}" escapeXml="false"/><br/>

<h2>c:if</h2>

<c:if test="${my.randomBoolean}">
    <p>Вы знаете EL - Expression Language</p>
</c:if>
<c:if test="${7 > my.randomInt}">
    <p>Вы знаете EL - Expression Language</p>
</c:if>

<h2>c:choose</h2>
<c:choose>
    <c:when test="${my.randomInt%2 == 0}">
        Кратно 2
    </c:when>
    <c:when test="${my.randomInt%3 == 0}">
        Кратно 3
    </c:when>
    <c:when test="${my.randomInt%4 == 0}">
        Кратно 4
    </c:when>
    <c:otherwise>
        Ничему не кратно((
    </c:otherwise>
</c:choose>

<h2>c:forEach</h2>
<h3>Строки:</h3>
<c:forEach items="${my.messages}" var="m">
    <c:out value="${m}"/><br/>
</c:forEach>
<h3>Даты:</h3>
<c:forEach items="${my.dates}" var="d">
    <c:out value="${d.time}"/><br/>
</c:forEach>

<h3>Со счетчиком:</h3>
<c:forEach begin="1" end="10" step="2" var="i">
    <c:out value="${i}"/><br/>
</c:forEach>

<h2>c:forTokens</h2>
<h3>Мама:</h3>
<c:forTokens items="Мама мыла раму, смотря в окно... Потом; пошла,, в?? магазин" delims=" ,;.?" var="t">

    <c:out value="${t}"/><br/>
</c:forTokens>
<h3>Гуглим составляющие пути:</h3>
<c:forTokens items="projects/myproject/src/ru/sstu" delims="/" var="t">
    <a href='http://google.com?q=<c:out value="${t}"/>'>
        <c:out value="${t}"/>
    </a>
    <br/>
</c:forTokens>

<h3>Получаем токены из бина:</h3>
<c:forTokens items="${my.message1}" delims=" " var="t">
        <c:out value="${t}"/><br/>
</c:forTokens>

<h2>c:catch</h2>


<c:catch var="ex">
    <%
        int i = 5/0;
    %>
</c:catch>

<c:if test="${ex != null}">
    Error!
    <c:out value="${ex.message}"/>
</c:if>

<%--<c:redirect url="index.jsp"/>--%>





</body>
</html>
