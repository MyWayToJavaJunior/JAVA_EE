<%--
 это комментарий JSP
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><%-- слева - директива --%>
<html>
<!-- Comment -->
<%! private int counter = 0;//объявление %>

<%!
  private int sum(int a, int b)//объявление
{
    return a+b;
}
%>
<!-- это комментарий HTML -->
  <%
    //scriplet
    application.setAttribute("title", "Index super page!?");
    application.setAttribute("counter", counter++);

  %>
  <%@include file="WEB-INF/jsp/head.jsp"%>
  <body>
  $END$
По-русски!<br/>
  <%= getClass().getCanonicalName() %><br/>
  <%= getClass().getSuperclass().getCanonicalName()  %><br/>
  <%= sum(5, 3)  %><br/>
  <%
    out.write("JSP Writer<br/>");
  %>
  <%=  "Query String = " + request.getQueryString() %><br/>
  <%
    //response.getWriter().write("Response write!");
  %><br/>
  <%=  " Context path = "+ application.getContextPath()  %><br/>

  <%@include file="WEB-INF/jsp/footer.jsp"%><%-- слева - директива --%>
  <%@include file="WEB-INF/jsp/footer.jsp"%>
  </body>
</html>
