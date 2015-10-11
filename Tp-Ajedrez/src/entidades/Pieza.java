package entidades;

public abstract class Pieza {

	private String color;

	public String getColor(){
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Pieza(){}
	public Pieza(String col){
		this.setColor(col);
	}
	
	public boolean esMovimientoValido (String posInicial, String posFinal)
	{
		
		char letraInicial = posInicial.charAt(0);
		char numeroInicial = posInicial.charAt(1);
		char letraFinal = posFinal.charAt(0);
		char numeroFinal = posFinal.charAt(1);
		
		if (((letraInicial=='A') || (letraInicial=='B') || (letraInicial=='C') || (letraInicial=='D') || (letraInicial=='E') || (letraInicial=='F') || (letraInicial=='G') || (letraInicial=='H'))
			&& ((numeroInicial=='1') || (numeroInicial=='2') || (numeroInicial=='3') || (numeroInicial=='4') || (numeroInicial=='5') || (numeroInicial=='6') || (numeroInicial=='7') || (numeroInicial=='8'))
			&& ((letraFinal=='A') || (letraFinal=='B') || (letraFinal=='C') || (letraFinal=='D') || (letraFinal=='R') || (letraFinal=='F') || (letraFinal=='G') || (letraFinal=='H'))
			&& ((numeroFinal=='1') || (numeroFinal=='2') || (numeroFinal=='3') || (numeroFinal=='4') || (numeroFinal=='5') || (numeroFinal=='6') || (numeroFinal=='7') || (numeroFinal=='8'))) 
		
			{	
				return true;
			}
		else
			{
				return false;
			}
			
	}
}	
