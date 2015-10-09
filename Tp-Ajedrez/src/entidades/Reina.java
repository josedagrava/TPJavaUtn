package entidades;

import java.util.HashMap;

public class Reina extends Pieza{
	
	public Reina(){}
	public Reina(String col){
		this.setColor(col);
	}

	public boolean esMovimientoValido(String posInicial, String posFinal)
	{
		boolean respuesta=false;
		char letraInicial = posInicial.charAt(0);
		char numeroInicial = posInicial.charAt(1);
		char letraFinal = posFinal.charAt(0);
		char numeroFinal = posFinal.charAt(1);
		
		int letraInicio = (int) letraInicial;
		int numeroInicio = (int) numeroInicial;
		int letraFin = (int) letraFinal;
		int numeroFin = (int) numeroFinal;
		
		int diferencia1=letraFin-letraInicio;
		int diferencia2=numeroFin-numeroInicio;
		
		if(((diferencia1==diferencia2) || (diferencia1==-diferencia2) || (letraFinal==letraInicial) || (numeroFinal==numeroInicial)) && (super.EsMovimientoValido(posInicial, posFinal)))
		{
			respuesta= true;
		}
		else
		{
			respuesta= false;
		}
		
		return respuesta;
		
		
	}

	public static void posicionInicial(HashMap<Posicion, Pieza> colPosiciones, int id) {
		
		colPosiciones.put(new Posicion(id,"D","D8",true), new Reina("B"));
		colPosiciones.put(new Posicion(id,"D","D1",true), new Reina("N"));
		
	}
}
