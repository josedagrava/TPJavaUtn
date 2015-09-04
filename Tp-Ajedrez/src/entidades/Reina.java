package entidades;

public class Reina extends Pieza{

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
		
		int diferencia1=letraFin-letraInicio;
		int diferencia2=numeroFin-numeroInicio;
		
		if((diferencia1==diferencia2) || (diferencia1==-diferencia2) || (letraFinal==letraInicial) || (numeroFinal==numeroInicial))
		{
			return true;
		}
		else
		{
			return false;
		}
		
		
	}
}
