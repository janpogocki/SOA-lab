<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 23.03.2017
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Wynik wyszukiwania</title>
</head>
<body>

<c:forEach var="marka" items="${marki}">
    ${marka}<br/>
</c:forEach>

</body>
</html>
