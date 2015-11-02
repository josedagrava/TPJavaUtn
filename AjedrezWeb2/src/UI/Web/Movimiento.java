package UI.Web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Negocio.Controladora;
import Entidades.*;

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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String posOrigen= request.getParameter("origen");
		String posDestino= request.getParameter("destino");
		Partida partida;
		partida =(Partida)session.getAttribute("partida");
		
		 
		Controladora oControl= new Controladora();
		boolean v= oControl.validarMovimiento(posOrigen, posDestino,partida);
		
		if (v) { 
				boolean continuaJuego= oControl.generarMovimiento(posOrigen,posDestino);
				
				if (continuaJuego){
				oControl.modificarTurno(partida);
				
				
				//this.cargarPosicionFichas(); cargar posiciones para mostrar
				}
				
				else{
					// mensaje ganaste
				}
				
		}
		else{
			 // mensaje invalido
		}
		request.setAttribute("turno","Aye");
		request.getRequestDispatcher("Movimiento.jsp").forward(request, response);
	}
	
	
	

	}


