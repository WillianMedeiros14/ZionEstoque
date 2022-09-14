package view;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;

public class MainView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(45, 20, 58));
		panel.setBackground(new Color(27, 19, 74));
		panel.setBounds(0, 0, 999, 636);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2_1 = new JLabel("l");
		lblNewLabel_2_1.setIcon(new ImageIcon("C:\\java\\ZionEstoque\\images\\logoNoBgTwo.png"));
		lblNewLabel_2_1.setBounds(84, 88, 280, 462);
		panel.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_1 = new JLabel("Sistema de Controle");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(511, 184, 418, 64);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("de Estoque");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel_1_1.setBounds(511, 241, 418, 49);
		panel.add(lblNewLabel_1_1);
		
		JButton btnIniciar = new JButton("INICIAR");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView loginView = new LoginView();
				loginView.setLocationRelativeTo(null);
				setVisible(false);
				loginView.setVisible(true);
				
			}
		});
		btnIniciar.setForeground(Color.WHITE);
		btnIniciar.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnIniciar.setFocusPainted(false);
		btnIniciar.setBackground(new Color(27, 19, 74));
		btnIniciar.setBounds(547, 343, 347, 43);
		panel.add(btnIniciar);
		
		JLabel lblNewLabel_2 = new JLabel("l");
		lblNewLabel_2.setBounds(347, 189, 280, 462);
		contentPane.add(lblNewLabel_2);
	}

}
