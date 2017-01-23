<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Shvarts
  Date: 16.01.2017
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Анкета</title>
    <style>
        .errors
        {
            color: #f00;
        }
    </style>
</head>
<body>

<spring:form modelAttribute="surveyForm">

    <table>
        <caption>Анкета</caption>
        <tbody>
        <tr>
            <td>
                <spring:label path="name">Имя</spring:label>
            </td>
            <td>
                <spring:input path="name"/>
            </td>
            <td>
                <spring:errors path="name" cssClass="errors"/>
            </td>
        </tr>
        <tr>
            <td>
                <spring:label path="surname">Фамилия</spring:label>
            </td>
            <td>
                <spring:input path="surname"/>
            </td>
            <td>
                <spring:errors path="surname" cssClass="errors"/>
            </td>
        </tr>
        <tr>
            <td>
                <spring:label path="patronymic">Отчество</spring:label>
            </td>
            <td>
                <spring:input path="patronymic"/>
            </td>
            <td>
                <spring:errors path="patronymic" cssClass="errors"/>
            </td>
        </tr>
        <tr>
            <td>
                <spring:label path="age">Возраст</spring:label>
            </td>
            <td>
                <spring:input path="age" type="number" min="18" max="120"/>
            </td>
            <td>
                <spring:errors path="age" cssClass="errors"/>
            </td>
        </tr>
        <tr>
            <td>
                <spring:label path="email">Email</spring:label>
            </td>
            <td>
                <spring:input path="email"/>
            </td>
            <td>
                <spring:errors path="email" cssClass="errors"/>
            </td>
        </tr>
        <tr>
            <td>
                <spring:label path="phone">Телефон</spring:label>
            </td>
            <td>
                <spring:input path="phone"/>
            </td>
            <td>
                <spring:errors path="phone" cssClass="errors"/>
            </td>
        </tr>
        </tbody>
    </table>
    <spring:button>ОК</spring:button>
    <br/>
    <spring:errors path="*" cssClass="errors"/>
</spring:form>

</body>
</html>
