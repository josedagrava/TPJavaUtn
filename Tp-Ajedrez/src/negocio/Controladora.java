package negocio;

import datos.DatosJugadores;
import datos.DatosPartidas;
import datos.DatosPosicion;
import entidades.*;

import java.util.HashMap;

public class Controladora {
		
	//Metodos de DatosJugadores
	DatosJugadores oDatos = new DatosJugadores();
	DatosPosicion oDatosPosicion= new DatosPosicion();
	DatosPartidas oDatosPartida = new DatosPartidas();
	/**
	 * retorna el Nombre y Apellido del jugador que tiene el turno que fue buscado en la base de datos.
	 * */
	public String getJugador(int dniTurno) {
		
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

	public void deletePartida(Partida partidaActual) {		
		DatosPartidas oDatosPartida = new DatosPartidas();
		oDatosPartida.delete(partidaActual);
		
	}
	
	

	public Boolean validarMovimiento(String origen,String destino,Partida partidaActual){
		Boolean v;
		Pieza piezaInicio;
		Pieza piezaDestino;
		Posicion posInicio;
		v=Boolean.TRUE;
		
		
		if (origen!= destino){
			
			piezaInicio= oDatosPosicion.devolverPieza(origen);
			posInicio= oDatosPosicion.devolverPosicion(origen);
			Pieza oPieza=null;
			
			switch(posInicio.getTipoPieza()){
			

			case "Peon": oPieza= new Peon();
			case "Caballo": oPieza= new Caballo();
			case "Alfil": oPieza= new Alfil();
			case "Torre": oPieza= new Torre();
			case "Reina":oPieza= new Reina();
			case "Rey":	oPieza= new Rey();
			
			}
			
			v= oPieza.EsMovimientoValido(origen,destino);
			
				if (v== Boolean.TRUE){
					
					String color;
					if(partidaActual.getDniBlancas()== partidaActual.getDniTurno()){
						color="B";}
					else{
						color="N";
					}
				   
					if (piezaInicio.getColor()!= color){
				    	  v=Boolean.FALSE;
				    	  
				    	  if(v==Boolean.TRUE){
				    		 
				    		  piezaDestino=oDatosPosicion.devolverPieza(destino);
				    		  
				    		  if (piezaDestino.getColor()==color){
				    			  
				    			  v=Boolean.FALSE;
				    		  }
				    	  }
				    }
				
				}
			 
		}
		else{
			v= Boolean.FALSE;
			
		}
		
		return v;
		
		
		
		
	
}
	
	public Boolean generarMovimiento(String origen, String destino){
		
		Posicion posInicio;
		
		posInicio= oDatosPosicion.devolverPosicion(origen);
		
		Boolean v=oDatosPosicion.guardarMovimiento(posInicio, destino);
		
		return v;
	}
	
	public void modificarTurno(Partida partidaActual){
		oDatosPartida.modificarTurno(partidaActual);
		
	}
	
	public String [][] devolverPosiciones(){
		
		String [][] posiciones;
		
		posiciones= oDatosPosicion.devolverPosiciones();
		return posiciones;
	}

	/* metodo para guardar las posiciones del tablero en el hash map*/
	
	public void guardar() {
	 
		DatosPosicion oDatosPosicion = new DatosPosicion();
		oDatosPosicion.guardar();
	}

}
