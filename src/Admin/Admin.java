package Admin;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.border.TitledBorder;

import Controller.ControllerCadastro;
import Controller.ControllerAdmin;

import javax.swing.JButton;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfUsuario;
	private JPasswordField pfSenha;
	private JButton btnLimpar;
	private JPanel panel_1;
	private JTable tbListadados;
	private JButton btnEditar;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					Admin frame = new Admin();
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
	public Admin() {
		setTitle("Admin");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 733, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 24, 54, 41);
		contentPane.add(lblNewLabel);

		JLabel lblUsurio = new JLabel("Usu\u00E1rio");
		lblUsurio.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsurio.setBounds(13, 76, 74, 41);
		contentPane.add(lblUsurio);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblSenha.setBounds(13, 128, 74, 41);
		contentPane.add(lblSenha);

		tfId = new JTextField();
		tfId.setEditable(false);
		tfId.setColumns(10);
		tfId.setBounds(74, 36, 120, 30);
		contentPane.add(tfId);

		tfUsuario = new JTextField();
		tfUsuario.setEditable(false);
		tfUsuario.setColumns(10);
		tfUsuario.setBounds(86, 88, 195, 30);
		contentPane.add(tfUsuario);

		pfSenha = new JPasswordField();
		pfSenha.setEditable(false);
		pfSenha.setBounds(85, 140, 201, 30);
		contentPane.add(pfSenha);

		panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"A\u00E7\u00F5es", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(10, 322, 699, 164);
		contentPane.add(panel_1);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setEnabled(false);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {

					ControllerAdmin.limpadados(tfId, tfUsuario, pfSenha);
					btnLimpar.setEnabled(false);
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}

		});
		btnLimpar.setBounds(344, 25, 110, 35);
		panel_1.add(btnLimpar);
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JButton btnListar = new JButton("Listar Dados");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ControllerAdmin.ListarDados(tbListadados);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnListar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnListar.setBounds(10, 25, 204, 35);
		panel_1.add(btnListar);
		
		btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					
					ControllerAdmin.AlteraDados( tfId, tfUsuario, pfSenha, btnLimpar, btnDelete);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnEditar.setBounds(224, 25, 110, 35);
		panel_1.add(btnEditar);
		
		btnDelete = new JButton("Delete");
		btnDelete.setEnabled(false);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					ControllerAdmin.DeleteDados(tfId, tfUsuario, pfSenha);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setBounds(468, 25, 110, 35);
		panel_1.add(btnDelete);
		
		JScrollPane tbDados = new JScrollPane();
		tbDados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
			}
		});
		tbDados.setBounds(10, 180, 699, 143);
		contentPane.add(tbDados);
		
		tbListadados = new JTable();
		tbListadados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					ControllerAdmin.SelecionaDados(tbListadados,tfId, tfUsuario, pfSenha);
					
					tfUsuario.setEditable(true);
					pfSenha.setEditable(true);
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		tbListadados.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Id", "Usu\u00E1rio", "Senha"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tbDados.setViewportView(tbListadados);
	}
}