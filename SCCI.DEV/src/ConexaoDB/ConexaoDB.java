package ConexaoDB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class ConexaoDB {
	
	
	public Connection conectaBD() {
		// Iremos usar essa variável no processo de uso da variável query
		// Connection - é um objecto do SQL que irá nos permitir a criação do tipo de dada variável, nesse caso será do tipo Connection
		
		Connection con = null;
		try {
			// Armazenamos o conteúdo de conexão à base de dados na variável query
			String query = "jdbc:mysql://localhost:3306/scci_dev?user=root&password=Programacao2023";
			// Aqui chamamos o método DriverManager para usar a variável query, por meio da variável con que definimos acima como "null"
			con = DriverManager.getConnection(query);
			return con;
		
		// SQLException class, Queremos que gere uma excepção do SQL, dados de erro advindos do Mysql
		} catch (Exception erro) {
			// Em caso de haver um erro, irá ser retornado por meio desta linha
			JOptionPane.showMessageDialog(null, "ConexaopDB" + erro.getMessage());
		}
		return con;	
	}


}
