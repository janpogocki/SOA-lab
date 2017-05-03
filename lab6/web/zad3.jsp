<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 26.04.2017
  Time: 15:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zadanie3</title>
</head>
<body>

<form action="Servlet3" method="post">
    <h1>Przeliczanie temperatury</h1><br>

    <input type="number" name="temperatura" />

    <select name="jednostka">
        <option value="c">°C</option>
        <option value="f">°F</option>
    </select>

    <input type="submit" value="Przelicz" />
</form>

</body>
</html>
