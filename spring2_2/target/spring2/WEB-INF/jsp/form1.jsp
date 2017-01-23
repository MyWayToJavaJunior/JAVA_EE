<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 13.01.2017
  Time: 18:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Форма</title>
</head>
<body>

    <spring:form modelAttribute="newComment" method="post">
        Автор:
        <spring:input path="author"/>
        <br/>
        Сообщения:
        <spring:textarea path="message"/>
        <br/>
        <%--<spring:select path="gender">&ndash;%&gt;
            <spring:option value="M"/>
            <spring:option value="F"/>
            <spring:option value="U"/>
        </spring:select>--%>

        <%--<spring:select path="gender">
            <spring:options items="${newComment.genders}"/>
        </spring:select>--%>
        <%--<spring:select path="gender" items="${newComment.gendersMap}">
        </spring:select>--%>
        <spring:select path="gender">
            <spring:option value="123"/>
            <spring:options items="${newComment.genders}"/>
            <spring:option value="456"/>
        </spring:select>
        <br/>

        Языки:<br/>
       <spring:checkboxes path="languages" items="${newComment.languagesNames}"/>


        <br/>
        <input type="text" name="field123"/>
        <input type="color" name="field123456"/>
        <br/>
        <spring:button>Ок</spring:button>
    </spring:form>

</body>
</html>
