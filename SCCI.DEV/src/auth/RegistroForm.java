package auth;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.Choice;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTree;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

public class RegistroForm extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtUtilizador;
	private JTextField txtEmail;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistroForm frame = new RegistroForm();
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
	public RegistroForm() {
		setBackground(SystemColor.desktop);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\jsebastiao1\\Desktop\\JavaProject\\JavaProject\\Images\\user.png"));
		setTitle("Formulario de Cadastro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 546);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(new Color(102, 153, 204));
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(33, 122, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Utilizador:");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(33, 195, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("Email:");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(256, 122, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_4.setBounds(256, 195, 65, 14);
		contentPane.add(lblNewLabel_4);
		
		JList list = new JList();
		list.setBounds(180, 56, 1, 1);
		contentPane.add(list);
		
		txtNome = new JTextField();
		txtNome.setBorder(null);
		txtNome.setBounds(33, 147, 157, 25);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtUtilizador = new JTextField();
		txtUtilizador.setBorder(null);
		txtUtilizador.setBounds(33, 217, 157, 25);
		contentPane.add(txtUtilizador);
		txtUtilizador.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setBounds(256, 147, 145, 25);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Categoria:");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_2.setBounds(33, 264, 65, 18);
		contentPane.add(lblNewLabel_2);
		
		final JRadioButton rbAdmin = new JRadioButton("Admin"); // Fixed by advisor
		rbAdmin.setForeground(new Color(255, 255, 255));
		rbAdmin.setBackground(new Color(102, 153, 204));
		buttonGroup.add(rbAdmin);
		rbAdmin.setBounds(33, 289, 109, 23);
		contentPane.add(rbAdmin);
		
		
		final JRadioButton rbEndUser = new JRadioButton("EndUser");    // Fixed by advisor
		rbEndUser.setForeground(new Color(255, 255, 255));
		rbEndUser.setBackground(new Color(102, 153, 204));
		buttonGroup.add(rbEndUser);
		rbEndUser.setBounds(33, 311, 109, 23);
		contentPane.add(rbEndUser);
		
		txtPassword = new JPasswordField();
		txtPassword.setBorder(null);
		txtPassword.setBounds(256, 218, 145, 23);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel_5 = new JLabel("Registro de Utilizador");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_5.setBounds(144, 23, 157, 45);
		contentPane.add(lblNewLabel_5);
		
		// Ações para o botão "Validar" - Na verdade irá ser o gatilho para inserir dados à nossa base de dados, dados esses que serão inseridos no formulário
		final JButton btnValidar = new JButton("Validar");  // Fixed by  advisor
		btnValidar.setBorder(null);
		btnValidar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scci_dev","root","#Programacao#");
					String query="INSERT INTO utilizadores(nome,email,utilizador,password,categoria) VALUES (?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(query);
					ps.setString(1, txtNome.getText());
					ps.setString(2, txtEmail.getText());
					ps.setString(3, txtUtilizador.getText());
					ps.setString(4, txtPassword.getText());
					if(rbAdmin.isSelected())
						ps.setString(5, rbAdmin.getText());
					else
						ps.setString(5, rbEndUser.getText());
					
					// Mostrar Informação de sucesso quando validado no botão
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(btnValidar, i+" Informação inserida com sucesso!");
					
					// Para Fechar a conexão e ps
					ps.close();
					con.close();
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnValidar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnValidar.setBackground(new Color(212, 212, 212));
		btnValidar.setForeground(new Color(0, 0, 0));
		btnValidar.setBounds(256, 439, 89, 23);
		contentPane.add(btnValidar);
		
		// Ações para o botão "Reset" - para quando for inserido algum dado inesperado no formulário
		JButton btnReset = new JButton("Reset");
		btnReset.setBorder(null);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtEmail.setText("");
				txtUtilizador.setText("");
				txtPassword.setText("");
				buttonGroup.clearSelection();
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnReset.setBackground(new Color(214, 214, 214));
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.setBounds(406, 439, 89, 23);
		contentPane.add(btnReset);
	}
}
