package negocio;

import entidades.Partida;
import java.util.Random;

public class Controladora {

	public Partida buscarPartida(String dniBlancas, String dniNegras) {
		// TODO Auto-generated method stub
		return null;
	}

	public int determinarTurno(String dniBlanca, String dniNegras) {
		Random r= new Random();
		if(r.nextDouble()<0.5){
			return Integer.parseInt(dniBlanca);
		}
		else{
			return Integer.parseInt(dniNegras);
		}
	}

}
