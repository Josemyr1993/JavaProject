package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexaoDB.ConvidadoDB;
import ConexaoDB.UtilizadorDB;
import DTO.ConvidadoDTO;
import DTO.UtilizadorDTO;
import auth.RegistroForm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JSeparator;

public class frmLoginConvidado extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPass;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JSeparator separator_2;
	private JSeparator separator_3;
	private JLabel lblNewLabel_4;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoginConvidado frame = new frmLoginConvidado();
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
	public frmLoginConvidado() {
		setTitle("Formulário de Login  Convidados");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 637);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(206, 206, 206));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Utilizador");
		lblNewLabel.setBounds(117, 230, 83, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(117, 290, 70, 14);
		contentPane.add(lblNewLabel_1);
		
		txtUser = new JTextField();
		txtUser.setBounds(210, 227, 178, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JPasswordField();
		txtPass.setBounds(210, 287, 178, 20);
		contentPane.add(txtPass);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Variáveis importadas da classe ConvidadoDTO
					String Nome; 
					String Password;
					String Categoria;
					String utilizador;
					String email;
					
					//Criação atribuimos às variáveis os métodos getText que irão receber os dados que o usuário inserir
					utilizador = txtUser.getText();
					Password = txtPass.getText();
					
					// Passando as variáveis recebidas para o DTO - diretório de transferência de objectos
					// Primeiro precisamos instanciar a class relativa ao DTO que é UtilizadorDTO para permitir a criação de novos objectos
					// Usamos o Construtor "new" para criação do novo objeto "objutilizadordto"
					ConvidadoDTO objconvidadodto = new ConvidadoDTO();
					
					// Esses novos objetos serão usados dentro da classe ConvidadoDB a fim de 
					objconvidadodto.setUtilizador(utilizador);
					objconvidadodto.setPassword(Password);
					//objconvidadodto.setCategoria(Categoria);
					
					
					ConvidadoDB objconvidadodb = new ConvidadoDB();
				
					ResultSet rsconvidadodb = objconvidadodb.autenticacaoConvidado(objconvidadodto);
									
					if (rsconvidadodb.next()) {
						
						// se o vetor encontrar uma fila na tabela ou conseguir buscar 1 resultado no banco de dados teremos aqui a ação definida neste bloco
						// Chamar tela que eu quero abrir --- Aqui também pretendemos adicionar role para que se for utilizador admin ou enduser
						String u = rsconvidadodb.getString("user_convidado");
						String p = rsconvidadodb.getString("password_convidado");
						String c = rsconvidadodb.getString("categoria_convidado");
						
						if (Password.equals(p)) {
							// Vamos à JFrame Palestrante ou Expectador dependendo da categoria
							// Aqui separamos os utilizadores por roles
							if (c.equals("Expectador")) {
								frmViewExpectador objfrmviewexpectador = new frmViewExpectador();
								objfrmviewexpectador.setVisible(true);
							} else if(c.equals("Palestrante")){
								frmViewConvidado objfrmviewconvidado = new frmViewConvidado();
								objfrmviewconvidado.setVisible(true);
							}
						}
						
						dispose();
					} else {
						// Caso o resultado não for encontrado no banco de dados, Enviar mensagem 
						JOptionPane.showMessageDialog(null, "Usuário ou Senha Inválida");
					}
					
				} catch (SQLException erro) {
					JOptionPane.showMessageDialog(null, "FRMLOGINVIEW" + erro);
				}
			}
		});
		btnNewButton.setBounds(210, 357, 178, 23);
		contentPane.add(btnNewButton);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\jsebastiao1\\Desktop\\JavaProject\\JavaProject\\Images\\footer2-0.png"));
		lblNewLabel_2.setBounds(236, 11, 127, 140);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Login ISAF");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(265, 150, 98, 23);
		contentPane.add(lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(117, 449, 127, -6);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBackground(new Color(0, 0, 0));
		separator_1.setBounds(290, 302, 91, 2);
		contentPane.add(separator_1);
		
		separator_2 = new JSeparator();
		separator_2.setBounds(104, 411, 154, 2);
		contentPane.add(separator_2);
		
		separator_3 = new JSeparator();
		separator_3.setBounds(338, 411, 117, 2);
		contentPane.add(separator_3);
		
		lblNewLabel_4 = new JLabel("OU");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_4.setBounds(290, 399, 30, 28);
		contentPane.add(lblNewLabel_4);
		
		btnNewButton_1 = new JButton("Efetuar Cadastro");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmRegistoConvidado objregistoconv = new frmRegistoConvidado();
				objregistoconv.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(210, 449, 178, 23);
		contentPane.add(btnNewButton_1);
	}
}
