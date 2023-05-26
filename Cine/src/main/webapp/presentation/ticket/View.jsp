<%@page import="com.cine.cine.presentation.ticket.Model"%>
<%@page import="com.cine.cine.logic.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="/presentation/Head.jsp" %>
        <title>San Pedro Cinemas</title>
    </head>
    <body>
        <%
            Model model = (Model) request.getAttribute("model");
        %>
        <%@ include file="/presentation/Header.jsp" %>
        <h1>Consulta de Tiquete</h1>
        <div class="ticket-container">
            <form class="ticket-form" action="presentation/cliente/poliza/next" method="post">
            <label for="codigoFld" class="ticket-label" >Número</label>
            <input type="text" name="codigoFld" required>
            <button type="submit">Consultar Tiquete</button>
            </form>
        </div>
    </body>