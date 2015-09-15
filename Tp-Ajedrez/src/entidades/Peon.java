package entidades;

import java.util.HashMap;

public class Peon extends Pieza{

	public Peon(){}
	public Peon(String color){
		this.setColor(color);
	}

	public static void posicionInicial(HashMap<Posicion, Pieza> colPosiciones, int id){
		
		colPosiciones.put(new Posicion(id, "A7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id, "B7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id, "C7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id, "D7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id, "E7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id, "F7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id, "G7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id, "H7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id, "A2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id, "B2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id, "C2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id, "D2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id, "E2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id, "F2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id, "G2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id, "H2", true), new Peon("N"));
		
	}

	public boolean esMovimientoValido(String posInicial, String posFinal)
	{
		//FALTA TERMINAR MOVIMIENTO INICIAL DOBLE 
		
		char letraInicial = posInicial.charAt(0);	
		char numeroInicial = posInicial.charAt(1);
		char letraFinal = posFinal.charAt(0);
		char numeroFinal = posFinal.charAt(1);
		
		int letraInicio = (int) letraInicial;
		int numeroInicio = (int) numeroInicial;
		int letraFin = (int) letraFinal;
		int numeroFin = (int) numeroFinal;
		
		int diferenciaL= letraFin-letraInicio;
		int diferenciaN=numeroFin-numeroInicio;
		
		if(((diferenciaL==1) && (diferenciaN==1)) || ((diferenciaL==1) && (diferenciaN==-1)) || ((diferenciaL==1) && (diferenciaN==0))) /* & son piezas blancas*/  
		{
			return true;
		}
		else
		{
			/*if(((diferenciaL==-1) && (diferenciaN==1)) || ((diferenciaL==-1) && (diferenciaN==-1)) || ((diferenciaL==-1) && (diferenciaN==0)) && son piezas negras
			{
				return true;
			}
			else
			{
			*/
				return false;
		}
		
		
		
	}
}
