<%@page import="com.cine.cine.presentation.cartelera.Model"%>
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
        <form action="presentation/cartelera/ver" method="post">
        <h1>Escoge la fecha</h1>
        <div class="container">
            <div class="dates">
                <div class="fechas">
                    <input type="radio" id="<%=model.getDias().get(0)%>" name="fechaFld" value="<%=model.getDias().get(0)%>" checked>
                    <label for="<%=model.getDias().get(0)%>">(Hoy)<br><%=model.getDias().get(0)%></label><br>
                </div>
                <div class="fechas">
                    <input type="radio" id="<%=model.getDias().get(1)%>" name="fechaFld" value="<%=model.getDias().get(1)%>">
                    <label for="<%=model.getDias().get(1)%>"><%=model.getDias().get(1)%></label><br>
                </div>
                <div class="fechas">
                    <input type="radio" id="<%=model.getDias().get(2)%>" name="fechaFld" value="<%=model.getDias().get(2)%>">
                    <label for="<%=model.getDias().get(2)%>"><%=model.getDias().get(2)%></label><br>
                </div>
                <div class="fechas">
                    <input type="radio" id="<%=model.getDias().get(3)%>" name="fechaFld" value="<%=model.getDias().get(3)%>">
                    <label for="<%=model.getDias().get(3)%>"><%=model.getDias().get(3)%></label><br>
                </div>
            </div>
        </div>
                <br>
        <div class="peliculas-container">
            <% for(Pelicula pelicula:model.getPeliculas()){ %>
            <div class="pelicula">
                <div class="portada">
                    <img src="http://localhost:8080/Cine/presentation/cartelera/imagen?nombre=<%=pelicula.getNombre()%>.png" alt="p1" height="100">
                    <label>TRAILER</label>
                </div>
                <div class="info-peli">
                    <div class="header-peli">
                        <div class="titulo">
                            <h3><%=pelicula.getNombre()%></h3>
                        </div>
                        <div class="data">
                            <label style="background-color: gray;"><%=pelicula.getPuntuacion()%></label>
                            <label style="background-color: red;"><%=pelicula.getGenero()%></label>
                            <label><%=pelicula.getPublicoAdmite()%></label>
                        </div>
                    </div>
                    <div class="footer-peli" style="margin-top: 20px;">
                        <div class="data">
                            2D DOB - HORARIOS->
                            <%
                                for(String tanda:pelicula.getTandas()){
                            %>
                                <button type="submit" name="tandaFld" value="<%=pelicula.getNombre()%>-<%=tanda%>"><%=tanda%></button>
                              <%}%>
                        </div>
                    </div>
                </div>
            </div>
            <%}%>
        </div>
        </form>
    </body>
</html>

