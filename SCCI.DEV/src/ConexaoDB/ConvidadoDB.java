package ConexaoDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import DTO.UtilizadorDTO;
import DTO.ConvidadoDTO;

public class ConvidadoDB {
	// Antes de iniciar o método, declaramos uma variável global
		// Att que esta é a mesma variável usada no processo de criação de conexão à DB
		Connection con;
		
		public ResultSet autenticacaoConvidado(ConvidadoDTO objconvidadoDTO) {
			con = new ConexaoDB().conectaBD();
			
			try {
				
				// Convertemos a query em String
				String sql = "select user_convidado,password_convidado,categoria_convidado from convidados where user_convidado=? and password_convidado=?";
				
				PreparedStatement ps = con.prepareStatement(sql);
				
				// O banco de dados irá pesquisar o dados conforme as Strings aqui definidas, ou seja pelos dados inseridos no formulário
				// chamará o ResultSet que irá fazer um loop de buscas no banco de dados em função do metodo definido autenticacaoConvidado em função do argumento que é a classe ConvidadoDTO
				ps.setString(1, objconvidadoDTO.getUtilizador());
				ps.setString(2, objconvidadoDTO.getPassword());
				//ps.setString(3,objconvidadoDTO.getCategoria());
				
				// Será executada a query "sql"
				ResultSet rs = ps.executeQuery();
				return rs;
				
			} catch (Exception erro) {
				JOptionPane.showMessageDialog(null, "ConvidadoDB: " + erro);
				return null;
			}
			
			
		}
}
