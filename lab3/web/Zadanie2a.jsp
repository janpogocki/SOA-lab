<%@ page import="com.example.Zadanie2.Messages" %><%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 28.03.2017
  Time: 21:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Księga gości</title>
</head>
<body>

<form action="Zadanie5GuestsBook" method="post">
    <b>Please send your feedback:</b>
    <br>
    Your name: <input type="text" name="name"/>
    <br>Your email: <input type="text" name="email"/>
    <br>Comment: <input type="text" name="comment"/>

    <br><input type="submit" value="Send feedback"/>
</form>
<br>
<hr>
<br>

<%
    Messages wiadomosci = new Messages();
    wiadomosci.addMessage("Jan Kowalski", "jan@kowalski.pl", "Tak, to ja!");
    wiadomosci.addMessage("Janina Kowalska", "janina@kowalski.pl", "Jana nie znam");
    wiadomosci.addMessage("Piotr Nowak", "piotr@nowak.pl", "Fajna księga gości ;)");
    wiadomosci.addMessage("Petra Novak", "petra@kowalski.pl", "Piotr, kommen Sie nach hause!");

    out.print(wiadomosci.printMessages());

%>

</body>
</html>
