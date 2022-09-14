package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(560, 205, 347, 43);
		contentPane.add(textField);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(561, 180, 99, 25);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField_1.setColumns(10);
		textField_1.setBounds(560, 303, 347, 43);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(561, 278, 99, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setFocusPainted(false);
		btnNewButton.setBackground(new Color(27, 19, 74));
		btnNewButton.setBounds(560, 394, 347, 43);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("J\u00E1 possui cadastro? Conecte-se");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginView loginView = new LoginView();
				loginView.setLocationRelativeTo(null);
				setVisible(false);
				loginView.setVisible(true);
			}
		});
		btnNewButton_2.setForeground(Color.BLACK);
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(560, 575, 347, 37);
		contentPane.add(btnNewButton_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(new Color(45, 20, 58));
		panel.setBackground(new Color(27, 19, 74));
		panel.setBounds(0, 0, 462, 636);
		contentPane.add(panel);
		
		JLabel lblNewLabel_2 = new JLabel("l");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\java\\ZionEstoque\\images\\logoNoBgTwo.png"));
		lblNewLabel_2.setBounds(91, 77, 280, 462);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Cadastrar");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(630, 74, 202, 43);
		contentPane.add(lblNewLabel);
	}

}
