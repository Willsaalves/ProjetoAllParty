package GenerateQrCode;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import Controller.ControllerQrCode;
import EnviarGmail.EnviarEmail;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class GenerateQrCodeTela extends JFrame {

	private JPanel contentPane;
	private JTextField tfQtd;
	private JTextField tfId;
	public JComboBox cbCurso = new JComboBox();
	public JComboBox cbFaculdade = new JComboBox();
	public JComboBox cbFormando = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GenerateQrCodeTela frame = new GenerateQrCodeTela();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}

		});
	}

	/**
	 * Create the frame.
	 */
	public GenerateQrCodeTela() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 907, 507);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Gerar QrCode");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				 try {
					ControllerQrCode.GerarQr(tfQtd, cbCurso,cbFaculdade,cbFormando);
				} catch (WriterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
			}
			});

		btnNewButton.setBounds(514, 405, 154, 54);
		contentPane.add(btnNewButton);

		JButton btnEnviarEmail = new JButton("Enviar Email");
		btnEnviarEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEnviarEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				EnviarEmail.enviarGmail(null);
			}
		});
		btnEnviarEmail.setBounds(350, 405, 154, 54);
		contentPane.add(btnEnviarEmail);

		JLabel lblQuantidadeDeConvites = new JLabel("Quantidade De Convites");
		lblQuantidadeDeConvites.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblQuantidadeDeConvites.setBounds(10, 25, 190, 65);
		contentPane.add(lblQuantidadeDeConvites);

		tfQtd = new JTextField();
		tfQtd.setBounds(195, 39, 55, 41);
		contentPane.add(tfQtd);
		tfQtd.setColumns(10);

		JLabel lblSelecioneOFormando = new JLabel("Selecione o formando: ");
		lblSelecioneOFormando.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelecioneOFormando.setBounds(10, 101, 190, 65);
		contentPane.add(lblSelecioneOFormando);

		JComboBox cbFormando = new JComboBox();
		cbFormando.setBounds(204, 124, 190, 33);
		contentPane.add(cbFormando);

		JLabel lblSelecioneOCurso = new JLabel("Selecione o curso: ");
		lblSelecioneOCurso.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelecioneOCurso.setBounds(10, 189, 190, 65);
		contentPane.add(lblSelecioneOCurso);

		JComboBox cbCurso = new JComboBox();
		cbCurso.setBounds(204, 212, 190, 33);
		contentPane.add(cbCurso);

		JLabel lblSelecioneOFormando_1_1 = new JLabel("Selecione a faculade: ");
		lblSelecioneOFormando_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelecioneOFormando_1_1.setBounds(10, 266, 190, 65);
		contentPane.add(lblSelecioneOFormando_1_1);

		JComboBox cbFaculdade = new JComboBox();
		cbFaculdade.addAncestorListener(new AncestorListener() {
			public void ancestorAdded(AncestorEvent event) {

			}

			public void ancestorMoved(AncestorEvent event) {
			}

			public void ancestorRemoved(AncestorEvent event) {
			}
		});
		cbFaculdade.setBounds(204, 289, 190, 33);
		contentPane.add(cbFaculdade);

		JButton btnCarregar = new JButton("Carregar Informa\u00E7\u00F5es");
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControllerCarregacb.Carregacb(cbCurso,cbFormando,cbFormando);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCarregar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCarregar.setBounds(678, 405, 190, 54);
		contentPane.add(btnCarregar);

		JLabel lblId = new JLabel("id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(652, 44, 55, 54);
		contentPane.add(lblId);

		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setEnabled(false);
		tfId.setColumns(10);
		tfId.setBounds(678, 49, 55, 41);
		contentPane.add(tfId);
		
	}
}