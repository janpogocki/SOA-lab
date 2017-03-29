<%@ page import="com.example.Zadanie2.MessagesFile" %>
<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 29.03.2017
  Time: 10:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edytor wiadomości</title>
</head>
<body>

<%
    String edit = request.getParameter("edit");
    String editPost = request.getParameter("editPost");
    String content = request.getParameter("content");
    MessagesFile wiadomosci = new MessagesFile();
    if (edit != null){
        if (!MessagesFile.isBlocked(edit)){
            // is not bloked = can edit
            MessagesFile.setBlock(edit);
%>

<form action="Zadanie2edit.jsp" method="post">
    <input type="text" name="content" value="<% out.print(wiadomosci.getMessage(edit)); %>" />
    <input type="hidden" name="editPost" value="<% out.print(edit); %>" />
    <br><br>
    <input type="submit" value="Wyślij" />
</form>

<%
        }
        else
            out.print("Ktoś już edytuje ten komentarz. Poczekaj aż skończy.");
    }
    else if (content != null){
        // update entry
        wiadomosci.updateMessage(editPost, content);
        MessagesFile.removeBlock(editPost);

        response.sendRedirect("Zadanie2b.jsp");
    }
%>



</body>
</html>
