package UI.Web;

import java.io.IOException;

import Entidades.*;
import Negocio.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;

import com.mysql.fabric.Response;

/**
 * Servlet implementation class Inicio
 */
//@WebServlet("/Inicio")
@WebServlet("/Principal")
public class Inicio extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Partida partidaActual;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Inicio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dniBlanca= request.getParameter("txtBlancas");
		String dniNegra= request.getParameter("txtNegras");
		
		//this.empezar(dniBlanca,dniNegra)
		response.sendRedirect("Movimiento.jsp");
	}
	
	private void empezar(String dniB, String dniN){
		Controladora oControl= new Controladora();
		partidaActual=oControl.buscarPartida(dniB, dniN);
		if(partidaActual==null){
			this.nuevoJuego(dniB,dniN);
			//this.Guardar();
		}
		else{
			//metodo para buscar valores de BD y cargar el hash. luego llamar a movimiento.jsp
		}
		
	}

	private void nuevoJuego(String dniB, String dniN) {
		partidaActual=new Partida(Integer.parseInt(dniB),Integer.parseInt(dniN),Integer.parseInt(dniB),"Empezado");
		Controladora oControl= new Controladora();
		partidaActual.setIdPartida(oControl.addPartida(partidaActual));
		
	}

}
