<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="Movimiento" method="post">
	<h4>Ingrese el movimiento de la pieza deseada</h4>
	<table>
		<tr>
			<td>El turno es de: <%=request.getAttribute("turno")%></td>
			<td> </td>
		</tr>
		<tr>
			<td> aca va lista de blancas</td>
			<td> aca va lista de negras</td>
			<td> aca imagen dl tablero </td>
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
			<td><input type="submit" id="btnMover" value="Mover"></td>
			<td><input type="submit" id="btnGuardar" value="Guardar"></td>
		</tr>
	</table>
	</form>
</body>
</html>