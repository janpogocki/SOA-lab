<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 30.03.2017
  Time: 17:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sklep internetowy</title>
    <jsp:useBean id="KoszykBean" class="com.example.Zadanie4.Koszyk" scope="session" />
</head>
<body>

<%
    if(request.getParameter("produkt") != null) {
        KoszykBean.addProduct(Integer.parseInt(request.getParameter("produkt")));
    }
%>

Sklep internetowy - witamy!

<br><br>

<a href="Zadanie4zarzadzanie.jsp">Twój koszyk</a> (<b><% out.print(KoszykBean.getSize()); %></b> elementów o wartości <b>PLN <% out.print(KoszykBean.getFinalPrice()); %></b>)<br>

<br><br>

<c:import var="productInfo" url="produkty.xml"/>
<x:parse xml="${productInfo}" var="output"/>
<form name="Koszyk" method="post">
    <table border="1">
        <tr><td><b>ID</b></td><td><b>Nazwa</b></td><td><b>Cena</b></td><td></td></tr>
        <x:forEach select="$output/products/product" var="item">
            <tr>
                <td><x:out select="$item/id" /></td>
                <td><x:out select="$item/name"/></td>
                <td>PLN <x:out select="$item/price" /></td>
                <td><button type="submit" name="produkt" value="<x:out select="$item/id" />">Dodaj do koszyka</button></td>
            </tr>
        </x:forEach>
    </table>
</form>

</body>
</html>
