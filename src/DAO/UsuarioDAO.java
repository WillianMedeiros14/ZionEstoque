package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.UsuarioDTO;

public class UsuarioDAO {
	Connection conn;
	
	public ResultSet autenticacacoUsuario(UsuarioDTO objUsuario) {
		conn = new connectionDB().getConnectionDB();
		
		try {
			String sql = "select * from usuario where usuario_login = ? and senha = ?";
			
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, objUsuario.getUsuario_login());
			pstm.setString(2, objUsuario.getSenha());
			
			ResultSet res = pstm.executeQuery();
			
			return res;
			
		}catch(SQLException error) {
			JOptionPane.showMessageDialog(null, "UsuarioDAO: " + error);
			return null;
		}
	}
}
