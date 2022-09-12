package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.UsuarioDAO;
import DAO.connectionDB;
import DTO.UsuarioDTO;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField textSenha;
	private JTextField textError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
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
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1015, 675);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(27, 19, 74));
		panel.setForeground(new Color(45, 20, 58));
		panel.setBounds(0, 0, 462, 636);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("l");
		lblNewLabel_2.setBounds(91, 77, 280, 462);
		lblNewLabel_2.setIcon(new ImageIcon("C:\\java\\ZionEstoque\\images\\logoNoBgTwo.png"));
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("Conecte-se");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(630, 74, 202, 43);
		contentPane.add(lblNewLabel);
		
		textUsuario = new JTextField();
		textUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textUsuario.setBounds(560, 205, 347, 43);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Usu\u00E1rio");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(561, 180, 99, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Senha");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(561, 278, 99, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnLogin = new JButton("Entrar");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textError.setText("");
				
				connectionDB con = new connectionDB();
				String usuario_login, senha;
				
				usuario_login = textUsuario.getText();
				senha  = textSenha.getText();
				
				UsuarioDTO objUsuarioDto = new UsuarioDTO();
				objUsuarioDto.setUsuario_login(usuario_login);
				objUsuarioDto.setSenha(senha);
				
				UsuarioDAO  objUsuarioDAO  = new UsuarioDAO();
				ResultSet resUsuarioDAO = objUsuarioDAO.autenticacacoUsuario(objUsuarioDto);

				try {
					if(resUsuarioDAO.next()) {
						HomeView homeView = new HomeView();
						homeView.setLocationRelativeTo(null);
						homeView.setVisible(true);
						dispose();
					}else {
						textError.setText("Usuario ou senha incorretos");
					}
				} catch (HeadlessException | SQLException error) {
					error.printStackTrace();
//					JOptionPane.showMessageDialog(null, "Botão login: " + error);
					textError.setText("Error ao executar operação");
				}
			}
		});
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnLogin.setBackground(new Color(27, 19, 74));
		btnLogin.setBounds(560, 417, 347, 43);
		btnLogin.setFocusPainted(false);
		contentPane.add(btnLogin);
		
		JButton btnNewButton_2 = new JButton("N\u00E3o possui cadastro? Cadastre-se");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUp = new SignUp();
				signUp.setLocationRelativeTo(null);
				setVisible(false);
				signUp.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.setBounds(560, 575, 347, 37);
		contentPane.add(btnNewButton_2);
		
		textSenha = new JPasswordField();
		textSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textSenha.setBounds(560, 303, 347, 43);
		contentPane.add(textSenha);
		
		textError = new JTextField();
		textError.setBorder(null);
		textError.setEditable(false);
		textError.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textError.setForeground(new Color(255, 0, 0));
		textError.setBackground(new Color(255, 255, 255));
		textError.setBounds(560, 357, 347, 37);
		contentPane.add(textError);
		textError.setColumns(10);
	}
}
