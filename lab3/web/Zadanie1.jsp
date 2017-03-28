<%--
  Created by IntelliJ IDEA.
  User: Jan
  Date: 28.03.2017
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="tt" uri="/WEB-INF/tags/zad1tag_lib.tld" %>

<html>
<head>
    <title>Zadanie 1</title>
</head>
<body>

<t:zad1login />

<br><br><hr><br><br>

<t:zad1list_of_users sortowanie="asc" kolor_daty="red" />

<br><br><hr><br><br>

<tt:naglowek tresc_naglowka="Przykładowy tytuł" wyrownanie_naglowka="right" kolor_tresci_akapitu="green">
    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus fringilla nisi nec blandit faucibus. Praesent sed finibus tortor.
    Integer et volutpat justo. Cras quam neque, commodo feugiat dui ut, auctor vehicula dui.
    Donec sit amet augue vitae lectus malesuada eleifend.
    Praesent rutrum, nisl sit amet pellentesque tristique, dui tellus aliquet urna, eu porta ligula erat eget ex.
    Aliquam ut gravida massa, sed dapibus quam.
</tt:naglowek>

<br><br><hr><br><br>

<t:zad1waluty_converter val_in="10" waluta_in="eur" waluta_out="pln" />

</body>
</html>
