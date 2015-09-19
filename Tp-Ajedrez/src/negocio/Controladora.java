package negocio;

import datos.DatosJugadores;
import datos.DatosPartidas;
import datos.DatosPosicion;
import entidades.*;

import java.util.HashMap;

public class Controladora {
		
	//Metodos de DatosJugadores
	
	/**
	 * retorna el Nombre y Apellido del jugador que tiene el turno que fue buscado en la base de datos.
	 * */
	public String getJugador(int dniTurno) {
		DatosJugadores oDatos = new DatosJugadores();
		return oDatos.getNomyApe(dniTurno);
		
	}
	
	//Metodos de DatosPartida
	
	/**
	 * pide a DatosPartidas que busque la partida que corresponde para los dos jugadores especificados
	 * */
	public Partida buscarPartida(String dniBlancas, String dniNegras) {
		DatosPartidas oDatosPartida = new DatosPartidas();
		Partida partidaActual= oDatosPartida.buscarPartida(Integer.parseInt(dniBlancas), Integer.parseInt(dniNegras));
		if(partidaActual==null){
			return null;
		}
		else return partidaActual;
		
	}
	
	/**
	 * Agrega una partida nueva
	 * */
	public int addPartida(Partida partidaActual) {
		DatosPartidas oDatosPartida = new DatosPartidas();
		int idpartida= oDatosPartida.add(partidaActual);
		
		return idpartida;
	}
	
	//Metodos de DatosPosiciones
	
	/**
	 * Metodo que devuelve las posiciones que estan en la base de datos, para continuar con una partida anterior
	 * */
	public String[][] getDatosPosiciones() {
		
		String[][] posicionString = new String[16][16];
		
		HashMap<Posicion, Pieza> posiciones =null;	
		try{
			int n=0;
			int b=0;
			posiciones= DatosPosicion.getHashMap();
			for(Posicion k: posiciones.keySet()){
				Pieza p=posiciones.get(k);
				if(p.getColor().equals("N")){
					posicionString[n][1]= k.getTipoPieza()+k.getPosicion();
					n++;
				}
				else{
					posicionString[b][0]= k.getTipoPieza()+k.getPosicion();
					b++;
				}
			}
		}catch(Exception e)
		{
			
		}
		return posicionString;
	}
	
	/**
	 * le pide a clase DatosPosiciones que instancia las posiciones guardadas en DB en el hashMap
	 * */
	public void cargarHashMap(int idPartida) {
		DatosPosicion oDatosPosicion= new DatosPosicion();
		oDatosPosicion.getDatosPosiciones(idPartida);
		
	}

}
