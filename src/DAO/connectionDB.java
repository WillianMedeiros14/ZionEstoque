package DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class connectionDB {
	public String status = "Não conectado...";
	
	public connectionDB() {
		this.getConnectionDB();
	}
	
	public java.sql.Connection getConnectionDB(){
		Connection connection = null;
		
		try {
			
			String ServerName = "localhost";
			String Porta = "3050";
			String MyDatabase = "C:/java/ZionEstoque/DBZion/ZION.fdb";
			String encoding = "encoding=UTF8";
			String Url = "jdbc:firebirdsql://" + ServerName + ":" + Porta + "/" + MyDatabase + "?" + encoding;
			
			String user = "SYSDBA";
			String senha = "masterkey";

			connection = DriverManager.getConnection(Url, user, senha);
		
			if (connection != null) {
				status = ("Status -> Connectado com sucesso!");
			}else {
				status = ("Status -> Não foi possível connectar!");
			}
			
			return connection;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
			throw new RuntimeException();
		}
	}
	
	public String statusConnection() {
		return this.status;
	}
	
	public boolean FecharConexao() {
		try {
			this.getConnectionDB().close();
			this.status = "Status -> Conexão Encerrada";
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
}

