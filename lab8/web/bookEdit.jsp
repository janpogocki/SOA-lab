<%@ page import="com.lab8.TableSQL" %>
<%@ page import="com.lab8.BooksEntity" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 24.05.2017
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytuj książkę</title>
</head>
<body>

<%
    int idOfBook = Integer.parseInt(request.getParameter("id"));
    TableSQL tableSQL = new TableSQL();
    List<BooksEntity> listOfBooks = tableSQL.getTableSQL();
%>

<h1>Edytuj książkę</h1>

<form action="updateBook" method="post">

    <table>

        <tr>
            <td>Nazwisko autora:</td>
            <td><input type="text" name="surname" value="<% out.print(tableSQL.getBook(idOfBook).getSurname()); %>" /></td>
        </tr>

        <tr>
            <td>Imię autora:</td>
            <td><input type="text" name="name" value="<% out.print(tableSQL.getBook(idOfBook).getName()); %>" /></td>
        </tr>

        <tr>
            <td>Tytuł:</td>
            <td><input type="text" name="title" value="<% out.print(tableSQL.getBook(idOfBook).getTitle()); %>" /></td>
        </tr>

        <tr>
            <td>ISBN:</td>
            <td><input type="text" name="isbn" value="<% out.print(tableSQL.getBook(idOfBook).getIsbn()); %>" /></td>
        </tr>

        <tr>
            <td>Rok wydania:</td>
            <td><input type="number" step="1" name="yearOfRelease" value="<% out.print(tableSQL.getBook(idOfBook).getYearOfRelease()); %>" /></td>
        </tr>

        <tr>
            <td>Cena:</td>
            <td><input type="text" name="price" value="<% out.print(tableSQL.getBook(idOfBook).getPrice()); %>" /></td>
        </tr>

    </table>

    <br>

    <input type="hidden" name="id" value="<% out.print(idOfBook); %>" />
    <input type="submit" value="Zaktualizuj książkę" />

</form>

</body>
</html>
