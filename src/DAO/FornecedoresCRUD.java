package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.FornecedoresDTO;




public class FornecedoresCRUD {
	private connectionDB con; //Objeto de conexão
	
	public FornecedoresCRUD(connectionDB con) {
		this.con = con;
	}
	private int idFornecedor, numero;
	private String nome, descricao, telefone, rua, bairro, cep; 
	//Método Cadastrar
		public void cadastrar(FornecedoresDTO forneccedor) throws Exception{
			String sql = "insert into fornecedores (nome, descricao, telefone, rua, numero, bairro, cep)"
					+ "values (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement p = con.getConnectionDB().prepareStatement(sql);
			p.setString(1, forneccedor.getNome());
			p.setString(2, forneccedor.getDescricao());
			p.setString(3, forneccedor.getTelefone());
			p.setString(4, forneccedor.getRua());
			p.setInt(5, forneccedor.getNumero());
			p.setString(6, forneccedor.getBairro());
			p.setString(7, forneccedor.getCep());
			
			p.executeUpdate();
			p.close();
		}

		//Método deletar
		public void deletar(FornecedoresDTO fornecedor) throws Exception{
			String sql = "delete from fornecedores where idFornecedor = ?";
			PreparedStatement p = con.getConnectionDB().prepareStatement(sql);
			p.setInt(1, fornecedor.getIdFornecedor());
			p.executeUpdate();
			p.close();
		}
		
		//Método Alterar
		public void alterar(FornecedoresDTO fornecedor) throws Exception{
			String sql = "update fornecedores set nome = ?, descricao = ?, telefone = ?, rua = ?,  numero = ?, bairro = ?, cep = ? where idFornecedor = ? ";
			PreparedStatement p = con.getConnectionDB().prepareStatement(sql);
			p.setString(1, fornecedor.getNome());
			p.setString(2, fornecedor.getDescricao());
			p.setString(3, fornecedor.getTelefone());
			p.setString(4, fornecedor.getRua());
			p.setInt(5, fornecedor.getNumero());
			p.setString(6, fornecedor.getBairro());
			p.setString(7, fornecedor.getCep());
			p.setInt(8, fornecedor.getIdFornecedor());
			p.executeUpdate();
			p.close();
		}
	
	//Método para Listar dados do banco
		public ArrayList<FornecedoresDTO> listarTodos() throws Exception {
			ArrayList<FornecedoresDTO> fornecedores = new ArrayList<FornecedoresDTO>();
			
			String sql = "select * from fornecedores";
			PreparedStatement p = con.getConnectionDB().prepareStatement(sql);
			ResultSet rs = p.executeQuery();
			
			while (rs.next()) {
				FornecedoresDTO fornecedor = new FornecedoresDTO();
				fornecedor.setIdFornecedor(rs.getInt("IDFORNECEDOR"));
				fornecedor.setNome(rs.getString("NOME"));
				fornecedor.setDescricao(rs.getString("DESCRICAO"));
				fornecedor.setTelefone(rs.getString("TELEFONE"));
				fornecedor.setRua(rs.getString("RUA"));
				fornecedor.setNumero(rs.getInt("NUMERO"));
				fornecedor.setBairro(rs.getString("BAIRRO"));
				fornecedor.setCep(rs.getString("CEP"));
				
				fornecedores.add(fornecedor);
			}
			rs.close();
			p.close();
			return fornecedores;
		}
}
