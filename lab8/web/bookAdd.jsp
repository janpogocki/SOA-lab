<%--
  User: Jan
  Date: 24.05.2017
  Time: 18:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dodaj książkę</title>
</head>
<body>

<h1>Dodaj książkę</h1>

<form action="bookAdd" method="post">

    <table>

        <tr>
            <td>Nazwisko autora:</td>
            <td><input type="text" name="surname" /></td>
        </tr>

        <tr>
            <td>Imię autora:</td>
            <td><input type="text" name="name" /></td>
        </tr>

        <tr>
            <td>Tytuł:</td>
            <td><input type="text" name="title" /></td>
        </tr>

        <tr>
            <td>ISBN:</td>
            <td><input type="text" name="isbn" /></td>
        </tr>

        <tr>
            <td>Rok wydania:</td>
            <td><input type="number" step="1" name="yearOfRelease" /></td>
        </tr>

        <tr>
            <td>Cena:</td>
            <td><input type="text" name="price" /></td>
        </tr>

    </table>

    <br>

    <input type="submit" value="Dodaj książkę" />

</form>

</body>
</html>
