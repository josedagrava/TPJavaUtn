package Entidades;

public class Partida {
	
	private int dniBlancas;
	private int dniTurno;
	private int dniNegras;
	private int idPartida;
	private String estado;
	
	public String getEstado(){
		return estado;
	}
	public void setEstado(String est){
		this.estado=est;
	}
	public void setDniBlancas(int dni){
		this.dniBlancas=dni;
	}
	public int getDniBlancas(){
		return dniBlancas;
	}
	public int getDniTurno(){
		return dniTurno;
	}
	public void setDniTurno(int dni){
		this.dniTurno=dni;
	}
	public int getDniNegras() {
		return dniNegras;
	}
	public void setDniNegras(int dniNegras) {
		this.dniNegras = dniNegras;
	}
	public int getIdPartida() {
		return idPartida;
	}
	public void setIdPartida(int idPartida) {
		this.idPartida = idPartida;
	}
	
	public Partida(){}
	
	public Partida(int dniB, int dniN,int dniT,String estado){
		this.setDniBlancas(dniB);
		this.setDniNegras(dniN);
		this.setDniTurno(dniT);
		this.setEstado(estado);
	}
	
}
