package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Conexao.Conexao;
import Login.Login;

public class ControllerCadastro {
	
		public static void CadastroController(JTextField tfNome, JTextField tfTelefone, JTextField tfEmail) {
			
			
			try {
				Connection conec = Conexao.conexao();
	
				String sql = "insert into alunos ( Nome, Telefone, email) values(?,?,?) ";
	
				PreparedStatement stmt = conec.prepareStatement(sql);
	
				stmt.setString(1, tfNome.getText());
				stmt.setString(2, new String(tfTelefone.getText()));
				stmt.setString(3, tfEmail.getText());
	
				stmt.execute();
	
				stmt.close();
	
				conec.close();
	
				JOptionPane.showMessageDialog(null, "Cadastrou novo aluno");
	
			} catch (SQLException e1) {
				// TODO: handle exception
	
				e1.printStackTrace();
			}
	
		}
	}

