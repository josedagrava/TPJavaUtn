/*
<<<<<<< HEAD

package presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.Component;

import javax.swing.Box;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JList;

import java.awt.List;
import java.awt.Panel;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InterfazJuego extends JFrame {

	private JPanel contentPane;
	private JTextField txtDniBlancas;
	private JTextField txtDniNegras;
	private JTextField txtNomyApeTurno;
	private JTextField txtMovOrigen;
	private JTextField textField;
	// **
	// * Launch the application.
	// *
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

	// **
	 //* Create the frame.
	 //*
	public InterfazJuego() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 540, 471);
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
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				
			}
		});

		
		JSeparator separator = new JSeparator();
		
		JLabel lblTurno = new JLabel("Turno:");
		
		txtNomyApeTurno = new JTextField();
		txtNomyApeTurno.setEditable(false);
		txtNomyApeTurno.setColumns(10);
		
		JList listBlancas = new JList();
		listBlancas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JList list = new JList();
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		
		JLabel lblPosicionBlancas = new JLabel("Posicion blancas");
		
		JLabel lblPosicionNegras = new JLabel("Posicion negras");
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 100, 0));
		
		JLabel lblTablero = new JLabel("");
		lblTablero.getIcon();
		Image tablero = new ImageIcon(this.getClass().getResource("Tablero.png")).getImage();
		lblTablero.setIcon(new ImageIcon(tablero));
		
		JButton btnMover = new JButton("Mover");
		
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
										.addComponent(btnGuardar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
									.addGap(39)
									.addComponent(btnMover))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(listBlancas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(lblPosicionBlancas, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
											.addGap(28)
											.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(lblPosicionNegras)
												.addComponent(list, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(10)
											.addComponent(lblTurno)
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(txtNomyApeTurno, GroupLayout.PREFERRED_SIZE, 175, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
											.addGap(19)
											.addComponent(panel, GroupLayout.PREFERRED_SIZE, 142, GroupLayout.PREFERRED_SIZE)))
									.addGap(6)
									.addComponent(lblTablero, GroupLayout.PREFERRED_SIZE, 267, Short.MAX_VALUE))))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(33)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDNIblancas)
								.addComponent(txtDniBlancas, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnJugar))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblDniNegras)
								.addComponent(txtDniNegras, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnGuardar))
							.addGap(1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnMover)
							.addGap(18)))
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
							.addGap(6)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE, false)
								.addComponent(listBlancas, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 145, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addGap(32))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblTablero, GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE)
							.addContainerGap())))
		);
		
		txtMovOrigen = new JTextField();
		txtMovOrigen.setColumns(10);
		
		JLabel lblMovOrigen = new JLabel("Posicion origen:");
		
		JLabel lblPosicionDestino = new JLabel("Posicion destino:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		
		
		JLabel lblMovimientoDeFichas = new JLabel("Movimiento de Fichas");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblPosicionDestino)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(textField, 0, 0, Short.MAX_VALUE))
						.addComponent(lblMovimientoDeFichas)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMovOrigen, GroupLayout.DEFAULT_SIZE, 83, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(txtMovOrigen, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblMovimientoDeFichas)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(lblMovOrigen, GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
							.addGap(20))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(txtMovOrigen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblPosicionDestino))))
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);}

	
}
	
=======
*/
package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
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
	private JTextField textField;
	private Controladora oControl;
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 535);
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
		
		JSeparator separator = new JSeparator();
		
		JLabel lblTurno = new JLabel("Turno:");
		
		txtNomyApeTurno = new JTextField();
		txtNomyApeTurno.setEditable(false);
		txtNomyApeTurno.setColumns(10);
		
		JLabel lblPosicionBlancas = new JLabel("Posicion blancas");
		
		JLabel lblPosicionNegras = new JLabel("Posicion negras");
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 100, 0));
		
		JPanel panelimage = new JPanel();
		panelimage.setSize(276, 280);		
		
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
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
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
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(tblPosiciones, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
											.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
												.addComponent(lblPosicionBlancas)
												.addGap(29)
												.addComponent(lblPosicionNegras))))
									.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 134, GroupLayout.PREFERRED_SIZE)
										.addComponent(panelimage, GroupLayout.PREFERRED_SIZE, 276, GroupLayout.PREFERRED_SIZE)))))
						.addComponent(separator, GroupLayout.PREFERRED_SIZE, 472, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(18, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
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
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
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
									.addComponent(tblPosiciones, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addGap(121))
								.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(92)
							.addComponent(panelimage, GroupLayout.PREFERRED_SIZE, 187, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		txtMovOrigen = new JTextField();
		txtMovOrigen.setColumns(10);
		
		JLabel lblMovOrigen = new JLabel("Posicion origen:");
		
		JLabel lblPosicionDestino = new JLabel("Posicion destino:");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnMover = new JButton("Mover");
		
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
									.addComponent(textField, 0, 0, Short.MAX_VALUE)))
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
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnMover)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
	
	private void clickBotonJugar() {
		if(partidaActual==null){
			oControl = new Controladora();
			partidaActual= oControl.buscarPartida(txtDniBlancas.getText(), txtDniNegras.getText());
			if(partidaActual==null) {		
				iniciarPartida();
			
			}
			else{
				int partidaExist= JOptionPane.showConfirmDialog(contentPane, "Desea continuar la partida anterior?", "Partida"
						+ " existente", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
				if(partidaExist==JOptionPane.OK_OPTION){
					cargarPosicionFichas();
				}
				else {
					iniciarPartida();
				}
			}
		}
		else
		{
			int op= JOptionPane.showConfirmDialog(contentPane, "Estas saliendo de la partida actual. Desea guardar"
					+ " los avances?", "CUIDADO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if(op==JOptionPane.YES_OPTION){
				//clickBotonGuardar();
			}
		}
	}
	
	private void posicionarFichasInicial(){
		String[][] posiciones= {
				{"Peon-A2", "Peon-A7"},
				{"Peon-B2", "Peon-B7"},
				{"Peon-C2", "Peon-C7"},
				{"Peon-D2", "Peon-D7"},
				{"Peon-E2", "Peon-E7"},
				{"Peon-F2", "Peon-F7"},
				{"Peon-G2", "Peon-G7"},
				{"Peon-H2", "Peon-H7"},
				{"Torre-A1","Torre-A8"},
				{"Torre-H1","Torre-H8"},
				{"Caballo-B1","Caballo-B8"},
				{"Caballo-G1","Caballo-G8"},
				{"Alfil-C1","Alfil-C8"},
				{"Alfil-F1","Alfil-F8"},
				{"Reina-D1","Reina-D8"},
				{"Rey-E1","Rey-E8"},								
		};
		
		setModelo(posiciones);
	}
	
	private void cargarPosicionFichas() {
		
		String[][] posiciones= oControl.getDatosPosiciones(partidaActual.getIdPartida());
		setModelo(posiciones);
		
	}
	private void setModelo(String [][] posiciones){
		
		DefaultTableModel modelo= (DefaultTableModel)tblPosiciones.getModel();		
		modelo.addRow(posiciones);
		tblPosiciones.setModel(modelo);
	}
	
	private void iniciarPartida() {
		partidaActual=new Partida(Integer.parseInt(txtDniBlancas.getText()),Integer.parseInt(txtDniNegras.getText()),Integer.parseInt(txtDniBlancas.getText()),"Empezado");
		partidaActual.setIdPartida(oControl.addPartida(partidaActual));		
		posicionarFichasInicial();
	}
	
}

