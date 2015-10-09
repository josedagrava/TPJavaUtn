package entidades;

import java.util.HashMap;

public class Torre extends Pieza {

	public boolean esMovimientoValido(String posInicial, String posFinal)
	{
		boolean respuesta=false, d1=false, d2=false, s=false;
		char letraInicial = posInicial.charAt(0);
		char numeroInicial = posInicial.charAt(1);
		char letraFinal = posFinal.charAt(0);
		char numeroFinal = posFinal.charAt(1);
		
		s=super.EsMovimientoValido(posInicial, posFinal);
		if(letraFinal==letraInicial)
		{
			d1=true;
		}
		if(numeroFinal==numeroInicial)
		{
			d2=true;
		}
		
		if((s) && (d1||d2))
		//if(((letraFinal==letraInicial) || (numeroFinal==numeroInicial)) && (super.EsMovimientoValido(posInicial, posFinal)))
		{
			respuesta= true;
		}
		else
		{
			respuesta= false;
		}
		
		return respuesta; 
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
