package DTO;

public class ProdutoDTO {
	private int idProduto, idFornecedor;
	private String nome, descricao;
	private byte[] imagem;
	
	
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getIdFornecedor() {
		return idFornecedor;
	}
	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public byte[] getImage() {
		return imagem;
	}
	public void setImage(byte[] image) {
		this.imagem = image;
	}
	
	
}
