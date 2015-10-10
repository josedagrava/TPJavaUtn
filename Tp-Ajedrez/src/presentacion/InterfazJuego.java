package presentacion;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import entidades.*;
import negocio.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazJuego extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDniBlancas;
	private JTextField txtDniNegras;
	private JTextField txtNomyApeTurno;
	private JTextField txtMovOrigen;
	private JTextField txtMovDestino;
	private Controladora oControl = new Controladora();
	private Partida partidaActual=null;
	private JTable tblPosiciones;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InterfazJuego frame = new InterfazJuego();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InterfazJuego() {
		setTitle("\"EL\" Ajedrez");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 585, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(169, 169, 169));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDNIblancas = new JLabel("DNI jugador blancas:");
		
		JLabel lblDniNegras = new JLabel("DNI Jugador negras:");
		
		txtDniBlancas = new JTextField();
		txtDniBlancas.setColumns(10);
		
		txtDniNegras = new JTextField();
		txtDniNegras.setColumns(10);
		
		JButton btnJugar = new JButton("Jugar");
		btnJugar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clickBotonJugar();
			}
		});
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Guardar();
			}
		});
		
		JSeparator separator = new JSeparator();
		
		JLabel lblTurno = new JLabel("Turno:");
		
		txtNomyApeTurno = new JTextField("Empiezan las blancas");
		txtNomyApeTurno.setEditable(false);
		txtNomyApeTurno.setColumns(10);
		
		JLabel lblPosicionBlancas = new JLabel("Posicion blancas");
		
		JLabel lblPosicionNegras = new JLabel("Posicion negras");
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 100, 0));
		
		tblPosiciones = new JTable();
		tblPosiciones.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"DNI Blancas", "DNI Negras"
			}
		) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {
				false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		
		JLabel lblTablero = new JLabel("");
		lblTablero.getIcon();
		Image tablero = new ImageIcon(this.getClass().getResource("Tablero.png")).getImage();
		lblTablero.setIcon(new ImageIcon(tablero));
				
		/*JPanel panelimage = new JPanel();
		panelimage.setSize(276, 280);	
		Image img = new ImageIcon("Tablero.png").getImage();
		panelimage.*/
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblDNIblancas)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtDniBlancas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addComponent(lblDniNegras)
											.addPreferredGap(ComponentPlacement.UNRELATED)
											.addComponent(txtDniNegras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
									.addGap(26)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(btnJugar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(10)
											.addComponent(lblTurno)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtNomyApeTurno, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(tblPosiciones, GroupLayout.DEFAULT_SIZE, 180, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createSequentialGroup()
													.addComponent(lblPosicionBlancas)
													.addGap(29)
													.addComponent(lblPosicionNegras))
												.addGroup(gl_contentPane.createSequentialGroup()
													.addGap(11)
													.addComponent(panel, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
													.addPreferredGap(ComponentPlacement.RELATED)))
											.addGap(41)))
									.addGap(10)
									.addComponent(lblTablero, GroupLayout.PREFERRED_SIZE, 262, GroupLayout.PREFERRED_SIZE))))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE))
					.addGap(32))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDNIblancas)
						.addComponent(txtDniBlancas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnJugar))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDniNegras)
						.addComponent(txtDniNegras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnGuardar))
					.addGap(1)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 7, GroupLayout.PREFERRED_SIZE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
									.addComponent(lblTurno)
									.addComponent(txtNomyApeTurno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(42)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPosicionBlancas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(lblPosicionNegras))))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(tblPosiciones, GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
							.addGap(18)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addGap(64))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblTablero, GroupLayout.PREFERRED_SIZE, 293, GroupLayout.PREFERRED_SIZE)
							.addContainerGap())))
		);
		
		txtMovOrigen = new JTextField();
		txtMovOrigen.setColumns(10);
		
		JLabel lblMovOrigen = new JLabel("Posicion origen:");
		
		JLabel lblPosicionDestino = new JLabel("Posicion destino:");
		
		txtMovDestino = new JTextField();
		txtMovDestino.setColumns(10);
		
		JButton btnMover = new JButton("Mover");
		btnMover.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				clickBotonMover();
			}
		});
		
		JLabel lblMovimientoDeFichas = new JLabel("Movimiento de Fichas");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnMover, Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblPosicionDestino)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(txtMovDestino, 0, 0, Short.MAX_VALUE)))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(lblMovOrigen, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtMovOrigen, GroupLayout.PREFERRED_SIZE, 33, GroupLayout.PREFERRED_SIZE)
							.addGap(12))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMovimientoDeFichas)
							.addContainerGap(22, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMovimientoDeFichas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtMovOrigen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMovOrigen, GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblPosicionDestino)
						.addComponent(txtMovDestino, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMover)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	/**
	 * Metodo click del boton Jugar
	 * */
	private void clickBotonJugar() {
		
		if(partidaActual==null){
			
			partidaActual= oControl.buscarPartida(txtDniBlancas.getText(), txtDniNegras.getText());
			if(partidaActual==null) {		
				this.iniciarPartida();
				this.determinarTurno();
				this.Guardar();
			}
			else{
				int opcion= JOptionPane.showConfirmDialog(contentPane, "Desea continuar la partida anterior?", "Partida"
						+ " existente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(opcion==JOptionPane.OK_OPTION){
					oControl.cargarHashMap(partidaActual.getIdPartida());
					this.determinarTurno();
					this.cargarPosicionFichas();
					
				}
				else {
						opcion= (JOptionPane.showConfirmDialog(contentPane, "Eliminar la partida anterior y empezar una nueva?", "Eliminar partida "
							+ "anterior", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE));
					
						if(opcion==JOptionPane.YES_OPTION){
						oControl.deletePartida(partidaActual);
						this.iniciarPartida();
						this.determinarTurno();
						}
						else{
							System.exit(0);
						}
				}
			}
		}
		else
		{
			int op= JOptionPane.showConfirmDialog(contentPane, "Estas saliendo de la partida actual. Desea guardar"
					+ " los avances?", "CUIDADO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(op==JOptionPane.YES_OPTION){
				
				this.Guardar();
			}
		}
	}
	
	/**
	 * pide a clase controladora el nombre y apellido del jugador que tiene turno y lo setea al textBox
	 * */
	private void determinarTurno() {
		
		txtNomyApeTurno.setText(oControl.getJugador(partidaActual.getDniTurno()));
		
	}
	
	
	/**
	 * pide a control las posiciones
	 * */
	private void cargarPosicionFichas() {
		
		String[][] posiciones= oControl.getDatosPosiciones();
		this.setModelo(posiciones);
		
	}
	/**
	 * Setea el modelo en la jTable
	 * */
	private void setModelo(String[][] posiciones){
		
		DefaultTableModel modelo =(DefaultTableModel)tblPosiciones.getModel();
		int tam=modelo.getRowCount();
		for (int i = 0; i < tam ; i++) {
			modelo.removeRow(0);
		}
		
		for(int i=0; i<16 ;i++){
			
			modelo.addRow(posiciones[i]);
		}
		tblPosiciones.setModel(modelo);
		
	}
	
	/**
	 * instancia la partida actual y llama a metodo cargaPosicionesfichas
	 * */
	private void iniciarPartida() {
		
		partidaActual=new Partida(Integer.parseInt(txtDniBlancas.getText()),Integer.parseInt(txtDniNegras.getText()),Integer.parseInt(txtDniBlancas.getText()),"Empezado");
		partidaActual.setIdPartida(oControl.addPartida(partidaActual));
		this.cargarPosicionFichas();
	}
	
	private void Guardar()
	{
		oControl.guardar();
	}
	

	private void clickBotonMover(){
		boolean movValido= oControl.validarMovimiento(txtMovOrigen.getText(), txtMovDestino.getText(),partidaActual);
		
			if (movValido){
					boolean continuaJuego= oControl.generarMovimiento(txtMovOrigen.getText(),txtMovDestino.getText());
				
					if(continuaJuego){
					
						oControl.modificarTurno(partidaActual);
						txtNomyApeTurno.setText(oControl.getJugador(partidaActual.getDniTurno()));
						this.cargarPosicionFichas();
					}
					
					else{
						JOptionPane.showMessageDialog(null, oControl.getJugador(partidaActual.getDniTurno()) + "Ganaste!!");
						}
			}
			else {
				JOptionPane.showMessageDialog(null,"Movimiento invalido" ,"Mensaje de advertencia",JOptionPane.WARNING_MESSAGE);
				
			}
	}
	
}
