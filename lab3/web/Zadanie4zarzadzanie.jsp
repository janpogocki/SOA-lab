<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 30.03.2017
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zarządzanie koszykiem</title>
    <jsp:useBean id="KoszykBean" class="com.example.Zadanie4.Koszyk" scope="session" />
</head>
<body>

<c:import var="productInfo" url="produkty.xml"/>
<x:parse xml="${productInfo}" var="output"/>

<%
    if (request.getParameter("produkt") != null) {
        if ((!request.getParameter("produkt").equals(""))) {
            KoszykBean.deleteProduct(Integer.parseInt(request.getParameter("produkt")));
        }
    }
%>

Sklep internetowy - witamy!

<br><br>

<a href="Zadanie4.jsp">&laquo; powrót do zakupów</a><br>

<br><br>

Wartość koszyka: <b>PLN <% out.print(KoszykBean.getFinalPrice()); %></b>

<br><br>

<c:import var="productInfo" url="produkty.xml"/>
<x:parse xml="${productInfo}" var="output"/>
<form name="Koszyk" method="post">
    <% int i=1; %>
    <table border="1">
        <tr><td><b>ID</b></td><td><b>Nazwa</b></td><td><b>Cena</b></td><td><b>Ilość w Twoim koszyku</b></td><td></td></tr>
        <x:forEach select="$output/products/product" var="item">
            <tr>
                <td><x:out select="$item/id" /></td>
                <td><x:out select="$item/name"/></td>
                <td>PLN <x:out select="$item/price" /></td>
                <td><% out.print(KoszykBean.getSizeOfID(i)); %></td>
                <td>
                    <%
                        if (KoszykBean.getSizeOfID(i) > 0){
                    %>
                    <button type="submit" name="produkt" value="<x:out select="$item/id" />">Usuń z koszyka</button></td>
                    <%
                        }

                        i++;
                    %>
            </tr>
        </x:forEach>
    </table>
</form>

</body>
</html>