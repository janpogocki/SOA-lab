<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 28.03.2017
  Time: 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zgadywanka</title>
</head>
<body>

<%
    int random, proba;

    if (request.getParameter("random") == null)
        random = (new Random(System.currentTimeMillis())).nextInt(100);
    else
        random = Integer.parseInt(request.getParameter("random"));

    if (request.getParameter("proba") == null)
        proba = 0;
    else {
        proba = Integer.parseInt(request.getParameter("proba"));
        proba++;
    }

%>

<form action="Zadanie3.jsp" method="post">
    Podaj liczbę: <input type="number" min="0" max="100" name="liczba_input" /> <input type="submit" value="Wyślij" />

    <input type="hidden" name="proba" value="<% out.print(proba); %>" />
    <input type="hidden" name="random" value="<% out.print(random); %>" />

</form>

<br><br>

<%
    if (request.getParameter("liczba_input") != null && Integer.parseInt(request.getParameter("liczba_input")) > random)
        out.print("Twoja liczba (" + request.getParameter("liczba_input") + ") jest <b>większa</b> niż zagadka");
    else if (request.getParameter("liczba_input") != null && Integer.parseInt(request.getParameter("liczba_input")) < random)
        out.print("Twoja liczba (" + request.getParameter("liczba_input") + ") jest <b>mniejsza</b> niż zagadka");
    else if (request.getParameter("liczba_input") != null && Integer.parseInt(request.getParameter("liczba_input")) == random)
        out.print("Brawo, zgadłeś/łaś liczbę po " + proba + " próbach.<br><a href=\"Zadanie3.jsp\">Spróbuj jeszcze raz</a>");
%>

</body>
</html>
