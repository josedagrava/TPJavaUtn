package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
	
	/**
	 * Devuelve la coleccion hashMap
	 * */
	public static HashMap<Posicion, Pieza> getHashMap(){
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
	public static void addPosicionesIniciales(int id) {
		colPosiciones= new HashMap<Posicion, Pieza>();
		
		Peon.posicionInicial(colPosiciones, id);
		Alfil.posicionInicial(colPosiciones, id);
		Torre.posicionInicial(colPosiciones, id);
		Caballo.posicionInicial(colPosiciones, id);
		Rey.posicionInicial(colPosiciones, id);
		Reina.posicionInicial(colPosiciones, id);
		
	}

	public void guardar() {
		
		Iterator it = colPosiciones.entrySet().iterator();
		while(it.hasNext())
		{
			//colPosiciones.ge
		}
	}
	
	public int insertar(Posicion p, Pieza pi)
	{
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into posicion(tipoPieza, posicion, estaEnTablero, color)"
					+ "values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getTipoPieza());
			stmt.setString(2, p.getPosicion());
			stmt.setBoolean(3, p.isEstaEnTablero());
			stmt.setString(4, pi.getColor());
			rs=stmt.getGeneratedKeys();
			
			if(rs!=null && rs.next()){
				p.setIdPartida(rs.getInt("idPartida"));
				DatosPosicion.addPosicionesIniciales(p.getIdPartida());
				return p.getIdPartida();
			}
			else return 0;
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
				
			}
			FactoryConexion.getInstancia().releaseConn();
		}
		return 0;
	}
	
	public void actualizar(Posicion p)
	{
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("update posicion set posicion=? where idPartida=?"
					+ "values(?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(1, p.getPosicion());
			stmt.setInt(2, p.getIdPartida());
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
				
			}
			FactoryConexion.getInstancia().releaseConn();
		}
	}

}
