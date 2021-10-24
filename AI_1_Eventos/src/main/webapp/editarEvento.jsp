<%@page import="modelo.beans.Evento" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Evento evento=(Evento)request.getSession().getAttribute("evento"); %>
<p>Id:<%=evento.getIdEvento()%></p>
<p>Nombre:<%=evento.getNombre()%></p>
<p>Descripcion :<%=evento.getNombre()%></p>
<p>Fecha_inicio:<%=evento.getFechaInicio()%></p>
<p>Duracion :<%=evento.getDuracion()%></p>
<p>Direccion:<%=evento.getDireccion()%></p>
<p>Estado:<%=evento.getEstado() %></p>
<p>Destacado:<%=evento.getDestacado()%></p>
<p>Fecha_inicio:<%=evento.getFechaInicio()%></p>
<p>Aforo_maximo:<%=evento.getAforoMaximo()%></p>
<p>Min_asistencia:<%=evento.getMinAsistencia()%></p>
<p>Precio:<%=evento.getPrecio()%></p>
<p>Tipo:<%=evento.getTipo()%></p>


</body>
</html>