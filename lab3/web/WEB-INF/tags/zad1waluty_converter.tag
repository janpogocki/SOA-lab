<%@ tag import="com.example.Zadanie1.KursyWalut" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Szablon listy użytkowników zalogowanych" pageEncoding="UTF-8"%>

<%@attribute name="val_in" required="true" %>
<%@attribute name="waluta_in" required="true" %>
<%@attribute name="waluta_out" required="true" %>

<jsp:useBean id="kursy" class="com.example.Zadanie1.KursyWalut" scope="request" />

<%
    out.println(val_in + " " + waluta_in + " = " + KursyWalut.converter(val_in, waluta_in, waluta_out) + " " + waluta_out);
%>