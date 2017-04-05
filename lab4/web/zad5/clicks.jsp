<%@ page import="com.zadanie5.Counter5" %><%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 05.04.2017
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean id="counter" class="com.zadanie5.Counter5" />
<html>
<head>
    <title>Kliknięcia</title>
</head>
<body>

Baner 1: <% out.print(counter.getClicks(0)); %><br>
Baner 2: <% out.print(counter.getClicks(1)); %><br>

</body>
</html>
