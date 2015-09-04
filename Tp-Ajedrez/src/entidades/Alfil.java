package entidades;

public class Alfil extends Pieza {

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
		int diferenciaL=letraFin-letraInicio;
		int diferenciaN=numeroFin-numeroInicio;
		
		if((diferenciaL==diferenciaN) || (diferenciaL==-diferenciaN))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
