package entidades;

public class Torre extends Pieza {

	public boolean esMovimientoValido(String posInicial, String posFinal)
	{
		char letraInicial = posInicial.charAt(0);
		char numeroInicial = posInicial.charAt(1);
		char letraFinal = posFinal.charAt(0);
		char numeroFinal = posFinal.charAt(1);
		
		
		if((letraFinal==letraInicial) || (numeroFinal==numeroInicial))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
