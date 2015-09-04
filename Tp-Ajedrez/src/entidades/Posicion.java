package entidades;

public class Posicion {
	
	private int idPartida;
	private String tipoPieza;
	private String color;
	private String posicion;
	private boolean estaEnTablero;
	
	public int getIdPartida(){
		return idPartida;
	}
	public void setIdPartida(int id){
		this.idPartida = id;
	}
	public String getTipoPieza() {
		return tipoPieza;
	}
	public void setTipoPieza(String tipoPieza) {
		this.tipoPieza = tipoPieza;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public boolean isEstaEnTablero() {
		return estaEnTablero;
	}
	public void setEstaEnTablero(boolean estaEnTablero) {
		this.estaEnTablero = estaEnTablero;
	} 

}
