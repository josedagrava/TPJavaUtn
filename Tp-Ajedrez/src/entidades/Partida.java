package entidades;

public class Partida {
	
	private int dniBlancas;
	private String dniTurno;
	private int dniNegras;
	private int idPartida;
	
	public void setDniBlancas(int dni){
		this.dniBlancas=dni;
	}
	public int getDniBlancas(){
		return dniBlancas;
	}
	public String getDniTurno(){
		return dniTurno;
	}
	public void setDniTurno(String dni){
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

}
