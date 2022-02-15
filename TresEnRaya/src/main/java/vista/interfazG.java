package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.anm.TresEnRaya.Tablero;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class interfazG extends JFrame {

	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private Tablero tablero;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					interfazG frame = new interfazG();
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
	public interfazG() {
		setTitle("TRES EN RAYA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 405);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelButtons.setBounds(10, 11, 340, 345);
		contentPane.add(panelButtons);
		panelButtons.setLayout(null);
		
		JButton btn00 = new JButton("");
		btn00.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tablero.jugarCasilla('X', 0, 0);
			}
		});
		btn00.setBounds(10, 11, 100, 100);
		panelButtons.add(btn00);
		
		JButton btn01 = new JButton("");
		btn01.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				tablero.jugarCasilla('X', 1, 0);
			}
		});
		btn01.setBounds(120, 11, 100, 100);
		panelButtons.add(btn01);
		
		JButton btn02 = new JButton("");
		btn02.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				tablero.jugarCasilla('X', 2, 0);
			}
		});
		btn02.setBounds(230, 11, 100, 100);
		panelButtons.add(btn02);
		
		JButton btn10 = new JButton("");
		btn10.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				tablero.jugarCasilla('X', 0, 1);
			}
		});
		btn10.setBounds(10, 122, 100, 100);
		panelButtons.add(btn10);
		
		JButton btn11 = new JButton("");
		btn11.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				tablero.jugarCasilla('X', 1, 1);
			}
		});
		btn11.setBounds(120, 122, 100, 100);
		panelButtons.add(btn11);
		
		JButton btn12 = new JButton("");
		btn12.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				tablero.jugarCasilla('X', 2, 1);
			}
		});
		btn12.setBounds(230, 122, 100, 100);
		panelButtons.add(btn12);
		
		JButton btn20 = new JButton("");
		btn20.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				tablero.jugarCasilla('X', 0, 2);
			}
		});
		btn20.setBounds(10, 233, 100, 100);
		panelButtons.add(btn20);
		
		JButton btn21 = new JButton("");
		btn21.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				tablero.jugarCasilla('X', 1, 2);
			}
		});
		btn21.setBounds(120, 233, 100, 100);
		panelButtons.add(btn21);
		
		JButton btn22 = new JButton("");
		btn22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tablero.jugarCasilla('X', 2, 2);
			}
		});
		btn22.setBounds(230, 233, 100, 100);
		panelButtons.add(btn22);
		
		JButton btnNewGame = new JButton("Nueva Partida");
		btnNewGame.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewGame.setBounds(425, 11, 133, 23);
		contentPane.add(btnNewGame);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setFont(new Font("Arial", Font.BOLD, 12));
		lblTurno.setBounds(380, 65, 230, 14);
		contentPane.add(lblTurno);
		
		JPanel panelPlayer1 = new JPanel();
		panelPlayer1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelPlayer1.setBounds(380, 105, 230, 120);
		contentPane.add(panelPlayer1);
		panelPlayer1.setLayout(null);
		
		JLabel lblJugador1 = new JLabel("Jugador 1");
		lblJugador1.setFont(new Font("Arial", Font.BOLD, 11));
		lblJugador1.setBounds(10, 11, 60, 14);
		panelPlayer1.add(lblJugador1);
		
		JLabel lblNombre1 = new JLabel("Nombre:");
		lblNombre1.setFont(new Font("Arial", Font.BOLD, 11));
		lblNombre1.setBounds(10, 50, 60, 14);
		panelPlayer1.add(lblNombre1);
		
		textField1 = new JTextField();
		textField1.setBounds(80, 47, 86, 20);
		panelPlayer1.add(textField1);
		textField1.setColumns(10);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setFont(new Font("Arial", Font.BOLD, 11));
		lblTipo.setBounds(10, 95, 35, 14);
		panelPlayer1.add(lblTipo);
		
		JRadioButton rdbtnHumano1 = new JRadioButton("Humano");
		rdbtnHumano1.setBounds(51, 91, 70, 23);
		panelPlayer1.add(rdbtnHumano1);
		
		JRadioButton rdbtnCPU1 = new JRadioButton("CPU");
		rdbtnCPU1.setBounds(123, 91, 50, 23);
		panelPlayer1.add(rdbtnCPU1);
		
		JLabel lblPartidasGanadas = new JLabel("Partidas Ganadas:");
		lblPartidasGanadas.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPartidasGanadas.setBounds(80, 11, 105, 14);
		panelPlayer1.add(lblPartidasGanadas);
		
		JPanel panelPlayer2 = new JPanel();
		panelPlayer2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelPlayer2.setBounds(380, 236, 230, 120);
		contentPane.add(panelPlayer2);
		panelPlayer2.setLayout(null);
		
		JLabel lblJugador2 = new JLabel("Jugador 2");
		lblJugador2.setBounds(10, 11, 54, 13);
		lblJugador2.setFont(new Font("Arial", Font.BOLD, 11));
		panelPlayer2.add(lblJugador2);
		
		JLabel lblNombre2 = new JLabel("Nombre:");
		lblNombre2.setFont(new Font("Arial", Font.BOLD, 11));
		lblNombre2.setBounds(10, 50, 60, 14);
		panelPlayer2.add(lblNombre2);
		
		textField2 = new JTextField();
		textField2.setBounds(80, 47, 86, 20);
		panelPlayer2.add(textField2);
		textField2.setColumns(10);
		
		JLabel lblTipo_1 = new JLabel("Tipo:");
		lblTipo_1.setFont(new Font("Arial", Font.BOLD, 11));
		lblTipo_1.setBounds(10, 95, 35, 14);
		panelPlayer2.add(lblTipo_1);
		
		JRadioButton rdbtnHumano2 = new JRadioButton("Humano");
		rdbtnHumano2.setBounds(51, 91, 70, 23);
		panelPlayer2.add(rdbtnHumano2);
		
		JRadioButton rdbtnCPU2 = new JRadioButton("CPU");
		rdbtnCPU2.setBounds(123, 91, 50, 23);
		panelPlayer2.add(rdbtnCPU2);
		
		JLabel lblPartidasGanadas_1 = new JLabel("Partidas Ganadas:");
		lblPartidasGanadas_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPartidasGanadas_1.setBounds(80, 10, 105, 14);
		panelPlayer2.add(lblPartidasGanadas_1);
	}
}
