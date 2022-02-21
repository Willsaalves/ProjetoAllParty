package Conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexao {
	

	
	public static Connection conexao() throws SQLException{
	

		try {
			
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/db_senhas?useSSL=false&useTimezone=true&serverTimezone=UTC","root","1234");

			
		} catch (ClassNotFoundException e) {
			
			throw new SQLException(e.getException());
	
	}

}
}
