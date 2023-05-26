<%@page import="com.cine.cine.presentation.comprado.Model"%>
<%@page import="com.cine.cine.logic.*"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%@ include file="/presentation/Head.jsp" %>
        <title>Pelicula</title>
        <style>
            .detalle{
                display:flex;
                align-items: center;
                justify-content: center;
                border-bottom: 4px solid #47c9cf;
                margin-left: auto;
                margin-right: auto;
                padding-bottom: 15px;
                height: 200px;
                font-size: 12px;
            }
            .detalle-imagen{
                margin-right: 50px;
            }
            .columna1{
                display:flex;
                padding: 0;
                margin: 0;
                flex-direction: column;
                font-weight: bold;
            }
            .columna2{
                padding: 0;
                margin: 0;
                display:flex;
                flex-direction: column;
            }
            .columna3{
                padding: 0;
                margin: 0;
                margin-left: 40px;
                display:flex;
                flex-direction: column;
            }
            .columna4{
                padding: 0;
                margin: 0;
                margin-left: 40px;
                display:flex;
                flex-direction: column;
            }
        </style>
    </head>
    <body>
        <%
            Model model = (Model) request.getAttribute("model");
        %>
        <%@ include file="/presentation/Header.jsp" %>
        <h1>Detalle de compra</h1>
        <div class="detalle">
            <div class="detalle-imagen">
                <img src="http://localhost:8080/Cine/presentation/comprado/imagen?nombre=<%=model.getPelicula().getNombre()%>.png" alt="p1" height="100">
            </div>
            <div class="columna1">
                <p>Película</p>
                <p>Formato</p>
                <p>Horario</p>
                <p>Fecha</p>
                <p>Sala</p>
                <p>Censura</p>
            </div>
            <div class="columna2">
                <p><%=model.getPelicula().getNombre()%></p>
                <p><%=model.getPelicula().getFormato()%></p>
                <p><%=model.getPelicula().getTandas().get(0)%></p>
                <p><%=model.getPelicula().getFecha()%></p>
                <p><%=model.getPelicula().getSala()%></p>
                <p><%=model.getPelicula().getPublicoAdmite()%></p>
            </div>
            <div class="columna3">
                <p style="font-weight: bold;">Boletos</p>
                <p>General</p>
                <p>Adulto Mayor</p>
            </div>
            <div class="columna4">
                <p style="font-weight: bold;">Costo</p>
                <p><%=model.getPelicula().getPrecioGeneral()%></p>
                <p><%=model.getPelicula().getPrecioAdultoMayor()%></p>
            </div>
            <div class="columna4">
                <p style="font-weight: bold;">TOTAL:</p>
                <p><%=(model.getPelicula().getPrecioGeneral()*model.getTicket().getCantidadBoletosGenerales())+(model.getPelicula().getPrecioAdultoMayor()*model.getTicket().getCantidadBoletosAdultos())%></p>
            </div>
        </div>
            <br>
        <div class="ticket-container">
            <h1>TIQUETE:</h1>
            <label><%=model.getTicket().getCodigo()%></label>
        </div>
    </body>