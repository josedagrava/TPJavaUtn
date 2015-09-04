package entidades;

public class Caballo extends Pieza{

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
		
		int columna = (numeroFin -numeroInicio)*(numeroFin -numeroInicio);
		int fila = (letraFin-letraInicio)*(letraFin-letraInicio);
		int resultado = columna + fila;
		
		if (resultado==5)
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
}
