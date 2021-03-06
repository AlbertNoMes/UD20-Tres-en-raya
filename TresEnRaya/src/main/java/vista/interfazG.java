package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.anm.TresEnRaya.Pair;
import com.anm.TresEnRaya.Tablero;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

	private boolean CPU;
	private boolean inicio;
	private int cont1;
	private int cont2;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField2;
	private Tablero tablero;
	private char opcion;

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
		opcion = 'X';
		cont1 = 0;
		cont2 = 0;
		inicio = false;
		tablero = new Tablero();
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
		
		final JLabel lblTurno = new JLabel("Turno");
		lblTurno.setFont(new Font("Arial", Font.BOLD, 12));
		lblTurno.setBounds(380, 65, 230, 14);
		contentPane.add(lblTurno);
		
		JPanel panelPlayer1 = new JPanel();
		panelPlayer1.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelPlayer1.setBounds(380, 105, 230, 120);
		contentPane.add(panelPlayer1);
		panelPlayer1.setLayout(null);
		
		final JLabel lblJugador1 = new JLabel("Jugador 1");
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
		
		final JLabel lblPartidasGanadas = new JLabel("Partidas Ganadas:");
		lblPartidasGanadas.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPartidasGanadas.setBounds(80, 11, 105, 14);
		panelPlayer1.add(lblPartidasGanadas);
		
		JPanel panelPlayer2 = new JPanel();
		panelPlayer2.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		panelPlayer2.setBounds(380, 236, 230, 120);
		contentPane.add(panelPlayer2);
		panelPlayer2.setLayout(null);
		
		final JLabel lblJugador2 = new JLabel("Jugador 2");
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
		
		JLabel lblTipo2 = new JLabel("Tipo:");
		lblTipo2.setFont(new Font("Arial", Font.BOLD, 11));
		lblTipo2.setBounds(10, 95, 35, 14);
		panelPlayer2.add(lblTipo2);
		
		JRadioButton rdbtnHumano2 = new JRadioButton("Humano",false);
		rdbtnHumano2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				boolean ok = ((JRadioButton)e.getSource()).isSelected();
				if(!ok && !inicio) 
					CPU = ok;
			}
		});
		rdbtnHumano2.setBounds(51, 91, 86, 23);
		panelPlayer2.add(rdbtnHumano2);
		
		final JRadioButton rdbtnCPU2 = new JRadioButton("CPU",true);
		rdbtnCPU2.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if(!((JRadioButton)e.getSource()).isSelected() && !inicio)
					CPU = !((JRadioButton)e.getSource()).isSelected();

			}
		});
		rdbtnCPU2.setBounds(139, 91, 50, 23);
		panelPlayer2.add(rdbtnCPU2);
		
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(rdbtnHumano2);
		bgroup.add(rdbtnCPU2);
		
		CPU = rdbtnCPU2.isSelected();
		
		final JLabel lblPartidasGanadas_1 = new JLabel("Partidas Ganadas:");
		lblPartidasGanadas_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblPartidasGanadas_1.setBounds(80, 10, 105, 14);
		panelPlayer2.add(lblPartidasGanadas_1);
		
		final JButton btn00 = new JButton("");
		btn00.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugarTurno(lblTurno,lblJugador1,lblJugador2,lblPartidasGanadas,lblPartidasGanadas_1,(JButton)e.getSource(),0,0,rdbtnCPU2.isSelected());
			}
		});
		btn00.setBounds(10, 11, 100, 100);
		panelButtons.add(btn00);
		
		final JButton btn10 = new JButton("");
		btn10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugarTurno(lblTurno,lblJugador1,lblJugador2,lblPartidasGanadas,lblPartidasGanadas_1,(JButton)e.getSource(),1,0,rdbtnCPU2.isSelected());
			}
		});
		
		btn10.setBounds(120, 11, 100, 100);
		panelButtons.add(btn10);
		
		final JButton btn20 = new JButton("");
		btn20.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugarTurno(lblTurno,lblJugador1,lblJugador2,lblPartidasGanadas,lblPartidasGanadas_1,(JButton)e.getSource(),2,0,rdbtnCPU2.isSelected());
			}
		});
		
		btn20.setBounds(230, 11, 100, 100);
		panelButtons.add(btn20);
		
		final JButton btn01 = new JButton("");
		btn01.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugarTurno(lblTurno,lblJugador1,lblJugador2,lblPartidasGanadas,lblPartidasGanadas_1,(JButton)e.getSource(),0,1,rdbtnCPU2.isSelected());
			}
		});
		btn01.setBounds(10, 122, 100, 100);
		panelButtons.add(btn01);
		
		final JButton btn11 = new JButton("");
		btn11.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugarTurno(lblTurno,lblJugador1,lblJugador2,lblPartidasGanadas,lblPartidasGanadas_1,(JButton)e.getSource(),1,1,rdbtnCPU2.isSelected());
			}
		});

		btn11.setBounds(120, 122, 100, 100);
		panelButtons.add(btn11);
		
		final JButton btn21 = new JButton("");
		btn21.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugarTurno(lblTurno,lblJugador1,lblJugador2,lblPartidasGanadas,lblPartidasGanadas_1,(JButton)e.getSource(),2,1,rdbtnCPU2.isSelected());
			}
		});

		btn21.setBounds(230, 122, 100, 100);
		panelButtons.add(btn21);
		
		final JButton btn02 = new JButton("");
		btn02.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugarTurno(lblTurno,lblJugador1,lblJugador2,lblPartidasGanadas,lblPartidasGanadas_1,(JButton)e.getSource(),0,2,rdbtnCPU2.isSelected());
			}
		});
		
		btn02.setBounds(10, 233, 100, 100);
		panelButtons.add(btn02);
		
		final JButton btn12 = new JButton("");
		btn12.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugarTurno(lblTurno,lblJugador1,lblJugador2,lblPartidasGanadas,lblPartidasGanadas_1,(JButton)e.getSource(),1,2,rdbtnCPU2.isSelected());
			}
		});

		btn12.setBounds(120, 233, 100, 100);
		panelButtons.add(btn12);
		
		final JButton btn22 = new JButton("");
		btn22.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jugarTurno(lblTurno,lblJugador1,lblJugador2,lblPartidasGanadas,lblPartidasGanadas_1,(JButton)e.getSource(),2,2,rdbtnCPU2.isSelected());
			}
		});
		btn22.setBounds(230, 233, 100, 100);
		panelButtons.add(btn22);
		
		//Al pulsar este boton se reinica el tablero y comienza una nueva partida
		final JButton btnNewGame = new JButton("Nueva Partida");
        btnNewGame.setFont(new Font("Arial", Font.BOLD, 15));
        btnNewGame.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	inicio = false;
            	opcion = 'X';
            	tablero.reiniciarPartida();
                btn00.setIcon(new ImageIcon());
                btn00.setEnabled(true);
                btn10.setIcon(new ImageIcon());
                btn10.setEnabled(true);
                btn20.setIcon(new ImageIcon());
                btn20.setEnabled(true);
                btn01.setIcon(new ImageIcon());
                btn01.setEnabled(true);
                btn11.setIcon(new ImageIcon());
                btn11.setEnabled(true);
                btn21.setIcon(new ImageIcon());
                btn21.setEnabled(true);
                btn02.setIcon(new ImageIcon());
                btn02.setEnabled(true);
                btn12.setIcon(new ImageIcon());
                btn12.setEnabled(true);
                btn22.setIcon(new ImageIcon());
                btn22.setEnabled(true);
            }
        });
        btnNewGame.setBounds(425, 11, 154, 23);
        contentPane.add(btnNewGame);
	}
	
	public void jugarCPU() {
		Pair <Boolean,int[]> aux = tablero.jugarCPU();
		if(aux.getKey()) {
			int [] coord = aux.getValue();
			
			JButton boton = (JButton)((JPanel)contentPane.getComponents()[0]).getComponents()[3 * coord[1] + coord[0]];
			ImageIcon img;
			JLabel label = (JLabel)(((JPanel)contentPane.getComponents()[3]).getComponents()[6]);
			
			img = new ImageIcon(interfazG.class.getResource("/img/circulo.png"));
			img = new ImageIcon(img.getImage().getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE));
			boton.setIcon(img);
			
			if(tablero.finDeJuego().getKey()) {
				cont2++;
				label.setText("Partidas Ganadas: " + cont2);
			}
		}
	}
	
	/*
	 * Funcion que se encarga de toda la logica de los turnos. Actualizando los labels
	 * o botones cuando sea necesario. 
	 */
	public void jugarTurno(JLabel t, JLabel j1, JLabel j2, JLabel l1, JLabel l2, JButton b, int x, int y,boolean aux) {
		if(!textField1.getText().equals("")) {
			if(!tablero.finDeJuego().getKey()) {
				
				if(tablero.jugarCasilla(opcion, x, y)) {
					ImageIcon img; 
					if(opcion == 'X')
						img = new ImageIcon(interfazG.class.getResource("/img/cruz.png"));
					else
						img = new ImageIcon(interfazG.class.getResource("/img/circulo.png"));
					img = new ImageIcon(img.getImage().getScaledInstance(100, 100, DO_NOTHING_ON_CLOSE));
					b.setIcon(img);
	
					if(tablero.finDeJuego().getKey()) {
						if(tablero.finDeJuego().getValue() == 'X') {
							cont1++;
							l1.setText("Partidas ganadas: " + cont1);
						}
						else {
							cont2++;
							l2.setText("Partidas ganadas: " + cont2);
							
						}
					}
					else
						if(aux) {
							jugarCPU();
							if(!inicio) {
								t.setText("Turno: " + textField1.getText());
							}
						}
						else
							if(opcion == 'X') {
								t.setText("Turno: " + textField2.getText());
								opcion = 'O';
							}
							else{
								t.setText("Turno: " + textField1.getText());
								opcion = 'X';
							}
				}

				if(!inicio) {
					inicio = true;
					j1.setText(textField1.getText());
					if(!aux)
						j2.setText(textField2.getText());
					else
						j2.setText("CPU");
				}
			}
		}
		else
			JOptionPane.showMessageDialog(null, "Cuidado! No has introducido un nombre!");
	}
	
	public void print(String s) {
		System.out.print(s);
	}
}
