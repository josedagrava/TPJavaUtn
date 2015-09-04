package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import entidades.Alfil;
import entidades.Caballo;
import entidades.Peon;
import entidades.Pieza;
import entidades.Posicion;
import entidades.Reina;
import entidades.Rey;
import entidades.Torre;

public class DatosPosicion {
	
	static HashMap<Pieza, Posicion> colPosiciones;
	
	/**
	 * Duevuelve los datos de las posiciones almacenas en la BD.
	 * */
	public HashMap<Pieza,Posicion> getDatosPosiciones(int id) {
		ResultSet rs=null;
		PreparedStatement stmt= null;
		
		try{
			ArrayList<Posicion> posiciones= new ArrayList<Posicion>();
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("Select * from Posicion where idPartida=?");
			stmt.setInt(1, id);
			
			rs= stmt.executeQuery();
			while(rs.next()){
				Posicion posic=new Posicion();
				posic.setIdPartida(rs.getInt("idPartida"));
				posic.setColor(rs.getString("color"));
				posic.setEstaEnTablero(rs.getBoolean("estaEnTablero"));
				posic.setTipoPieza(rs.getString("tipoPieza"));
				posic.setPosicion(rs.getString("posicion"));
				posiciones.add(posic);
			}//esto es una prueba
			this.cargarHashMap(posiciones);
			return colPosiciones;
		}
		catch(SQLException e){
			// TODO Auto-generated catch block
		}
		finally{
			try{
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
				}
			catch(SQLException e){
				// TODO Auto-generated catch block
			}
		}
		return null;		
	}

	/**
	 * Los datos traidos desde la BD son cargados al atributo estatico colposiciones;
	 * */
	 public void cargarHashMap(ArrayList<Posicion> posiciones){
		for (Posicion p : posiciones) {
			switch (p.getTipoPieza()) {
			case "P":colPosiciones.put(new Peon(), p);
				break;
			case "T": colPosiciones.put(new Torre(),p);
				break;
			case "A": colPosiciones.put(new Alfil(),p);
				break;
			case "C": colPosiciones.put(new Caballo(),p);
				break;
			case "R": colPosiciones.put(new Rey(),p);
				break;
			case "D": colPosiciones.put(new Reina(),p);
				break;
			default:
				break;
			}			
		}
		
	}
}
