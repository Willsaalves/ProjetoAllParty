package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Admin.Admin;
import CadastroUsuario.CadastroUsuario;
import Conexao.Conexao;
import GenerateQrCode.GenerateQrCodeTela;

public class ControllerLogin {

	public static void LoginController(JTextField tfUsuario, JPasswordField pfSenha) throws SQLException {

		Connection conec = Conexao.conexao();

		String sql = "select * from dados_senhas where id = 1 and usuario=? and senha=?";

		String sql1 = "select * from dados_senhas where id<>1";

		PreparedStatement stmt = conec.prepareStatement(sql);
		PreparedStatement stmt1 = conec.prepareStatement(sql1);

		stmt.setString(1, tfUsuario.getText());
		stmt.setString(2, new String(pfSenha.getPassword()));

		ResultSet rs = stmt.executeQuery();
		ResultSet rt = stmt1.executeQuery();

		if (rs.next()) {
			Admin exibir = new Admin();
			exibir.setVisible(true);

		} else if (rt.next()) {
			JOptionPane.showMessageDialog(null, "Usuario não permitido");
		}

		else {
			JOptionPane.showMessageDialog(null, "Usuario não existe");
		}
		stmt.close();
		stmt1.close();
		conec.close();

	}

	public static void qrCodeController(JTextField tfUsuario, JPasswordField pfSenha) throws SQLException {

		Connection conec = Conexao.conexao();

		String sql = "select * from dados_senhas where id = 1 and usuario=? and senha=?";
		// String sql1 = "select * from dados_senhas where id = 1 and usuario=? and
		// senha=?";

		PreparedStatement stmt = conec.prepareStatement(sql);

		stmt.setString(1, tfUsuario.getText());
		stmt.setString(2, new String(pfSenha.getPassword()));

		ResultSet rs = stmt.executeQuery();
		// ResultSet rs1 = stmt.executeQuery();

		if (rs.next()) {
			GenerateQrCodeTela exibir = new GenerateQrCodeTela();
			exibir.setVisible(true);
		} else if (tfUsuario.getText().equals("") || pfSenha.getPassword().equals("")) {
			JOptionPane.showMessageDialog(null, "Senha ou usuario em branco!");
		}

		else {
			JOptionPane.showMessageDialog(null, "Usuario não cadastrado, contate o administrador!");
		}
//		rs.close();
		conec.close();

	}

	public static void CadastroAluno(JTextField tfUsuario, JPasswordField pfSenha) throws SQLException {

		Connection conec = Conexao.conexao();

		String sql = "select * from dados_senhas where usuario=? and senha=?";

		PreparedStatement stmt = conec.prepareStatement(sql);

		stmt.setString(1, tfUsuario.getText());
		stmt.setString(2, new String(pfSenha.getPassword()));

		ResultSet rs = stmt.executeQuery();

		if (rs.next()) {
			CadastroUsuario exibir = new CadastroUsuario();
			exibir.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(null, "Usuario não existe, fale com o administrador");
		}
		stmt.close();
		conec.close();

	}
}
