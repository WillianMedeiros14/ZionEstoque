package view;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import DAO.FornecedoresCRUD;
import DAO.ProdutoCRUD;
import DAO.connectionDB;
import DTO.FornecedoresDTO;
import DTO.ProdutoDTO;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class ModalProduto extends JDialog {
	
	

	private final JPanel contentPanel = new JPanel();
	private JPanel panelImage;
	private JLabel lblmagem;
	
	private File imagem;
	private JTextField textFieldNome;
	private JTextField textFieldDescricao;
	private JTextField textFieldIdFornecedor;
	
	ProdutoDTO produto = new ProdutoDTO();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ModalProduto dialog = new ModalProduto();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ModalProduto() {
		setBounds(100, 100, 802, 388);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JButton btnSelecionarImagem = new JButton("Selecionar imagem");
			btnSelecionarImagem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					selecionarImgem();
				}
			});
			btnSelecionarImagem.setForeground(new Color(0, 0, 0));
			btnSelecionarImagem.setFont(new Font("Tahoma", Font.PLAIN, 13));
			btnSelecionarImagem.setFocusPainted(false);
			btnSelecionarImagem.setBackground(new Color(255, 255, 255));
			btnSelecionarImagem.setBounds(590, 208, 161, 32);
			contentPanel.add(btnSelecionarImagem);
		}
		
		textFieldNome = new JTextField();
		textFieldNome.setColumns(10);
		textFieldNome.setBounds(58, 70, 392, 32);
		contentPanel.add(textFieldNome);
		
		JLabel lblNewLabel_1 = new JLabel("Nome");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(58, 55, 92, 14);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNovoProduto = new JLabel("Novo produto");
		lblNovoProduto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNovoProduto.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNovoProduto.setBounds(314, 11, 186, 26);
		contentPanel.add(lblNovoProduto);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setForeground(Color.WHITE);
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalvar.setFocusPainted(false);
		btnSalvar.setBackground(new Color(27, 19, 74));
		btnSalvar.setBounds(61, 542, 161, 32);
		contentPanel.add(btnSalvar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setFocusPainted(false);
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setBounds(289, 542, 161, 32);
		contentPanel.add(btnCancelar);
		
		textFieldDescricao = new JTextField();
		textFieldDescricao.setColumns(10);
		textFieldDescricao.setBounds(58, 137, 392, 32);
		contentPanel.add(textFieldDescricao);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descric\u00E3o");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(58, 122, 92, 14);
		contentPanel.add(lblNewLabel_1_1);
		
		textFieldIdFornecedor = new JTextField();
		textFieldIdFornecedor.setColumns(10);
		textFieldIdFornecedor.setBounds(58, 209, 392, 32);
		contentPanel.add(textFieldIdFornecedor);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Id Fornecedor");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(58, 194, 196, 14);
		contentPanel.add(lblNewLabel_1_1_1);
		
		panelImage = new JPanel();
		panelImage.setBounds(590, 69, 161, 128);
		contentPanel.add(panelImage);
		panelImage.setLayout(null);
		
		lblmagem = new JLabel("");
		lblmagem.setBounds(0, 0, 161, 128);
		panelImage.add(lblmagem);
		
		JButton btnSalvar_1 = new JButton("Salvar");
		btnSalvar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				connectionDB con = new connectionDB();
				
				
				ProdutoCRUD produto_crud = new ProdutoCRUD(con);
				
				con.getConnectionDB();
				
				try {
					
					produto.setNome(textFieldNome.getText());
					produto.setDescricao(textFieldDescricao.getText());
					produto.setImage(getImage());
					produto.setIdFornecedor(Integer.valueOf(textFieldIdFornecedor.getText()));
					
					produto_crud.cadastrar(produto);
					
					JOptionPane.showMessageDialog(null, "Cadastro"
							+ " realizado com sucesso!!!");
//					fornecedoresView.setLocationRelativeTo(null);
//					fornecedoresView.setVisible(true);
					setVisible(false);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Erro ao"
							+ " realizar cadastro!!!");
				}
				
			}
		});
		btnSalvar_1.setForeground(Color.WHITE);
		btnSalvar_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalvar_1.setFocusPainted(false);
		btnSalvar_1.setBackground(new Color(27, 19, 74));
		btnSalvar_1.setBounds(215, 306, 161, 32);
		contentPanel.add(btnSalvar_1);
		
		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar_1.setForeground(Color.BLACK);
		btnCancelar_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar_1.setFocusPainted(false);
		btnCancelar_1.setBackground(Color.WHITE);
		btnCancelar_1.setBounds(443, 306, 161, 32);
		contentPanel.add(btnCancelar_1);
	}
	
	
	public File selecionarImgem() {
		JFileChooser fileChooser = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Imagens em JPEG e PNG", "jpg", "png");
		fileChooser.addChoosableFileFilter(filtro);
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setDialogType(fileChooser.OPEN_DIALOG);
		fileChooser.setCurrentDirectory( new File("/"));
		fileChooser.showOpenDialog(this);
		
		return fileChooser.getSelectedFile();
	}
	
	
	private byte[] getImage() {
		boolean isPng = false;
		
		if(imagem != null) {
			isPng = imagem.getName().endsWith("png");
			try {
				BufferedImage image = ImageIO.read(imagem);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				int type = BufferedImage.TYPE_INT_RGB;
				if(isPng) {
					type = BufferedImage.BITMASK;
				}
				
				BufferedImage novaImagem = new BufferedImage(panelImage.getWidth() -5, panelImage.getHeight() -10, type);
				Graphics2D g = novaImagem.createGraphics();
				g.setComposite(AlphaComposite.Src);
				g.drawImage(image, 0, 0, panelImage.getWidth() -5, panelImage.getHeight() -10, null);
				
				if(isPng) {
					ImageIO.write(novaImagem, "png", out);
				}else{
					ImageIO.write(novaImagem, "jpg", out);
				}
				
				out.flush();
				byte[] byteArray = out.toByteArray();
				out.close();
				
				return byteArray;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		return null;
	}
	
	
	private void abrirImagem(Object source) {
		if(source instanceof File) {
			ImageIcon icon = new ImageIcon(imagem.getAbsolutePath());
			icon.setImage(icon.getImage().getScaledInstance(panelImage.getWidth() -5, panelImage.getHeight() -10, 100));
			
			lblmagem.setIcon(icon);
			
		}else if(source instanceof byte[]){
			ImageIcon icon = new ImageIcon(produto.getImage());
			icon.setImage(icon.getImage().getScaledInstance(panelImage.getWidth() -5, panelImage.getHeight() -10, 100));
			lblmagem.setIcon(icon);
		}
	}
}
