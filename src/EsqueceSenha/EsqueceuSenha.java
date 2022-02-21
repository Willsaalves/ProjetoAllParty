package EsqueceSenha;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.ControllerVerificaUsuario;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class EsqueceuSenha extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsuario;
	private JTextField tfEmail;
	private JLabel lblId;
	private JTextField tfId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EsqueceuSenha frame = new EsqueceuSenha();
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
	public EsqueceuSenha() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(41, 57, 114, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmail.setBounds(41, 92, 114, 61);
		contentPane.add(lblEmail);
		
		tfUsuario = new JTextField();
		tfUsuario.setBounds(113, 64, 175, 28);
		contentPane.add(tfUsuario);
		tfUsuario.setColumns(10);
		
		tfEmail = new JTextField();
		tfEmail.setColumns(10);
		tfEmail.setBounds(113, 107, 175, 28);
		contentPane.add(tfEmail);
		
		JButton btnNovaSenha = new JButton("Nova Senha");
		btnNovaSenha.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ControllerVerificaUsuario.VerificaUsuarioController(tfId,tfUsuario, tfEmail);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNovaSenha.setBounds(41, 164, 114, 39);
		contentPane.add(btnNovaSenha);
		
		lblId = new JLabel("Id");
		lblId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblId.setBounds(78, 14, 25, 32);
		contentPane.add(lblId);
		
		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(113, 21, 58, 28);
		contentPane.add(tfId);
	}

}
