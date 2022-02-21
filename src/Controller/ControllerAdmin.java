package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Conexao.Conexao;

public class ControllerAdmin {

	public static void limpadados(JTextField tfId, JTextField tfUsuario, JPasswordField pfSenha) {

		tfId.setText((""));

		tfUsuario.setText("");
		pfSenha.setText("");

	}

	public static void ListarDados(JTable tbListadados) throws SQLException {

		Connection conec = Conexao.conexao();
		String sql = "Select * from dados_senhas";

		PreparedStatement stmt = conec.prepareStatement(sql);

		ResultSet rs = stmt.executeQuery();

		DefaultTableModel modelo = (DefaultTableModel) tbListadados.getModel();
		modelo.setNumRows(0);
		while (rs.next()) {
			modelo.addRow(new Object[] { rs.getString("id"), rs.getString("usuario"), rs.getString("Senha") });

		}
		rs.close();
		conec.close();
	}

	public static void SelecionaDados(JTable tbListadados, JTextField tfId, JTextField tfUsuario,
			JPasswordField pfSenha) throws SQLException {

		tfId.setText(tbListadados.getValueAt(tbListadados.getSelectedRow(), 0).toString());
		tfUsuario.setText(tbListadados.getValueAt(tbListadados.getSelectedRow(), 1).toString());
		pfSenha.setText(tbListadados.getValueAt(tbListadados.getSelectedRow(), 2).toString());
	}

	public static void AlteraDados(JTextField tfId, JTextField tfUsuario, JPasswordField pfSenha,JButton btnLimpar, JButton btnDelete) throws SQLException {

		if (tfId.getText().equals("") || tfId.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "Liste os dados e depois selecione uma linha");
		}
		else {

		Connection conec = Conexao.conexao();

		String sql = "update dados_senhas set usuario=?, senha=? where id=?";

		PreparedStatement stmt = conec.prepareStatement(sql);

		stmt.setString(1, tfUsuario.getText());
		stmt.setString(2, new String(pfSenha.getPassword()));
		stmt.setString(3, tfId.getText());

		stmt.execute();
 
		stmt.close();

		conec.close();

		JOptionPane.showMessageDialog(null, "alterou usuario ou senha");
		
		btnLimpar.setEnabled(true);
		btnDelete.setEnabled(true);
		}
	}

	public static void DeleteDados(JTextField tfId, JTextField tfUsuario, JPasswordField pfSenha) throws SQLException {

		if (tfId.getText().equals("") || tfId.getText().equals("")) {

			JOptionPane.showMessageDialog(null, "selecione uma linha");
		} else {
			
			Connection conec = Conexao.conexao();

			String sql = "delete from dados_senhas where id=? and usuario=?";
			
			
			PreparedStatement stmt = conec.prepareStatement(sql);
		

			stmt.setString(1, tfId.getText());
			stmt.setString(2, tfUsuario.getText());
			
			JOptionPane.showMessageDialog(null, "Deletou usuario");
		
			stmt.execute();

			stmt.close();

			conec.close();

	
		}

	}
}
