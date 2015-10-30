package Entidades;

import java.util.HashMap;
import java.util.Map.Entry;

import Datos.DatosPosicion;

public class Peon extends Pieza{
	HashMap<Posicion, Pieza> hash;
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
		
		hash= DatosPosicion.getHashMap();
		
		boolean s=false, respuesta=false, d1=false, d2=false,d3=false,d4=false,d5=false, d6=false,d7=false;
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
		
		s=super.esMovimientoValido(posInicial, posFinal);
		
		
		bucle1: for(Entry<Posicion, Pieza> entry: hash.entrySet())
			{		
				
						if(entry.getKey().getPosicion().equals(posFinal))
						{
								if((diferenciaL==1) && (diferenciaN==1))
									{
										d1=true;
										break bucle1;
									}
				
								if((diferenciaL==-1) && (diferenciaN==1))
									{
										d2=true;
										break bucle1;
									}
				
								if((diferenciaL==-1) && (diferenciaN==-1))
									{
										d5=true;
										break bucle1;
									}
				
								if((diferenciaL==1) && (diferenciaN==-1))
									{
										d6=true;
										break bucle1;
									}
				
					}
			}
		
		
		if((diferenciaL==0) && (diferenciaN==1))
		{
			d3=true;
		}
		if(numeroInicio==55)
		{
			if((diferenciaN==-2) && (diferenciaL==0))
			d4=true;
		}
		if (numeroInicio==50)
			{
				if((diferenciaN==2) && (diferenciaL==0))
					d4=true;
			}
		
		
		if((diferenciaN==-1) && (diferenciaL==0))
		{
			d7=true;
		}				
		
		if((s) && ((d1||d2) || (d3) || (d4)))
		{
			respuesta=true;
		}
		else if((s) && ((d5||d6) || (d7) || (d4)))
				{
			respuesta= true;
				}
		
		return respuesta;
	}
}