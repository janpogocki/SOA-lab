<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 19.05.2017
  Time: 00:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="com.lab8.BooksEntity" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="TableSQLBean" class="com.lab8.TableSQL" scope="application" />

<html>
  <head>
    <title>Katalog książek</title>
  </head>
  <body>

  <h1>Katalog</h1><br>

  <table border="1|1">
      <tr>
          <td><b>ID</b></td>
          <td><b>Nazwisko autora</b></td>
          <td><b>Imię autora</b></td>
          <td><b>Tytuł</b></td>
          <td><b>ISBN</b></td>
          <td><b>Rok wydania</b></td>
          <td><b>Cena</b></td>
          <td>&nbsp;</td>
          <td>&nbsp;</td>
      </tr>

      <%
          List<BooksEntity> listOfBooks = TableSQLBean.getTableSQL();
      %>

      <c:forEach items="<%=listOfBooks%>" var="book">

          <tr>
              <td><c:out value="${book.id}" /></td>
              <td><c:out value="${book.surname}" /></td>
              <td><c:out value="${book.name}" /></td>
              <td><c:out value="${book.title}" /></td>
              <td><c:out value="${book.isbn}" /></td>
              <td><c:out value="${book.yearOfRelease}" /></td>
              <td><c:out value="${book.price}" /></td>
              <td><a href="bookEdit.jsp?id=<c:out value="${book.id}" />">Edycja</a></td>
              <td><a href="bookDelete?id=<c:out value="${book.id}" />">Usuń</a></td>
          </tr>

      </c:forEach>

  </table>

  <br>
  <a href="bookAdd.jsp"><h3>Dodaj nową książkę</h3></a>

  </body>
</html>
