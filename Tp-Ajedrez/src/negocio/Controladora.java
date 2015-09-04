package negocio;

import datos.DatosPartidas;
import datos.DatosPosicion;
import entidades.Partida;
import entidades.Peon;
import entidades.Pieza;
import entidades.Posicion;

import java.util.HashMap;

public class Controladora {
		
	//Metodos de DatosJugadores
	
	
	
	//Metodos de DatosPartida

	public Partida buscarPartida(String dniBlancas, String dniNegras) {
		DatosPartidas oDatosPartida = new DatosPartidas();
		Partida partidaActual= oDatosPartida.buscarPartida(Integer.parseInt(dniBlancas), Integer.parseInt(dniNegras));
		if(partidaActual==null){
			return null;
		}
		else return partidaActual;
		
	}
	
	/**
	 * agrega una partida nueva
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
	public String[][] getDatosPosiciones(int id) {
		//falta hacer
		DatosPosicion oDatosPosicion = new DatosPosicion();
		String[][] posicionString = new String[16][16];
		int n=0;
		int b=0;
		
		HashMap<Posicion, Pieza> posiciones =null;	
		try{
			posiciones= DatosPosicion.getHashMap();
			for (Pieza p : posiciones.values()) {
				if(p.getColor().equals("N")){				
					//posicionString[n][1]= p.getTipoPieza()+p.getPosicion();
					n++;
				}
				else{
					//posicionString[b][0]= p.getTipoPieza()+p.getPosicion();
					b++;
					}			
				}
		return posicionString;
		}catch(Exception e)
		{
			
		}
		return posicionString;
	}

}
