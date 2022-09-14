package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class ProdutoView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutoView frame = new ProdutoView();
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
	public ProdutoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 674);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(27, 19, 74));
		panel.setBounds(0, 0, 1183, 125);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(98, 5, -91, 52);
		panel.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(23, -23, 284, 170);
		panel.add(lblNewLabel);
		
		JButton btnHome = new JButton("Home");
		btnHome.setForeground(Color.WHITE);
		btnHome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnHome.setFocusPainted(false);
		btnHome.setBackground(new Color(27, 19, 74));
		btnHome.setBounds(836, 53, 161, 32);
		panel.add(btnHome);
		
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.setForeground(Color.WHITE);
		btnProdutos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProdutos.setFocusPainted(false);
		btnProdutos.setBackground(new Color(27, 19, 74));
		btnProdutos.setBounds(1010, 53, 144, 32);
		panel.add(btnProdutos);
		
		JLabel lblNewLabel_1 = new JLabel("Fornecedores");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(303, 52, 218, 32);
		panel.add(lblNewLabel_1);
	}
}
