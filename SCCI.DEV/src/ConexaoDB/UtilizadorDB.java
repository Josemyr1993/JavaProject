package ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DTO.UtilizadorDTO;

public class UtilizadorDB {
	
	// Antes de iniciar o método, declaramos uma variável global
	Connection con;
	
	public ResultSet autenticacaoUtilizador(UtilizadorDTO objutilizadorDTO) {
		con = new ConexaoDB().conectaBD();
		
		
		
		try {
					
			String sql = "select*from utilizadores where utilizador=? and password=?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, objutilizadorDTO.getNome());
			ps.setString(2, objutilizadorDTO.getPassword());
			
			ResultSet rs = ps.executeQuery();
			return rs;
			
		} catch (Exception erro) {
			JOptionPane.showMessageDialog(null, "UtilizadorDB: " + erro);
			return null;
		}
		
		
	}
	
}
