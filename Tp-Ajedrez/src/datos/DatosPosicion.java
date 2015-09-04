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
	
	static HashMap<Posicion, Pieza> colPosiciones;
	
	/**
	 * Duevuelve los datos de las posiciones almacenas en la BD.
	 * */
	public void getDatosPosiciones(int id) {
		ResultSet rs=null;
		PreparedStatement stmt= null;
		colPosiciones= new HashMap<Posicion, Pieza>();
		
		try{
		//	ArrayList<Posicion> posiciones= new ArrayList<Posicion>();
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("Select * from Posicion where idPartida=?");
			stmt.setInt(1, id);
			
			rs= stmt.executeQuery();
			while(rs.next()){
				Posicion posic=new Posicion();
				posic.setIdPartida(rs.getInt("idPartida"));
				posic.setEstaEnTablero(rs.getBoolean("estaEnTablero"));
				posic.setPosicion(rs.getString("posicion"));
				Pieza pieza=devolverObjetoPieza(rs.getString("tipoPieza"));
				pieza.setColor(rs.getString("color"));
				
				colPosiciones.put(posic, pieza);
				//posiciones.add(posic);
			}
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
	}
	
	public static HashMap<Posicion, Pieza>getHashMap(){
		return colPosiciones;
	}
	
	/**
	 * devuelve el objeto de Pieza
	 * */
	private Pieza devolverObjetoPieza(String tipoPieza) {
		
		Pieza objeto=null;
		switch (tipoPieza) {
		case "P": objeto= new Peon();
			break;
		case "T": objeto = new Torre();
			break;
		case "A": objeto = new Alfil();
			break;
		case "C": objeto = new Caballo();
			break;
		case "R": objeto = new Rey();
			break;
		case "D": objeto = new Reina();
			break;
		default:
			break;
		}
		return objeto;
	}
	 
	 /**
	  * Instancia las posiciones iniciales en el hashmap
	  * */
	static void addPosicionesIniciales(Posicion p, Pieza ficha) {
		colPosiciones= new HashMap<Posicion, Pieza>();
		
		Peon.posicionInicial(colPosiciones);
	}
}
