<%@tag description="Szablon logowania" pageEncoding="UTF-8"%>

<% if (session.getAttribute("logged_user") == null) { %>

Logowanie: <br><br>

<form action="Zadanie1.do" method="post">

    <input type="text" name="login" placeholder="Login" /><br><br>
    <input type="password" name="password" placeholder="Hasło" />

    <br><br>

    <input type="submit" value="Wyślij" />

</form>

<% } else {%>

<a href="Zadanie1.do?Logout">Wyloguj się</a>

<% } %>