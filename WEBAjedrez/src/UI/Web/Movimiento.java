package UI.Web;

import Negocio.*;
import Entidades.*;

import java.awt.List;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

/**
 * Servlet implementation class Movimiento
 */
@WebServlet("/Movimiento")
public class Movimiento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Movimiento() {
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
		Controladora oControl= new Controladora(request);
		
		if(request.getParameter("accion").equals("guardar")){
			oControl.guardar();
			request.getRequestDispatcher("Principal.html");
			//aca deberia mandar por parametro el hashmap ya que esta en la session?
		}else if(request.getParameter("accion").equals("mover")){
			String posOrigen= request.getParameter("origen");
			String posDestino= request.getParameter("destino");			
			Partida partida = (Partida)request.getSession().getAttribute("partida");
			
			boolean v= oControl.validarMovimiento(posOrigen, posDestino,partida);
			
			System.out.println("el boolean es:"+v);
			if(v) { 
					boolean continuaJuego= oControl.generarMovimiento(posOrigen,posDestino, request);
					if (continuaJuego){
						oControl.modificarTurno(partida);
						this.cargarPosicionFichas(request);
						request.getSession().setAttribute("turno", oControl.getJugador(partida.getDniTurno()));
						response.sendRedirect("Movimiento.jsp");
					}
					else{						
						response.setCharacterEncoding("UTF-8");
						response.getWriter().println("<script> alert('GANASTE');</script>");
						request.getRequestDispatcher("Principal.html");
					}					
			}
			else{
				response.setCharacterEncoding("UTF-8");
				response.sendRedirect("Movimiento.jsp");
			}
		}
	}
	
	private void cargarPosicionFichas(HttpServletRequest request){
		ArrayList<String> listaBlanca=new ArrayList<String>();
		ArrayList<String> listaNegras= new ArrayList<String>();
		
		HashMap<Posicion, Pieza> colPosicion = (HashMap<Posicion, Pieza>)request.getSession().getAttribute("colPosiciones");
		for(Posicion b: colPosicion.keySet()){
			if(colPosicion.get(b).getColor().equals("B")){
				listaBlanca.add(b.getPosicion());
			}else if(colPosicion.get(b).getColor().equals("N")){
				listaNegras.add(b.getPosicion());
			}
		}
		request.getSession().setAttribute("listaBlanca", listaBlanca);
		request.getSession().setAttribute("listaNegra", listaNegras);
	}
}
