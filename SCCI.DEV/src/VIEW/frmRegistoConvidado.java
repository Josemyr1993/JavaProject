package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DTO.UtilizadorDTO;
import auth.RegistroForm;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;

public class frmRegistoConvidado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtUser;
	private JPasswordField txtPass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistoConvidado frame = new frmRegistoConvidado();
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
	public frmRegistoConvidado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setBounds(54, 134, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("email");
		lblNewLabel_1.setBounds(54, 187, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Utilizador");
		lblNewLabel_2.setBounds(54, 237, 63, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setBounds(54, 295, 63, 14);
		contentPane.add(lblNewLabel_3);
		
		txtNome = new JTextField();
		txtNome.setBounds(140, 131, 289, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(140, 184, 289, 20);
		contentPane.add(txtEmail);
		
		JLabel lblCadastrarseParaAceder = new JLabel("Cadastrar-se para aceder o SCAEI");
		lblCadastrarseParaAceder.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCadastrarseParaAceder.setBounds(163, 86, 234, 14);
		contentPane.add(lblCadastrarseParaAceder);
		
		txtUser = new JTextField();
		txtUser.setColumns(10);
		txtUser.setBounds(140, 234, 289, 20);
		contentPane.add(txtUser);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(140, 292, 288, 20);
		contentPane.add(txtPass);
		
		JLabel lblNewLabel_3_1 = new JLabel("Categoria");
		lblNewLabel_3_1.setBounds(54, 360, 63, 14);
		contentPane.add(lblNewLabel_3_1);
		
		final JRadioButton rbPalestrante = new JRadioButton("Palestrante");
		rbPalestrante.setBounds(140, 356, 109, 23);
		contentPane.add(rbPalestrante);
		
		final JRadioButton rbExpectador = new JRadioButton("Expectador");
		rbExpectador.setBounds(140, 383, 109, 23);
		contentPane.add(rbExpectador);
		
		final JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scci_dev","root","Programacao2023");
					String query="INSERT INTO convidados(nome_convidado,email_convidado,user_convidado,password_convidado,categoria_convidado) VALUES (?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					
					ps.setString(1, txtNome.getText());
					ps.setString(2, txtEmail.getText());
					ps.setString(3, txtUser.getText());
					ps.setString(4, txtPass.getText());
					if(rbPalestrante.isSelected())
						ps.setString(5, rbPalestrante.getText());
					else
						ps.setString(5, rbExpectador.getText());
					
					// Mostrar Informação de sucesso quando validado no botão
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(btnNewButton, i+" Informação inserida com sucesso!");
					
					// Para Fechar a conexão e ps
					ps.close();
					con.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(286, 438, 143, 23);
		contentPane.add(btnNewButton);
		
		JButton Logar = new JButton("Fazer Login");
		Logar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmLoginConvidado objloginconvidado = new frmLoginConvidado();
				objloginconvidado.setVisible(true);
				dispose();
			}
		});
		Logar.setFont(new Font("Tahoma", Font.BOLD, 13));
		Logar.setBounds(20, 18, 143, 23);
		contentPane.add(Logar);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(0, 0, 527, 58);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
