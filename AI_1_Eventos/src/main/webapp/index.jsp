<%@page import="modelo.daos.IntEventoDao"%>
<%@page import="modelo.daos.EventoDaoImpl" %>
<%@page import="modelo.beans.Evento" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List"%>


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
<div>
<table border="2">
<tr>
<th width="80"height="40">Tipos</th><th width="80"height="40">Eventos</th><th width="80"height="40">Usuarios</th><th width="80"height="40">Eventos/tipo</th><th width="80"height="40">Login</th><th width="80"height="40">Registro</th><th width="80"height="40">Salir</th>
</tr>
</table>

</div>
<h3>Listado de Eventos Activos</h3>
	

<div>
    <table border="2">
        <tr>
            <th width="150"height="40"rowspan="3"><a href="/AI_1_Eventos/GestionEventos?opcion=alta">Nuevo evento</a></th>
            <th width="150"height="40"rowspan="3"><a href="/AI_1_Eventos/GestionEventos?opcion=listar">Listar activos</a></th>
        </tr>
    </table>
    <br>
</div>
<div>
<table border="0">
<tr>
<td>
    <table border="2">
            <tr>
                <th width="80"height="40">Id</th><th width="150"height="40">Nombre</th><th width="80"height="40">Precio</th><th width="80"height="40">Estado</th>
            </tr>
            <% 
            if(lista!=null){
            for(Evento ele: lista){%>
            
            <tr>
            <td><%=ele.getIdEvento()%></td>
            <td><%=ele.getNombre()%></td>
            <td><%=ele.getPrecio()%></td>
            <td><%=ele.getEstado()%></td>
           </tr>
             <%}%>
             
        </table>
</td>
<td>
        <table border="2">
            <tr>
                <th width="80"height="40"colspan="3">Opciones</th>
            </tr>
            <%for (Evento ele:lista){%>
            <tr>
            <td><a href="?opcion=editar&id=<%=ele.getIdEvento()%>">Editar</a></td>
            <td><a href="?opcion=eliminar&id=<%=ele.getIdEvento()%>">Eliminar</a></td>
            <td><a href="?opcion=cancelar&id=<%=ele.getIdEvento()%>">Cancelar</a></td>
            <%} %>
            <%} %>
            </tr>
        </table>
        </tr>
  </table>
</td>
</div>
</body>
</html>

