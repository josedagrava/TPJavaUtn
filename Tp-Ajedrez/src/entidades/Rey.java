package entidades;

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
		if((diferencia1==1 || diferencia1==-1 || diferencia1==0) && (diferencia2==1 || diferencia2==-1 || diferencia2==0))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}

