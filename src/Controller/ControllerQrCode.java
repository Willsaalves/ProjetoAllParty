package Controller;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import Conexao.Conexao;

import Controller.ControllerCarregacb;



public class ControllerQrCode {
	
	


	// gera um código aleatorio para o qrcode do cliente
	public static String GerarCodigoQRcode() {

		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f", "g", "h",
				"i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "A", "B", "C",
				"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X",
				"Y", "Z" };

		String qrcode = "";

		for (int x = 0; x < 3; x++) {
			int j = (int) (Math.random() * carct.length);
			qrcode += carct[j];
		}
		return qrcode;
	}

	// gera o código aleatorio para salvar na pasta com qr code

	public static String GerarCodigoQR() {

		String[] carct = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9" };

		String qrcode1 = "";

		for (int x = 0; x < 2; x++) {
			int j = (int) (Math.random() * carct.length);
			qrcode1 += carct[j];
		}
		return qrcode1;
	}
	


	public static String GerarQrcode(JComboBox cbFormando, JComboBox cbCurso, JComboBox cbFaculdade ) throws WriterException, IOException, SQLException {


		//String CarregaCurso = (String) cbCurso.getSelectedItem();
		
		System.out.println(cbCurso);
		System.out.println("\n");
		//System.out.println(CarregaCurso);
		//String CarregaFaculdade = (String)cbFaculdade.getSelectedItem();
		//String CarregaFormando = (String)cbFormando.getSelectedItem();
		

		String qrcode = GerarCodigoQR();

			String qrCodeData = GerarCodigoQRcode();

			String filePath = "C:\\QRCODE\\'aaaa'"+cbCurso+"''"+qrcode+"'.png";
		
			String charset = "UTF-8"; // or "ISO-8859-1"
	
			Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
		
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		
			BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
					BarcodeFormat.QR_CODE, 200, 200, hintMap);
	
			MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));
	
			return null;

		}
		
	

		// try {
		/*String qrCodeData = GerarCodigoQRcode();
		String filePath = "C:\\QRCODE\\canva'" + qrcode + "'.png";
		String charset = "UTF-8"; // or "ISO-8859-1"
		Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		BitMatrix matrix = new MultiFormatWriter().encode(new String(qrCodeData.getBytes(charset), charset),
				BarcodeFormat.QR_CODE, 200, 200, hintMap);
		MatrixToImageWriter.writeToFile(matrix, filePath.substring(filePath.lastIndexOf('.') + 1), new File(filePath));

		JOptionPane.showMessageDialog(null, "QrCode Gerado com sucesso!");

		Connection conec = Conexao.conexao();

		x++;*/
		// stmt.execute();
		// stmt.executeUpdate();
	// catch (Exception e1) {
		// System.err.println(e1);
	

	public static void GerarQr(JTextField tfQtd, JComboBox cbFaculdade, JComboBox cbFormando, JComboBox cbCurso) throws WriterException, IOException, SQLException {

		int x = 1;
		
		int valor = Integer.parseInt(tfQtd.getText());

		String qrcode = GerarCodigoQR();

		while (x <= valor) {
	
			GerarQrcode(cbFormando, cbCurso, cbFaculdade);
			x++;
	}
		JOptionPane.showMessageDialog(null, "QrCode Gerado com sucesso!");

	}
}
