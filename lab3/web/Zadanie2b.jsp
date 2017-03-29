<%@ page import="com.example.Zadanie2.MessagesFile" %><%--
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

<form action="Zadanie2b.jsp" method="post">
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
    MessagesFile wiadomosci = new MessagesFile();

    wiadomosci.setSetEditableMessages();

    if (request.getParameter("name") != null && request.getParameter("email") != null && request.getParameter("comment") != null){
        wiadomosci.addMessage(request.getParameter("name"), request.getParameter("email"), request.getParameter("comment"));
        wiadomosci.saveListToFile();
    }

    out.print(wiadomosci.printMessages());

%>

</body>
</html>
