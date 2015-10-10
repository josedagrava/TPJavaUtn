package entidades;

import java.util.HashMap;

public class Rey extends Pieza {

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
		
		int diferencia1= letraInicio-letraFin;
		int diferencia2= numeroInicio-numeroFin;
		if(((diferencia1==1 || diferencia1==-1 || diferencia1==0) && (diferencia2==1 || diferencia2==-1 || diferencia2==0)) && (super.esMovimientoValido(posInicial, posFinal)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public Rey(){}
	public Rey(String col){
		this.setColor(col);
	}
	
	public static void posicionInicial(HashMap<Posicion, Pieza> colPosiciones, int id) {
		
		colPosiciones.put(new Posicion(id,"R","E8", true), new Rey("B"));
		colPosiciones.put(new Posicion(id,"R","E1",true), new Rey("N"));
		
	}
}
