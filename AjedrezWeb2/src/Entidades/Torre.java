package Entidades;

import java.util.HashMap;

public class Torre extends Pieza {

	public boolean esMovimientoValido(String posInicial, String posFinal)
	{
		char letraInicial = posInicial.charAt(0);
		char numeroInicial = posInicial.charAt(1);
		char letraFinal = posFinal.charAt(0);
		char numeroFinal = posFinal.charAt(1);
		
		
		if(((letraFinal==letraInicial) || (numeroFinal==numeroInicial)) && (super.esMovimientoValido(posInicial, posFinal)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Torre(){}
	public Torre(String col){
		this.setColor(col);
	}

	public static void posicionInicial(HashMap<Posicion, Pieza> colPosiciones, int id) {
		colPosiciones.put(new Posicion(id,"T", "A8", true), new Torre("B"));
		colPosiciones.put(new Posicion(id,"T", "H8", true), new Torre("B"));
		colPosiciones.put(new Posicion(id,"T","A1", true), new Torre("N"));
		colPosiciones.put(new Posicion(id,"T", "H1", true), new Torre("N"));
	}
}
