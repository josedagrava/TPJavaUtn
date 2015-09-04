package entidades;

public abstract class Pieza {
	
	private String color;

	public String getColor(){
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public boolean esmovimientovalido (String posiciondestino){
		
		return true;
	}
}
