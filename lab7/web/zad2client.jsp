<%@ page import="com.zad2.Firma" %>
<%@ page import="com.zad2.Storage2" %><%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 04.05.2017
  Time: 00:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zad2client</title>
</head>
<body>


<table border="1|1">
<%
    for(int i=0; i<Storage2.firmList.size(); i++){
        Firma f = Storage2.firmList.get(i);
%>

    <tr><td><b>Nazwa firmy: </b>
        <%
            out.println(f.getNazwa());
        %>
        <br><b>Rodzaj firmy: </b>
        <%
            out.println(f.getRodzaj());
        %>
        <br><b>Kapital firmy: </b>
        <%
            out.println(f.getKapital());
        %>
        <br><b>Wlasiciel firmy: </b>
        <%
            out.println(f.getWlasciciel());
        %>
    </td></tr>

<%
    }
%>

</table>
</body>
</html>
