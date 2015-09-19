package datos;

import java.sql.*;
import java.util.ArrayList;

import entidades.Jugador;

public class DatosJugadores {
	
	public ArrayList<Jugador> getJugadores(int dni1, int dni2) {
		
		PreparedStatement stmt=null;;
		ResultSet rs=null;
		ArrayList<Jugador> jugadores=null;
		try{
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("select * from Jugadores where dni=? or dni=?");
			stmt.setInt(1, dni1);
			stmt.setInt(2, dni2);
			rs=stmt.executeQuery();
			jugadores= new ArrayList<Jugador>();
			while(rs.next()){
				Jugador j= new Jugador();
				j.setDni(rs.getInt("dni"));
				j.setApellido(rs.getString("apellido"));
				j.setNombre(rs.getString("nombre"));
				
				jugadores.add(j);
			}
			return jugadores;
		}catch(SQLException e){
			// TODO Auto-generated catch block
		}
		finally{
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
		return null;
	}
	
	
	/**
	 * Busca el nombre y apellido del jugador por Dni y lo retorna como String.
	 * */
	public String getNomyApe(int dniTurno) {
		PreparedStatement stmt=null;
		ResultSet rs=null;
		String retorno="";
		try{
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("Select nombre, apellido from Jugadores where dni=?");
			stmt.setInt(1, dniTurno);
			rs= stmt.executeQuery();
			if(rs!=null && rs.next()){
				retorno= (rs.getString("nombre")+ rs.getString("apellido"));
			}
			return retorno;
		}catch(SQLException e){
			// TODO Auto-generated catch block
		}
		finally{
			try {
				if(rs!=null ) rs.close();
				if(stmt != null) stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			FactoryConexion.getInstancia().releaseConn();
		}
		
		return null;
	}
}
