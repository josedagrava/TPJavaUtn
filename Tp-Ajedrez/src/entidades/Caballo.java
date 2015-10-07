package entidades;

import java.util.HashMap;

public class Caballo extends Pieza{

	public boolean esMovimientoValido(String posInicial, String posFinal)
	{
		char letraInicial = posInicial.charAt(0);
		char numeroInicial = posInicial.charAt(1);
		char letraFinal = posFinal.charAt(0);
		char numeroFinal = posFinal.charAt(1);
		
		int letraInicio = (int) letraInicial;
		int numeroInicio = (int) numeroInicial;
		int letraFin = (int) letraFinal;
		int numeroFin = (int) numeroFinal;
		
		int columna = (numeroFin -numeroInicio)*(numeroFin -numeroInicio);
		int fila = (letraFin-letraInicio)*(letraFin-letraInicio);
		int resultado = columna + fila;
		
		if ((resultado==5) &&(super.EsMovimientoValido(posInicial, posFinal)))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}

	public Caballo(){}
	public Caballo(String col){
		this.setColor(col);
	}
	
	public static void posicionInicial(HashMap<Posicion, Pieza> colPosiciones, int id) {
			
		colPosiciones.put(new Posicion(id,"Caballo", "B8", true), new Caballo("B"));
		colPosiciones.put(new Posicion(id,"Caballo", "G8", true), new Caballo("B"));
		colPosiciones.put(new Posicion(id,"Caballo", "B1", true), new Caballo("N"));
		colPosiciones.put(new Posicion(id,"Caballo","G1", true), new Caballo("N"));
	}
}
