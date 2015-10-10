package negocio;

import datos.DatosJugadores;
import datos.DatosPartidas;
import datos.DatosPosicion;
import entidades.*;

import java.util.HashMap;

public class Controladora {
		
	//Metodos a DatosJugadores
	DatosJugadores oDatos = new DatosJugadores();
	DatosPosicion oDatosPosicion= new DatosPosicion();
	DatosPartidas oDatosPartida = new DatosPartidas();
	/**
	 * retorna el Nombre y Apellido del jugador que tiene el turno que fue buscado en la base de datos.
	 * */
	public String getJugador(int dniTurno) {
		
		return oDatos.getNomyApe(dniTurno);
		
	}
	
	//Metodos a DatosPartida
	
	/**
	 * pide a DatosPartidas que busque la partida que corresponde para los dos jugadores especificados
	 * */
	public Partida buscarPartida(String dniBlancas, String dniNegras) {
		Partida partidaActual=null;
		try{
			partidaActual= oDatosPartida.buscarPartida(Integer.parseInt(dniBlancas), Integer.parseInt(dniNegras));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return partidaActual;
	}
	
	/**
	 * Elimina una partida ya creada.
	 * */
	public void deletePartida(Partida partidaActual) {		
		
		oDatosPartida.delete(partidaActual);
		
	}
	
	
	/**
	 * Agrega una partida nueva
	 * */
	public int addPartida(Partida partidaActual) {
		
		int idpartida= oDatosPartida.add(partidaActual);
		
		return idpartida;
	}
	
	//Metodos a DatosPosiciones
	
	/**
	 * Metodo que devuelve las posiciones que estan en la base de datos, para continuar con una partida anterior
	 * */
	public String[][] getDatosPosiciones() {
		
		String[][] posicionString = new String[16][2];
		
		HashMap<Posicion, Pieza> posiciones =null;	
		try{
			int n=0;
			int b=0;
			posiciones= DatosPosicion.getHashMap();
			for(Posicion k: posiciones.keySet()){
				Pieza p=posiciones.get(k);
				if(p.getColor().equals("N") && n<16){
					posicionString[n][1]= k.getTipoPieza()+" - "+k.getPosicion();
					n++;
				}
				else if(p.getColor().equals("B") && b<16){
					posicionString[b][0]= k.getTipoPieza()+" - "+k.getPosicion();
					b++;
				}
			}
		}catch(Exception e)
		{
			e.printStackTrace();
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

	public boolean validarMovimiento(String origen,String destino,Partida partidaActual){
		boolean v;
		Pieza piezaInicio=null;
		Pieza piezaDestino=null;
		Posicion posInicio=null;
		v=true;
		
		if (origen!= destino){
			
			piezaInicio= oDatosPosicion.devolverPieza(origen);
			posInicio= oDatosPosicion.devolverPosicion(origen);
			Pieza oPieza=null;
			
			switch(posInicio.getTipoPieza()){
			

			case "P": oPieza= new Peon();
				break;
			case "C": oPieza= new Caballo();
				break;
			case "A": oPieza= new Alfil();
				break;
			case "T": oPieza= new Torre();
				break;
			case "D": oPieza= new Reina();
				break;
			case "R":	oPieza= new Rey();
				break;
			
			}
			v= oPieza.esMovimientoValido(origen,destino);
			
				if (v== true){
					
					String color;
					if(partidaActual.getDniBlancas()== partidaActual.getDniTurno()){
						color="B";}
					else{
						color="N";
					}
				   
					if (piezaInicio.getColor()== color){
				    	  v=true;
				    	  
				    	  if(v==true){
				    		 
				    		  piezaDestino=oDatosPosicion.devolverPieza(destino);
				    		  
				    		  if (piezaDestino!=null && piezaDestino.getColor()==color){
				    			  
				    			  v=false;
				    		  }
				    	  }
				    }
					else v=false;
				
				}
			 
		}
		else{
			v= false;
			
		}
		
		return v;
	
}
	
	public boolean generarMovimiento(String origen, String destino){
		
		Posicion posInicio;
		
		posInicio= oDatosPosicion.devolverPosicion(origen);
		
		boolean v=oDatosPosicion.guardarMovimiento(posInicio, destino);
		
		return v;
	}
	
	public void modificarTurno(Partida partidaActual){
		oDatosPartida.modificarTurno(partidaActual);
		
	}
	
	
	/* metodo para guardar las posiciones del tablero en el hash map*/
	
	public void guardar() {
	 
		DatosPosicion oDatosPosicion = new DatosPosicion();
		oDatosPosicion.guardar();
	}

}
