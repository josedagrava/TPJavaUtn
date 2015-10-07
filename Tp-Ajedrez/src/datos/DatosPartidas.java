package datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entidades.Partida;


public class DatosPartidas {
	
	public int add(Partida p){
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		
		try{
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement("insert into partidas(dniBlancas, dniNegras, dniTurno, estadoPartida)"
					+ "values(?,?,?,?)", PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, p.getDniBlancas());
			stmt.setInt(2, p.getDniNegras());
			stmt.setInt(3, p.getDniTurno());
			stmt.setString(4, p.getEstado());
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
		return p.getIdPartida();
	}
	
	/**
	 * Busca una partida por dni de los jugadores.
	 * */
	public Partida buscarPartida(int dniBlancas, int dniNegras) {
		
		ResultSet rs=null;
		PreparedStatement stmt=null;
		Partida partidaActual=null;
		try{
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("select * from Partidas where dniBlanca=? and dniNegra=?");
			stmt.setInt(1, dniBlancas);
			stmt.setInt(2, dniNegras);
			rs=stmt.executeQuery();
			
			if(rs!=null && rs.next()){
				partidaActual= new Partida();
				partidaActual.setDniBlancas(rs.getInt("dniBlancas"));
				partidaActual.setDniNegras(rs.getInt("dniNegras"));
				partidaActual.setDniTurno(rs.getInt("dniTurno"));
				partidaActual.setIdPartida(rs.getInt("idPartida"));
				partidaActual.setEstado(rs.getString("estadoPartida"));
			}
			
			return partidaActual;
		}catch(SQLException e){
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
			FactoryConexion.getInstancia().releaseConn();
		}
		return null;
	}

	public void delete(Partida partidaActual) {
		PreparedStatement stmt= null;
		try{
			stmt= FactoryConexion.getInstancia().getConn().prepareStatement("delete from partida where idPartida=?");
			stmt.setInt(1, partidaActual.getIdPartida());
			stmt.executeQuery();
			
		}catch(SQLException e){
			// TODO Auto-generated catch block
		}
		finally{
			
		}
		
	}
	

	public void modificarTurno(Partida partidaActual){
		if(partidaActual.getDniTurno()== partidaActual.getDniBlancas()){
			partidaActual.setDniTurno(partidaActual.getDniNegras());
		}
		else{
		partidaActual.setDniTurno(partidaActual.getDniBlancas());
		}
	}

}