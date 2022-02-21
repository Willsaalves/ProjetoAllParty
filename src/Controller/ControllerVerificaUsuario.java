package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Admin.Admin;
import Conexao.Conexao;
import EnviarGmail.EnviarEmail;
import EnviarGmail.EnviarEmailSenha;
import Login.Login;

public class ControllerVerificaUsuario {

	public static void VerificaUsuarioController( JTextField tfId, JTextField tfUsuario, JTextField tfEmail) throws SQLException {

		Connection conec = Conexao.conexao();

		String sql = "select * from dados_senhas where usuario=?";
		String sql1 = "select * from dados_senhas where email=?";
		String sql2 = "select * from dados_senhas where id=?";
	

		PreparedStatement stmt = conec.prepareStatement(sql);
		PreparedStatement stmt1 = conec.prepareStatement(sql1);
		PreparedStatement stmt2 = conec.prepareStatement(sql2);
		
		
	
		stmt.setString(1, tfUsuario.getText());
		stmt1.setString(1, tfEmail.getText());
		stmt2.setString(1, tfId.getText());
		
		

		ResultSet rs = stmt.executeQuery();
	
		if (rs.next()) {
			try {
				tfEmail.setText(rs.getString(3));
				tfId.setText(rs.getString(1));
				EnviarEmailSenha.enviarGmail(tfId,tfEmail, tfUsuario);
				Login exibir = new Login();
				exibir.setVisible(true);
				
			} catch (Exception e) {
				
			}
		
			

		}
		stmt.close();
		conec.close();

	}

}
