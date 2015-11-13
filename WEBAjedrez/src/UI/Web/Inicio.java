package UI.Web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import Entidades.*;
import Negocio.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;

import com.mysql.fabric.Response;

/**
 * Servlet implementation class Inicio
 */
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
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dniBlanca= request.getParameter("dniBlancas");
		String dniNegra= request.getParameter("dniNegras");
		
		Controladora oControl= new Controladora(request);
		partidaActual=oControl.buscarPartida(dniBlanca, dniNegra);
		HashMap<Posicion, Pieza> colPosiciones= new HashMap<Posicion, Pieza>();
		
		HttpSession session = request.getSession(true);
		if(partidaActual==null){
			this.nuevoJuego(dniBlanca,dniNegra);
			colPosiciones= oControl.getHashMap();
			//oControl.guardar();
		}
		else{
			colPosiciones = oControl.cargarHashMap(partidaActual.getIdPartida());
		}
		session.setAttribute("turno", oControl.getJugador(partidaActual.getDniTurno()));
		session.setAttribute("partida", partidaActual);
		session.setAttribute("colPosiciones", colPosiciones);
		
		ArrayList<String> listaBlanca=new ArrayList<String>();
		ArrayList<String> listaNegras= new ArrayList<String>();
		for(Posicion b: colPosiciones.keySet()){
			if(colPosiciones.get(b).getColor().equals("B")){
				listaBlanca.add(b.getPosicion());
			}else if(colPosiciones.get(b).getColor().equals("N")){
				listaNegras.add(b.getPosicion());
			}
		}
		request.getSession().setAttribute("listaBlanca", listaBlanca);
		request.getSession().setAttribute("listaNegra", listaNegras);
		request.getRequestDispatcher("Movimiento.jsp").forward(request, response);
	}
	
	/**
	 * instancia una partida nueva
	 * */
	private void nuevoJuego(String dniB, String dniN) {
		partidaActual=new Partida(Integer.parseInt(dniB),Integer.parseInt(dniN),Integer.parseInt(dniB),"Empezado");
		Controladora oControl= new Controladora();
		partidaActual.setIdPartida(oControl.addPartida(partidaActual));
		
	}

}
