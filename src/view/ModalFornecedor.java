package view;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.FornecedoresCRUD;
import DAO.connectionDB;
import DTO.FornecedoresDTO;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ModalFornecedor extends JDialog {
	private JTextField textFieldNome;
	private JTextField textFieldDescricao;
	private JTextField textFieldTelefone;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldCep;
	private JLabel labelNameModal;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	
	int op = 0;
	int idFornecedor = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModalFornecedor dialog = new ModalFornecedor();
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the dialog.
	 */
	public ModalFornecedor() {
		setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		getContentPane().setForeground(new Color(255, 255, 255));
		setBounds(100, 100, 560, 647);
		getContentPane().setLayout(null);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(70, 70, 392, 32);
		getContentPane().add(textFieldNome);
		textFieldNome.setColumns(10);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setBounds(70, 130, 392, 32);
		getContentPane().add(textFieldDescricao);
		textFieldDescricao.setColumns(10);
		
		textFieldTelefone = new JTextField();
		textFieldTelefone.setBounds(70, 194, 153, 32);
		getContentPane().add(textFieldTelefone);
		textFieldTelefone.setColumns(10);
		
		textFieldRua = new JTextField();
		textFieldRua.setBounds(70, 334, 395, 32);
		getContentPane().add(textFieldRua);
		textFieldRua.setColumns(10);
		
		textFieldNumero = new JTextField();
		textFieldNumero.setBounds(73, 478, 153, 32);
		getContentPane().add(textFieldNumero);
		textFieldNumero.setColumns(10);
		
		textFieldBairro = new JTextField();
		textFieldBairro.setBounds(73, 404, 392, 32);
		getContentPane().add(textFieldBairro);
		textFieldBairro.setColumns(10);
		
		textFieldCep = new JTextField();
		textFieldCep.setBounds(70, 265, 86, 32);
		getContentPane().add(textFieldCep);
		textFieldCep.setColumns(10);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				
				connectionDB con = new connectionDB();
				
				FornecedoresDTO fornecedor = new FornecedoresDTO();
				FornecedoresCRUD fornecedor_crud = new FornecedoresCRUD(con);
				
				con.getConnectionDB();
				
//				int numero = Integer.valueOf(textFieldNumero.getText());
				
				fornecedor.setNome(textFieldNome.getText());
				fornecedor.setDescricao(textFieldDescricao.getText());
				fornecedor.setTelefone(textFieldTelefone.getText());
				fornecedor.setRua(textFieldRua.getText());
				fornecedor.setNumero(Integer.valueOf(textFieldNumero.getText()));
				fornecedor.setBairro(textFieldBairro.getText());
				fornecedor.setCep(textFieldCep.getText());
				
				FornecedoresView fornecedoresView = new FornecedoresView();
				
				try {
					
					if(op == 0) {
						fornecedor_crud.cadastrar(fornecedor);
						JOptionPane.showMessageDialog(null, "Cadastro"
								+ " realizado com sucesso!!!");
						
						fornecedoresView.setVisible(true);
						setVisible(false);
					}else {
						fornecedor.setIdFornecedor(idFornecedor);
						fornecedor_crud.alterar(fornecedor);
						JOptionPane.showMessageDialog(null, "Cadastro"
								+ " alterado com sucesso!!!");
						
						fornecedoresView.setVisible(true);
						setVisible(false);
					}
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					if(op == 0) {
						JOptionPane.showMessageDialog(null, ""
								+ " Erro ao realizar cadastro do fornecedor!!!");
					}else {
						JOptionPane.showMessageDialog(null, ""
								+ " Erro ao alterar cadastro do fornecedor!!!");
					}
				}
				
				
				
				
			}
		});
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalvar.setFocusPainted(false);
		btnSalvar.setBackground(new Color(27, 19, 74));
		btnSalvar.setBounds(73, 542, 161, 32);
		getContentPane().add(btnSalvar);
		
		labelNameModal = new JLabel("Novo fornecedor");
		labelNameModal.setHorizontalAlignment(SwingConstants.CENTER);
		labelNameModal.setFont(new Font("Tahoma", Font.BOLD, 16));
		labelNameModal.setBounds(162, 11, 186, 26);
		getContentPane().add(labelNameModal);
		
		lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(70, 55, 92, 14);
		getContentPane().add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Descri\u00E7\u00E3o");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(70, 113, 92, 14);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(70, 178, 153, 14);
		getContentPane().add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Rua");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(70, 319, 153, 14);
		getContentPane().add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Bairro");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(73, 387, 153, 14);
		getContentPane().add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Numero");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(73, 461, 153, 14);
		getContentPane().add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("CEP");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(70, 248, 153, 14);
		getContentPane().add(lblNewLabel_7);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FornecedoresView fornecedoresView = new FornecedoresView();
				fornecedoresView.setVisible(true);
				setVisible(false);
			}
		});
		btnCancelar.setForeground(new Color(0, 0, 0));
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setBounds(301, 542, 161, 32);
		getContentPane().add(btnCancelar);

	}
	
	
	
	public void AlterarFornecedor(FornecedoresDTO fornecedor )
    {
		try {
			labelNameModal.setText("Alterar fornecedor");
			
			idFornecedor = fornecedor.getIdFornecedor();
			textFieldNome.setText(fornecedor.getNome());
			textFieldDescricao.setText(fornecedor.getDescricao());
			textFieldTelefone.setText(fornecedor.getTelefone());
			textFieldCep.setText(fornecedor.getCep());
			textFieldRua.setText(fornecedor.getRua());
			textFieldBairro.setText(fornecedor.getBairro());
			textFieldNumero.setText(String.valueOf(fornecedor.getNumero()));
			op = 1;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }  
}
