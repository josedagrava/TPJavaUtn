package datos;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;

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
	 * Carga el HashMap colPosiciones con las posiciones de la partida de la DB
	 * */
	public void getDatosPosiciones(int id) {
		ResultSet rs=null;
		PreparedStatement stmt= null;
		colPosiciones= new HashMap<Posicion, Pieza>();
		
		try{
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
//<<<<<<< HEAD

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

	
	
	
	public Boolean guardarMovimiento(Posicion posInicio,String destino){
		Posicion po= null;
		Pieza pi=null;
		Boolean v=Boolean.TRUE;
		
		 for( Entry<Posicion, Pieza> entry : colPosiciones.entrySet()) {
			     Posicion key = entry.getKey();
			     
			     Pieza value = entry.getValue();
			     
			     if(key == posInicio){
			    	 po=key;
			    	 pi= value;
			    	 
			    	 colPosiciones.remove(key);
			    	 colPosiciones.remove(value);
			    	 
			    	 }
			     }
		 
		 po.setPosicion(destino);
		 colPosiciones.put(po, pi);
		 
		 
		 for (Map.Entry<Posicion, Pieza> entry : colPosiciones.entrySet()) {
		     Posicion key = entry.getKey();
		     
		     Pieza value = entry.getValue();
		     
		     if(key.getPosicion() == destino){
		    	 
		    	 if(key.getTipoPieza()=="Rey"){
		    		 v=Boolean.FALSE;
		    	 
		    	 }
		    	 colPosiciones.remove(key);
		    	 colPosiciones.remove(value);
		    	 
		    	 }
		     }
		 
		 return v;

		 	 }
	 
		 
	 public Posicion devolverPosicion( String origen){
		 Posicion po;
		 po=null;

		 for (Posicion p : colPosiciones.keySet()) {
		     
			if(p.getPosicion()==origen){
				 po=p;
			 }
		 
		 }
		
		 return po;
		 
	 }
	 
	 
	 public String [][] devolverPosiciones(){
		 
		 String [][] posiciones= null;
		 int n=0;
		 int m=0;
		 
		 for (Entry<Posicion, Pieza> entry : colPosiciones.entrySet()) {
		     Posicion key = entry.getKey();
		     Pieza p= entry.getValue();
		     
		     String pos= key.getTipoPieza() + key.getPosicion();
		     
		     if(p.getColor()=="B"){
		    	
		    	 posiciones[n][1]=pos;
			     n++;
		     }
		     else{
		    	 posiciones[m][2]=pos;
		    	 m++;
		     }
		    
	     }
		 return posiciones;
		}

}
