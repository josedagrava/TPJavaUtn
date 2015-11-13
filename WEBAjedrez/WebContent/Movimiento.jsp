<%@page import="java.util.ArrayList"%>
<%@page import="Datos.DatosPosicion"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="Entidades.Posicion"%>
<%@page import="Entidades.Pieza"%>
<%@page import="Negocio.Controladora"%>
<%@page import="java.util.HashMap"%>
<%@page import="Entidades.Partida"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<script type="text/javascript">

function clickGuardar(){
	var forma= document.getElementById("formMovimiento")
	forma.action = "Movimiento";
	var accion = document.getElementById("accion");
	accion.value= "guardar";
	forma.submit();
}

function clickMover(){
	var forma = document.getElementById("formMovimiento");
	forma.action= "Movimiento";
	var accion = document.getElementById("accion");
	accion.value = "mover";
	forma.submit();
}
</script>

</head>
<body>
	<form action="" method="post" id="formMovimiento">
	
	<input type="hidden" name="accion" id="accion">
	
	<h4 align="center">Ingrese el movimiento de la pieza deseada</h4>
	<table align="center">
		<tr>
			<td>El turno es de: <%= session.getAttribute("turno")%></td>
			<td> </td>
		</tr>
		<tr> 
			<th>Blancas</th>
			<th>Negras</th>
		</tr>
		<tr>
			<td><table align="center">
				<%ArrayList<String> listaB= (ArrayList<String>)request.getSession().getAttribute("listaBlanca");
				 	for(String b: listaB){%> 
					<tr>
						<td><%=b %></td>
					</tr>
				<% }%>
			</table> </td>
			<td><table align="center">
				<%ArrayList<String> listaN= (ArrayList<String>)request.getSession().getAttribute("listaNegra");
				 	for(String n: listaN){%> 
					<tr>
						<td><%=n %></td>
					</tr>
				<% }%>
			</table>
			</td>
			<td> <img alt="" src="https://github.com/josedagrava/TPJavaUtn/blob/master/Tp-Ajedrez/src/presentacion/Tablero.png?raw=true"></td>

		</tr>
		<tr>
			<td>Posicion origen:</td>
			<td><input name="txtorigen" type="text" id="posOrigen"></td>
		</tr>
		<tr>
			<td>Posicion destino:</td>
			<td><input name="txtdestino" type="text" id="posDestino"></td>
		</tr>
		<tr>
			<td></td>
			<td><input type="button" id="btnMover" value="Mover" onclick="clickMover()"></td>
			<td><input type="button" id="btnGuardar" value="Guardar" onclick="clickGuardar()"></td>
			
		</tr>
	</table>
	</form>
</body>
</html>