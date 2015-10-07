package negocio;

import datos.DatosPartidas;
import datos.DatosPosicion;
import entidades.*;
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

	/* metodo para guardar las posiciones del tablero en el hash map*/
	
	public void guardar() {
	 
		DatosPosicion oDatosPosicion = new DatosPosicion();
		oDatosPosicion.guardar();
	}

}
