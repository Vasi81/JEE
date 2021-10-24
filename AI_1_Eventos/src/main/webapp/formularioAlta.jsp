<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Alta Evento</h2>
<form action="GestionEventos" method="post">
<label for="idEvento">Id Evento:<br/></label>
<input type="number" id="idEvento "name="idEvento"/><br/>
<label for="nombre evento">Nombre Evento:<br/></label>
<input type="text" id="nombre"name="nombre"/><br/>
<label for="descripcion">Descripcion:<br/></label>
<textarea id="descripcion"name="descripcion"rows=“5” cols=“50” ></textarea><br/>
<label for="fecha_inicio">Fecha inicio:<br/></label>
<input type="date" id="fecha_inicio"name="fecha_inicio"/><br/>
<label for="duracion">Duracion:<br/></label>
<input type="number" id="duracion"name="duracion"/><br/>
<label for="dirección">Direccion:<br/></label>
<input type="text" id="direccion"name="direccion"/><br/>
<label for="estado">Estado:<br/></label>
<label for="activo">Activo</label>
<input type="radio" id="activo" name="estado" value="activo">
<label for="cancelado">Cancelado</label>
<input type="radio" id="cancelado" name="estado" value="cancelado"><br/><br/>
<label for="destacado">Destacado<br/></label>
<input type="text" id="destacado"name="destacado"/><br/>
<label for="aforo_maximo">Aforo maximo:<br/></label>
<input type="number" id="aforo_maximo"name="aforo_maximo"/><br/>
<label for="min_asistencia">Minima asistencia:<br/></label>
<input type="number" id="min_asistencia"name="min_asistencia"/><br/>
<label for="min_asistencia">Precio:<br/></label>
<input type="number" id="precio"name="precio"/><br/><br/>
<label for="tipo_concierto">Concierto</label>
<input type="radio" id="tipo"name="tipo" value="1"/><br/><br/>
<label for="tipo_despedida">Despedida</label>
<input type="radio" id="tipo" name="tipo" value="2"/><br/><br/>
<label for="tipo_cumpleaños">Cumpleaños</label>
<input type="radio" id="tipo" name="tipo" value="3"/><br/><br/>
<label for="tipo_boda">Boda</label>
<input type="radio" id="tipo" name="tipo" value="4"/><br/><br/>
<input type="submit" value="Dar de Alta"/><br/>

</form>


</body>
</html>