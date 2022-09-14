package DAO;

import java.sql.PreparedStatement;

import DTO.ProdutoDTO;

public class ProdutoCRUD {
private connectionDB con; //Objeto de conexão
	
	public ProdutoCRUD(connectionDB con) {
		this.con = con;
	}

	private int idProduto, idFornecedor;
	private String nome, descricao;
	private byte[] imagem;

	//Método Cadastrar
		public void cadastrar(ProdutoDTO produto) throws Exception{
			String sql = "insert into produto (nome, imagem, descricao, idFornecedor)"
					+ "values (?, ?, ?, ?)";
			PreparedStatement p = con.getConnectionDB().prepareStatement(sql);
			p.setString(1, produto.getNome());
			p.setBytes(2, produto.getImage());
			p.setString(3, produto.getDescricao());
			p.setInt(4, produto.getIdFornecedor());
			
			p.executeUpdate();
			p.close();
		}

}
