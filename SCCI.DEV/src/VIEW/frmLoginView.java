package VIEW;

import DTO.UtilizadorDTO;  // Classe Importada
import auth.RegistroForm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

import ConexaoDB.UtilizadorDB;
import DTO.UtilizadorDTO;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.ButtonGroup;

public class frmLoginView extends JFrame {
	private JTextField txtNome;
	private JPasswordField txtPassword;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginView frame = new frmLoginView();
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
	public frmLoginView() {
		getContentPane().setBackground(new Color(215, 215, 215));
		setBounds(100, 100, 589, 635);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel.setBounds(189, 258, 46, 14);
		getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setMargin(new Insets(5, 5, 5, 5));
		txtNome.setBorder(new LineBorder(new Color(255, 255, 255), 7, true));
		txtNome.setBounds(189, 283, 180, 26);
		getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel1 = new JLabel("Password");
		lblNewLabel1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel1.setBounds(189, 320, 61, 14);
		getContentPane().add(lblNewLabel1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(new LineBorder(new Color(255, 255, 255), 7, true));
		txtPassword.setBounds(189, 345, 180, 26);
		getContentPane().add(txtPassword);
		
		lblNewLabel_2 = new JLabel("ISAF - Login");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\jsebastiao1\\Desktop\\JavaProject\\JavaProject\\Images\\footer2-0.png"));
		lblNewLabel_2.setBounds(211, 11, 129, 140);
		getContentPane().add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("ISAF - Login");
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNewLabel_3.setBounds(221, 156, 109, 26);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1 = new JLabel("OU ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(262, 469, 50, 26);
		getContentPane().add(lblNewLabel_1);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(140, 481, 115, 2);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(293, 481, 135, 2);
		getContentPane().add(separator_1);
		
		JButton btnLogin = new JButton("Acessar");
		buttonGroup.add(btnLogin);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.setForeground(new Color(255, 255, 255));
		btnLogin.setBackground(new Color(155, 155, 155));
		btnLogin.setBorder(null);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Aqui declaramos as variáveis que serão recebidas do usuário e passará para a DTO;
				// Quais as informações que pegaremos do usuário? O Nome e a Senha;
				try {
					
					String Nome;
					String Password;
					
					Nome = txtNome.getText();
					Password = txtPassword.getText();
					
					// Passando as variáveis para o DTO diretório de transferência de objectos
					// Primeiro precisamos instanciar a class relativa ao DTO que é UtilizadorDTO para permitir a criação de novos objectos
					// Usamos o Construtor "new" para criação do novo objeto "objutilizadordto"
					UtilizadorDTO objutilizadordto = new UtilizadorDTO();
					
					objutilizadordto.setNome(Nome);
					objutilizadordto.setPassword(Password);
					
					UtilizadorDB objutilizadordb = new UtilizadorDB();
					
					ResultSet rsutilizadordb = objutilizadordb.autenticacaoUtilizador(objutilizadordto);
									
					if (rsutilizadordb.next()) {
						// Chamar tela que eu quero abrir --- Aqui também pretendemos adicionar role para que se for utilizador admin ou enduser
						
						frmViewPrincipal objfrmviewprincipal = new frmViewPrincipal();
						objfrmviewprincipal.setVisible(true);
						dispose();
					} else {
						// Enviar mensagem dizendo que está incorreto
						JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválida");
					}
					
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "FRMLOGINVIEW" + erro);
				}
				
				// Configuração da Conexão à DB para validação de se o usuário existe ou não, se sim, avança e se não chama uma tela de erro
				
				
			}
		});
		btnLogin.setBounds(189, 404, 180, 26);
		getContentPane().add(btnLogin);
		
		JButton btnNovoCadastro = new JButton("Novo Cadastro");
		btnNovoCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Linkar à tela de cadastro
				RegistroForm objregistroform = new RegistroForm();
				objregistroform.setVisible(true);
				dispose();
			}
		});
		buttonGroup_1.add(btnNovoCadastro);
		btnNovoCadastro.setForeground(Color.WHITE);
		btnNovoCadastro.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNovoCadastro.setBorder(null);
		btnNovoCadastro.setBackground(new Color(155, 155, 155));
		btnNovoCadastro.setBounds(189, 528, 180, 26);
		getContentPane().add(btnNovoCadastro);

	}
}
