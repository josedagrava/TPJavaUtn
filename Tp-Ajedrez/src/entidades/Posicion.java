package entidades;

public class Posicion {
	
	private int idPartida;
	private String tipoPieza;
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
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return (obj instanceof Posicion) && this.posicion.equalsIgnoreCase(((Posicion)obj).posicion);
		
		//return super.equals(obj);
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}
	
	public Posicion(){}
	public Posicion(int id, String tipo, String posi,boolean esta){
		
		this.setIdPartida(id);
		this.setEstaEnTablero(esta);
		this.setPosicion(posi);
	
		this.setTipoPieza(tipo);
	}
}
