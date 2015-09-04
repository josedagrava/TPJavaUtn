package entidades;

import java.util.ArrayList;
import java.util.HashMap;


public class Peon extends Pieza{
	
	public Peon(){}
	public Peon(String color){
		this.setColor(color);
	}

	public static void posicionInicial(HashMap<Posicion, Pieza> coleccion){
		
	}
	
	public boolean esmovimientovalido (String posicionorigen, String posiciondestino){
		
		return true;
	}
	
	
}
