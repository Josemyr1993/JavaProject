package ConexaoDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class ConexaoDB {
	
	public Connection conectaBD() {
		Connection con = null;
		
		try {
			// Armazenamos o conteúdo de conexão à base de dados na variável query
			String query = "jdbc:mysql://localhost:3306/scci_dev\",\"root\",\"#Programacao#";
			// Aqui chamamos o método DriverManager para usar a variável query, por meio da variável con que definimos acima como "null"
			con = DriverManager.getConnection(query);
		
		// SQLException class, Queremos que gere uma excepção do SQL, dados de erro advindos do Mysql
		} catch (SQLException erro) {
			// Em caso de haver um erro, irá ser retornado por meio desta linha
			JOptionPane.showMessageDialog(null, "ConexaopDB" + erro.getMessage());
		}
		return con;
	}
}
