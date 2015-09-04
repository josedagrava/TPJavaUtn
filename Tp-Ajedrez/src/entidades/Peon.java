package entidades;

public class Peon extends Pieza{

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
