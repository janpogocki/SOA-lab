<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Szablon listy użytkowników zalogowanych" pageEncoding="UTF-8"%>

<%@attribute name="sortowanie" required="true" %>
<%@attribute name="kolor_daty" required="false" %>

<jsp:useBean id="bean" class="com.example.Zadanie1.UsersBean" scope="request" />

<table border="1">

    <tr>
        <td><b>Login</b></td>
        <td><b>Data zalogowania</b></td>
    </tr>

<% if (bean.count() > 0) {
    for (String element : bean.getListOfUsers(sortowanie)){
%>
<tr>
<td><% out.println(element.split("&")[0]); %></td> <!-- nick -->
    <td><span style="color:${kolor_daty}"><% out.println(element.split("&")[1]); %></span></td> <!-- data -->
</tr>

<%
    }
}

%>

</table>