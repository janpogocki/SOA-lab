<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 05.04.2017
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="counter" class="com.zadanie5.Counter5" />

<%
    int id = Integer.parseInt(request.getParameter("id").replace("b", "").replace(".jpg", ""));
    counter.increment(id);

    response.sendRedirect("https://www.google.pl");

%>
