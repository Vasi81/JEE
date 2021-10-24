<%@page import="modelo.daos.IntEventoDao"%>
<%@page import="modelo.daos.EventoDaoImpl" %>
<%@page import="modelo.beans.Evento" %>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

IntEventoDao eventoDao=new EventoDaoImpl();
eventoDao=(IntEventoDao)request.getSession().getAttribute("eventoDao");
List<Evento> lista=(List<Evento>) eventoDao.findAll();
%>

<%
if (lista != null) {
	for (Evento ele : lista) {
		if (ele.getEstado().equals("reservado")) {
%>     <p><%=ele.getIdEvento()%></p>     <%     }     }     }     %>
</body>
</html>