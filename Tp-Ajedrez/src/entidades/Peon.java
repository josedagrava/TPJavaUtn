package entidades;

import java.util.HashMap;

public class Peon extends Pieza{

	public Peon(){}
	public Peon(String color){
		this.setColor(color);
	}

	public static void posicionInicial(HashMap<Posicion, Pieza> colPosiciones, int id){
		
		colPosiciones.put(new Posicion(id,"P", "A7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id,"P", "B7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id,"P", "C7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id,"P", "D7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id,"P", "E7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id,"P","F7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id,"P", "G7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id,"P", "H7", true), new Peon("B"));
		colPosiciones.put(new Posicion(id,"P", "A2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id,"P", "B2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id,"P","C2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id,"P","D2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id,"P", "E2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id,"P", "F2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id,"P", "G2", true), new Peon("N"));
		colPosiciones.put(new Posicion(id,"P","H2", true), new Peon("N"));
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
		
		if((((diferenciaL==1) && (diferenciaN==1)) || ((diferenciaL==1) && (diferenciaN==-1)) || ((diferenciaL==1) && (diferenciaN==0))) && (super.EsMovimientoValido(posInicial, posFinal)) && (numeroInicio==2 || numeroInicio==7))  
		{
			return true;
		}
		else
		{
			if(((diferenciaL==-1) && (diferenciaN==1)) || ((diferenciaL==-1) && (diferenciaN==-1)) || ((diferenciaL==-1) && (diferenciaN==0)) && (super.EsMovimientoValido(posInicial, posFinal)) && (numeroInicio==2 || numeroInicio==7))
			{
				return true;
			}
			else
			{
				return false;
		}
		
		
		
	}
	}
}

