package CadastroUsuario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.border.TitledBorder;

import Conexao.Conexao;
import Controller.ControllerCadastro;
import Login.Login;

import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Window.Type;
import javax.swing.JPasswordField;

public class CadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfUsuario;
	private JTextField tfNome;
	private JTextField tfSenha;
	private JButton btnCadastrar;
	private JTextField tfTelefone;
	private JTextField tfEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroUsuario frame = new CadastroUsuario();
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
	public CadastroUsuario() {
		setFont(new Font("Dialog", Font.PLAIN, 5));
		setResizable(false);
		setType(Type.UTILITY);
		setTitle("Cadastro");
		getContentPane().setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("Id");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(24, 26, 95, 37);
		getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Usuario");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(24, 91, 95, 37);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Senha");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_2.setBounds(24, 161, 95, 37);
		getContentPane().add(lblNewLabel_1_2);

		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfId.setBounds(106, 36, 130, 30);
		getContentPane().add(tfId);
		tfId.setColumns(10);

		tfUsuario = new JTextField();
		tfUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(106, 101, 240, 30);
		getContentPane().add(tfUsuario);

		tfSenha = new JTextField();
		tfSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		tfSenha.setColumns(10);
		tfSenha.setBounds(106, 164, 240, 30);
		getContentPane().add(tfSenha);

		JPanel panel = new JPanel();
		panel.setBounds(24, 261, 447, 87);
		getContentPane().add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("Salvar");
		btnNewButton.setBounds(10, 11, 126, 29);
		panel.add(btnNewButton);
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 411, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNome.setBounds(37, 11, 74, 41);
		contentPane.add(lblNome);

		JLabel lblTelefone = new JLabel("Telefone: ");
		lblTelefone.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTelefone.setBounds(26, 63, 95, 41);
		contentPane.add(lblTelefone);

		tfNome = new JTextField();
		tfNome.setBounds(110, 23, 195, 30);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(11, 182, 110, 35);
		contentPane.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (tfNome.getText().equals("") || tfTelefone.getText().equals("") || tfEmail.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Usuario ou senha em branco");
				} else {
					ControllerCadastro.CadastroController(tfNome, tfTelefone, tfEmail);
					Login exibir = new Login();
					exibir.setVisible(true);
					setVisible(false);
				}
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(110, 75, 195, 29);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email: ");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(26, 115, 95, 41);
		contentPane.add(lblEmail);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(110, 127, 195, 29);
		contentPane.add(tfEmail);

		/*
		*/

	}
}
