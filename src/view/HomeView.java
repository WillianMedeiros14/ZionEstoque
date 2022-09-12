package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;

public class HomeView extends JFrame {

	private JPanel contentPane;
	private final JPanel panel = new JPanel();
	private final JLabel lblNewLabel = new JLabel("");
	private final JButton btnProdutos = new JButton("Produtos");
	private final JButton btnFornecedores = new JButton("Fornecedores");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
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
	public HomeView() {
		setResizable(false);
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 675);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBackground(new Color(27, 19, 74));
		panel.setBounds(0, -1, 1183, 125);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(98, 5, -91, 52);
		panel.add(panel_1);
		lblNewLabel.setIcon(new ImageIcon("C:\\java\\ZionEstoque\\images\\LogoHomeHeader.png"));
		lblNewLabel.setBounds(23, -23, 489, 170);
		
		panel.add(lblNewLabel);
		btnProdutos.setForeground(Color.WHITE);
		btnProdutos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnProdutos.setFocusPainted(false);
		btnProdutos.setBackground(new Color(27, 19, 74));
		btnProdutos.setBounds(836, 53, 161, 32);
		
		panel.add(btnProdutos);
		btnFornecedores.setForeground(Color.WHITE);
		btnFornecedores.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnFornecedores.setFocusPainted(false);
		btnFornecedores.setBackground(new Color(27, 19, 74));
		btnFornecedores.setBounds(1010, 53, 144, 32);
		
		panel.add(btnFornecedores);
	}

}
