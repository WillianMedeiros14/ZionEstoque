package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.beans.PropertyChangeEvent;
import javax.swing.table.DefaultTableModel;

import DAO.FornecedoresCRUD;
import DAO.connectionDB;
import DTO.FornecedoresDTO;

import javax.swing.JScrollPane;

public class FornecedoresView extends JFrame {

	private JPanel contentPane;
	private JTable tableFornecedores;
	DefaultTableModel modelo = new DefaultTableModel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FornecedoresView frame = new FornecedoresView();
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
	public FornecedoresView() {
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					carregaTabela();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 675);
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
		lblNewLabel.setIcon(new ImageIcon("C:\\java\\ZionEstoque\\images\\LogoHomeHeader.png"));
		lblNewLabel.setBounds(23, -23, 284, 170);
		panel.add(lblNewLabel);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomeView homeView = new HomeView();
				homeView.setLocationRelativeTo(null);
				homeView.setVisible(true);
				setVisible(false);
			}
		});
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
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(303, 52, 218, 32);
		panel.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 227, 1183, 409);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 0, 1163, 409);
		panel_2.add(scrollPane);
		
		tableFornecedores = new JTable(modelo);
		tableFornecedores.getTableHeader().setResizingAllowed(false);
		tableFornecedores.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(tableFornecedores);
		
		JButton btnAdicionar = new JButton("Adicionar");
		btnAdicionar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModalFornecedor modalFornecedor = new ModalFornecedor();
				modalFornecedor.setLocationRelativeTo(null);
				modalFornecedor.setVisible(true);
				setVisible(false);
			}
		});
		btnAdicionar.setForeground(Color.WHITE);
		btnAdicionar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdicionar.setFocusPainted(false);
		btnAdicionar.setBackground(new Color(27, 19, 74));
		btnAdicionar.setBounds(10, 140, 161, 32);
		contentPane.add(btnAdicionar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Instanciar conexão
				connectionDB con = new connectionDB();
				
				//Criar instância do Livro e Livro_CRUD
				FornecedoresDTO fornecedor = new FornecedoresDTO();
				FornecedoresCRUD fornecedor_crud = new FornecedoresCRUD(con);
				
				//Conecta com o banco
				con.getConnectionDB();
				
				
				//pegar codigo na tabela
				int linhaSel = tableFornecedores.getSelectedRow();
				if(linhaSel != -1) {
					int cod = (int)tableFornecedores.getValueAt(linhaSel, 0);
					String nome = (String)tableFornecedores.getValueAt(linhaSel, 1);
					String descricao = (String)tableFornecedores.getValueAt(linhaSel, 2);
					String telefone = (String)tableFornecedores.getValueAt(linhaSel, 3);
					String rua = (String)tableFornecedores.getValueAt(linhaSel, 4);
					int numero = (int)tableFornecedores.getValueAt(linhaSel, 5);
					String bairro = (String)tableFornecedores.getValueAt(linhaSel, 6);
					String cep = (String)tableFornecedores.getValueAt(linhaSel, 7);
					
					fornecedor.setIdFornecedor(cod);
					fornecedor.setNome(nome);
					fornecedor.setDescricao(descricao);
					fornecedor.setTelefone(telefone);
					fornecedor.setRua(rua);
					fornecedor.setNumero(numero);
					fornecedor.setBairro(bairro);
					fornecedor.setCep(cep);
					
					ModalFornecedor modalFornecedor = new ModalFornecedor();
					
					modalFornecedor.AlterarFornecedor(fornecedor);
					
					
					modalFornecedor.setLocationRelativeTo(null);
					modalFornecedor.setVisible(true);
					setVisible(false);
				}else {
					 JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
			}
		});
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditar.setFocusPainted(false);
		btnEditar.setBackground(new Color(27, 19, 74));
		btnEditar.setBounds(181, 140, 161, 32);
		contentPane.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instanciar conexão
				connectionDB con = new connectionDB();
				
				//Criar instância do Livro e Livro_CRUD
				FornecedoresDTO fornecedor = new FornecedoresDTO();
				FornecedoresCRUD fornecedor_crud = new FornecedoresCRUD(con);
				
				//Conecta com o banco
				con.getConnectionDB();
				
				//pegar codigo na tabela
				int linhaSel = tableFornecedores.getSelectedRow();
				
				if(linhaSel != -1) {
					int cod = (int)tableFornecedores.getValueAt(linhaSel, 0);
					
					fornecedor.setIdFornecedor(cod);
					
					try {
						fornecedor_crud.deletar(fornecedor);
						carregaTabela();
						JOptionPane.showMessageDialog(null, "Cadastro"
								+ " excluido com sucesso!!!");
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
					 JOptionPane.showMessageDialog(null, "Selecione uma linha");
				}
				
				
			}
		});
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluir.setFocusPainted(false);
		btnExcluir.setBackground(new Color(27, 19, 74));
		btnExcluir.setBounds(352, 140, 161, 32);
		contentPane.add(btnExcluir);
		
		modelo.addColumn("IdFornecedor");
		modelo.addColumn("Nome");
		modelo.addColumn("Descricaco");	
		modelo.addColumn("Telefone");
		modelo.addColumn("Rua");
		modelo.addColumn("Numero");		
		modelo.addColumn("Bairro");
		modelo.addColumn("Cep");	
	}
	
	public void carregaTabela() throws Exception {
		
		((DefaultTableModel)tableFornecedores.getModel()).setNumRows(0);
		
		connectionDB con = new connectionDB();
		con.getConnectionDB();
		
		FornecedoresCRUD 	fornecedor_crud = new FornecedoresCRUD(con);
		
		List<FornecedoresDTO> list_livro = fornecedor_crud.listarTodos();
		
		for (FornecedoresDTO fr : list_livro) {
			modelo.addRow(new Object[] {fr.getIdFornecedor(), fr.getNome(),  fr.getDescricao(), fr.getTelefone(), fr.getRua(), fr.getNumero(), fr.getBairro(), fr.getCep()});
		}
	}
	
	public void AddNewFornecedor()
    {
		try {
			carregaTabela();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
}
