package datos;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("Select * from posicion where idPartida=?");
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
		
		try{
			Peon.posicionInicial(colPosiciones, id);
			Alfil.posicionInicial(colPosiciones, id);
			Torre.posicionInicial(colPosiciones, id);
			Caballo.posicionInicial(colPosiciones, id);
			Rey.posicionInicial(colPosiciones, id);
			Reina.posicionInicial(colPosiciones, id);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public void guardar() {
		
		for(Map.Entry<Posicion, Pieza> entry : colPosiciones.entrySet())
		{
			if(entry.getValue()!=null)
			{
				
				if(this.consultar(entry.getKey()))
				{
					actualizar(entry.getKey());
				}
				else
				{
					insertar(entry.getKey(), entry.getValue());
				}
				
			}
		}
	}

	private boolean consultar(Posicion p) {
		
		boolean existe=true;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from posicion where idPartida=?"
					+ "values(?)");
			stmt.setInt(1, p.getIdPartida());
			rs= stmt.executeQuery();
			
			if (rs==null)
			{
				existe=false;
			}
			else
			{
				existe=true;
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
				
			}
			FactoryConexion.getInstancia().releaseConn();
		}
		return existe;
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
			stmt.execute();
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

	
	
	
	public boolean guardarMovimiento(Posicion posInicio,String destino){
		Posicion po= null;
		Pieza pi=null;
		boolean v=true;
		
		
		po= this.devolverPosicion(destino);
		
		pi=colPosiciones.get(posInicio);
		colPosiciones.remove(posInicio);
		Posicion poNueva= posInicio;
		poNueva.setPosicion(destino);
		
		if(colPosiciones.containsKey(po)){
			if (colPosiciones.get(po) instanceof Rey) {
				v= false;
			}
		}
		colPosiciones.put(poNueva, pi);
		colPosiciones.remove(po);//this.devolverPosicion(destino));
		
		 /*for( Entry<Posicion, Pieza> entry : colPosiciones.entrySet()) {
			     Posicion key = entry.getKey();
			     
			     Pieza value = entry.getValue();
			     
			     if(key == posInicio){
			    	 po=key;
			    	 pi= value;
			    	 
			    	 colPosiciones.remove(key);
			    	 colPosiciones.remove(value);
			    	 
			    	 }
			     }*/
		 /*
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
		     }*/
		 
		 return v;

		 	 }
	
	 public Posicion devolverPosicion(String origen){
		 Posicion pos=null;
		 
		 for(Posicion p: colPosiciones.keySet()){
			 
			 if(p.getPosicion().equalsIgnoreCase(origen)){
				 pos=p;
				 break;
			 }			 
		 }
		 return pos;
	 }
		 
	 public Pieza devolverPieza(String origen){
		 Pieza pie= null;
		 
		 for (Entry<Posicion, Pieza> entry : colPosiciones.entrySet()) {
		     Posicion key = entry.getKey();
		     Pieza p= entry.getValue();
		     
			 if(key.getPosicion().equalsIgnoreCase(origen)){
				 pie=p;
				 break;
			 }
		 
		 }
		
		 return pie;
		 
	 }
	 
}
