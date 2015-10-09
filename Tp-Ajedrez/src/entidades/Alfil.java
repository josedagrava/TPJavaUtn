package entidades;

import java.util.HashMap;

public class Alfil extends Pieza {

	public boolean esMovimientoValido(String posInicial, String posFinal)
	{
		boolean s=false,d1=false,d2=false, respuesta=false;
		char letraInicial = posInicial.charAt(0);
		char numeroInicial = posInicial.charAt(1);
		char letraFinal = posFinal.charAt(0);
		char numeroFinal = posFinal.charAt(1);
		
		int letraInicio = (int) letraInicial;
		int numeroInicio = (int) numeroInicial;
		int letraFin = (int) letraFinal;
		int numeroFin = (int) numeroFinal;
		int diferenciaL=letraFin-letraInicio;
		int diferenciaN=numeroFin-numeroInicio;
		
		s=super.EsMovimientoValido(posInicial, posFinal);
		if(diferenciaL==diferenciaN)
		{
			d1=true;
		}
		
		if(diferenciaL==-diferenciaN)
		{
			d2=true;
		}
		
		if((s) && ((d1) || (d2)))
		{
			respuesta=true;
		}
		else
		{
			respuesta=false;
		}
		return respuesta;
	}

	public Alfil(){}
	public Alfil(String col){
		this.setColor(col);
	}
	public static void posicionInicial(HashMap<Posicion, Pieza> colPosiciones, int id) {
		
		colPosiciones.put(new Posicion(id,"A" ,"C8", true), new Alfil("B"));
		colPosiciones.put(new Posicion(id,"A" ,"F8", true), new Alfil("B"));
		colPosiciones.put(new Posicion(id,"A" ,"C1", true), new Alfil("N"));
		colPosiciones.put(new Posicion(id,"A" ,"F1", true), new Alfil("N"));
	}
}
