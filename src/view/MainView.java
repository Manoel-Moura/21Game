package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextPane;



import main.Main;

import models.Partida;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainView{

	private JFrame frame;
	JTextPane Placar;
    static Partida partida = new Partida();


    
    

	public static Partida getPartida() {
		return partida;
	}

	public static void setPartida(Partida partida) {
		MainView.partida = partida;
	}

	public JTextPane getPlacar() {
		return Placar;
	}

	public void setPlacar(JTextPane placar) {
		Placar = placar;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView window = new MainView();
					window.frame.setVisible(true);
					partida.init();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		MainView window = new MainView();
		window.frame.setVisible(true);
		
	}

	/**
	 * Create the application.
	 */
	public MainView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setAlwaysOnTop(true);
		frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 12));
		frame.setBounds(100, 100, 450, 300);
		//frame.setSize(800,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(38, 111, 39));
		
		JButton btnBaralho = new JButton("Baralho");
		//btnBaralho.setIcon(new ImageIcon("/home/manoelmoura/Imagens/baralho.png"));
		btnBaralho.setBounds(343, 12, 97, 127);
		//btnBaralho.addActionListener(new Jogo21Control(this));
		frame.getContentPane().add(btnBaralho);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(262, 152, 166, 106);
		frame.getContentPane().add(textPane);
		
		Placar = new JTextPane();
		Placar.setBounds(12, 12, 166, 106);
		frame.getContentPane().add(Placar);
		
		JLabel lblNomeDoJogador = new JLabel("Nome do Jogador");
		lblNomeDoJogador.setForeground(Color.YELLOW);
		lblNomeDoJogador.setFont(new Font("Dialog", Font.ITALIC, 14));
		lblNomeDoJogador.setBounds(82, 149, 180, 15);
		frame.getContentPane().add(lblNomeDoJogador);
		
		JLabel lblPontuacao = new JLabel("Pontos");
		lblPontuacao.setForeground(Color.YELLOW);
		lblPontuacao.setFont(new Font("Dialog", Font.ITALIC, 14));
		lblPontuacao.setBounds(82, 176, 180, 15);
		frame.getContentPane().add(lblPontuacao);
		
		JButton btnNewButton = new JButton("Passar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(82, 203, 117, 34);
		frame.getContentPane().add(btnNewButton);
		
		
	}
}
