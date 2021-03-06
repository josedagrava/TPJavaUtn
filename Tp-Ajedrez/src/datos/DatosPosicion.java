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
			
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("select * from posicion where idPartida=?");
			
			stmt.setInt(1, id);
			
			rs= stmt.executeQuery();
			while(rs.next()){
				
				Posicion posic=new Posicion();				
				posic.setIdPartida(rs.getInt("idPartida"));
				posic.setPosicion(rs.getString("posicion"));
				posic.setTipoPieza(rs.getString("tipoPieza"));
				
				Pieza pieza=devolverObjetoPieza(rs.getString("tipoPieza"));
				pieza.setColor(rs.getString("color"));
				
				colPosiciones.put(posic, pieza);
				
			}
		}
		catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
				}
			catch(SQLException e){
				// TODO Auto-generated catch block
			}
			FactoryConexion.getInstancia().releaseConn();
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
		
		boolean b=false;

		for(Map.Entry<Posicion, Pieza> entry : colPosiciones.entrySet())
		{
			b= this.consultar(entry.getKey());
			if(b) eliminarPosicion(entry.getKey());
			break;
		}
		
		for(Map.Entry<Posicion, Pieza> entry : colPosiciones.entrySet())
		{
			//if(entry.getValue()!=null)
			{	
				insertar(entry.getKey(), entry.getValue());
				
			}
		}
	}

	private boolean consultar(Posicion p) {
		
		boolean existe=true;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try{

			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("select * from posicion where idPartida=?");

			stmt.setInt(1, p.getIdPartida());
			
			rs= stmt.executeQuery();
			
			if (rs!=null && rs.next())
			{
				existe=true;
			}
			else existe=false;
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
	
	public void eliminarPosicion(Posicion p)
	{
		PreparedStatement stmt= null;
		try{
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("DELETE from posicion where idPartida=?");
			stmt.setInt(1, p.getIdPartida());
			stmt.execute();
			
		}catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
				try{
					if(stmt != null) stmt.close();
				}catch(SQLException e){
			// TODO Auto-generated catch block
					}
				FactoryConexion.getInstancia().releaseConn();	
			}
	}

	public void insertar(Posicion p, Pieza pi)
	{
		PreparedStatement stmt=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into posicion(tipoPieza, posicion, color, idPartida)"
					+ "values(?,?,?,?)");
			stmt.setString(1, p.getTipoPieza());
			stmt.setString(2, p.getPosicion());
			stmt.setString(3, pi.getColor());
			stmt.setInt(4, p.getIdPartida());

			stmt.execute();
		}
		catch(SQLException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			try{
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
