<%@ page import="java.util.ArrayList" %>
<%@ page import="com.example.Zadanie5.Film" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html><head></head>
<body>

<%
    ArrayList<Film> filmList = (ArrayList<Film>) request.getAttribute("filmy");
%>
    <h1>Lista filmów</h1>
    <table border="1">
        <tr>
            <th>Tytuł</th>
            <th>Gatunek</th>
            <th>Rok</th>
            <th>Dochód</th>
        </tr>
    <c:forEach items="<%=filmList%>" var="film">
        <tr>
            <td><c:out value="${film.tytul}" /></td>
            <c:choose>
                <c:when test="${film.gatunek == 'wojenny'}">
                    <td bgcolor="#7fffd4">
                        <c:out value="${film.gatunek}" />
                    </td>
                </c:when>
                <c:otherwise>
                    <td>
                        <c:out value="${film.gatunek}" />
                    </td>
                </c:otherwise>
            </c:choose>
            <td><c:out value="${film.rok}" /></td>
            <fmt:setLocale value="en_US"/>
            <td><fmt:formatNumber value="${film.dochod}" type="currency" maxFractionDigits="2" /></td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
