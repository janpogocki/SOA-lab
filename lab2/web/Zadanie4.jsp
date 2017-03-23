<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 22.03.2017
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zadanie 4</title>
</head>
<body>
    <form action="CarChoiceServlet" method="post">
        Rodzaj samochodu:
            <select name="rodzaj">
                <option value="sportowy">sportowy</option>
                <option value="miejski">miejski</option>
                <option value="luksusowy">luksusowy</option>
            </select>
        <br><br>
        Przedział cenowy:
        <input type="text" name="przedzial" />
        <br><br>
        <input type="submit" value="Wyślij" />
    </form>
</body>
</html>
