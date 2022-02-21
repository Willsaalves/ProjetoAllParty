package Controller;

import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Conexao.Conexao;
import GenerateQrCode.GenerateQrCodeTela;

public class ControllerCarregacb extends GenerateQrCodeTela {

	
	public static void Carregacb(JComboBox cbFormando,JComboBox cbCurso, JComboBox cbFaculdade) throws SQLException {
		
		GenerateQrCodeTela Gr = new GenerateQrCodeTela();

		Connection conec = Conexao.conexao();
		String sql = "Select * from carregacb";

		PreparedStatement stmt = conec.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
	

		while (rs.next()) {
		
			String id = rs.getString("faculdade");
			String id1 = rs.getString("nome");
			String id2 = rs.getString("curso");
			
			
			System.out.println(id);

			System.out.println(id1);
			System.out.println(id2);
			
			
			cbFaculdade.addItem(rs.getString("faculdade"));
			cbFormando.addItem(rs.getString("nome"));
			cbCurso.addItem(rs.getString("curso"));

		}
		conec.close();
		

		
	}
}
