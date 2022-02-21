package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Admin.Admin;
import CadastroUsuario.CadastroUsuario;
import Conexao.Conexao;
import Controller.ControllerLogin;
import EsqueceSenha.EsqueceuSenha;
import GenerateQrCode.GenerateQrCodeTela;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(39, 54, 72, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(39, 106, 72, 34);
		contentPane.add(lblNewLabel_1);
		
		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUsuario.setBounds(121, 51, 136, 31);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		pfSenha = new JPasswordField();
		pfSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pfSenha.setBounds(121, 103, 136, 31);
		contentPane.add(pfSenha);
		
		JButton btnNewButton = new JButton("Admin");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControllerLogin.LoginController(tfUsuario, pfSenha);
				}  catch (SQLException e1) {
					e1.printStackTrace();
				} 
				
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.setBounds(319, 215, 107, 37);
		contentPane.add(btnNewButton);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ControllerLogin.qrCodeController(tfUsuario, pfSenha);
					Login exibir = new Login();
					setVisible(false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEntrar.setBounds(10, 172, 179, 37);
		contentPane.add(btnEntrar);
		
		JButton btnEsqueciASenha = new JButton("Esqueci a Senha");
		btnEsqueciASenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EsqueceuSenha exibir = new EsqueceuSenha();
				exibir.setVisible(true);
				
			}
		});
		btnEsqueciASenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEsqueciASenha.setBounds(10, 224, 179, 37);
		contentPane.add(btnEsqueciASenha);
	}
}
