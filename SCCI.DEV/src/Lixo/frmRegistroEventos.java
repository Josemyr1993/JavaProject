package Lixo;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DebugGraphics;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.TitledBorder;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.text.JTextComponent;

import com.jgoodies.forms.debug.FormDebugPanel;

import ConexaoDB.ConexaoDB;
import auth.RegistroForm;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class frmRegistroEventos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField txtnome;
	private JTextField txtdataevento;
	private JTextField txttipoevento;
	private JTextField txtlocal;
	private JTextField txtprelector;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmRegistroEventos frame = new frmRegistroEventos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	/**public void table_load() {
		try {
			Connection con;
			con = new ConexaoDB().conectaBD();
			
			PreparedStatement pst;
			ResultSet rs;
			
			pst = con.prepareStatement("select * from eventos");
			rs = pst.executeQuery();
			table.setModel (DbUtils.resultSetToTableModel(rs));
			
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}**/
	
	PreparedStatement pst;
	ResultSet rs;
	
	/**
	public Connection conectaBD() {
		// Iremos usar essa variável no processo de uso da variável query
		// Connection - é um objecto do SQL que irá nos permitir a criação do tipo de dada variável, nesse caso será do tipo Connection
		
		Connection con = null;
		try {
			// Armazenamos o conteúdo de conexão à base de dados na variável query
			String query = "jdbc:mysql://localhost:3306/scci_dev?user=root&password=Programacao2023";
			// Aqui chamamos o método DriverManager para usar a variável query, por meio da variável con que definimos acima como "null"
			con = DriverManager.getConnection(query);
			return con;
		
		// SQLException class, Queremos que gere uma excepção do SQL, dados de erro advindos do Mysql
		} catch (Exception erro) {
			// Em caso de haver um erro, irá ser retornado por meio desta linha
			JOptionPane.showMessageDialog(null, "ConexaopDB" + erro.getMessage());
		}
		return con;	
	}
	 * @return **/
	
	

	/**
	 * Create the frame.
	 */
	public frmRegistroEventos() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 789, 729);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(636, 11, 127, 132);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\jsebastiao1\\Desktop\\JavaProject\\JavaProject\\Images\\footer2-0.png"));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Gestão de Eventos do ISAF - Área do Gestor");
		lblNewLabel.setBounds(10, 11, 442, 35);
		lblNewLabel.setForeground(new Color(121, 121, 121));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Utilizador:");
		lblNewLabel_2.setBounds(10, 46, 91, 17);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(0, 0, 1191, 78);
		textField.setBackground(new Color(255, 255, 255));
		textField.setEditable(false);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Visualizar Eventos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ShowTable objshowtable = new ShowTable();
				objshowtable.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(10, 192, 144, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Cadastrar Grupo");
		btnNewButton_2.setBounds(10, 158, 144, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Cadastrar Usuário");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegistroForm objregistoutilizador = new RegistroForm();
				objregistoutilizador.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(10, 124, 144, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_3 = new JLabel("Menu");
		lblNewLabel_3.setBounds(58, 90, 48, 23);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(0, 74, 161, 616);
		textField_1.setEditable(false);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Nome Evento:");
		lblNewLabel_5.setBounds(201, 169, 108, 14);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Tipo Evento:");
		lblNewLabel_6.setBounds(201, 303, 89, 14);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Local Evento:");
		lblNewLabel_7.setBounds(201, 212, 108, 14);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Data Evento:");
		lblNewLabel_8.setBounds(201, 347, 84, 14);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_8);
		
		txtnome = new JTextField();
		txtnome.setBounds(317, 167, 206, 20);
		txtnome.setBackground(new Color(229, 229, 229));
		contentPane.add(txtnome);
		txtnome.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Prelector:");
		lblNewLabel_9.setBounds(201, 256, 78, 14);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblNewLabel_9);
		
		txtdataevento = new JTextField();
		txtdataevento.setBounds(317, 345, 206, 20);
		txtdataevento.setColumns(10);
		txtdataevento.setBackground(new Color(229, 229, 229));
		contentPane.add(txtdataevento);
		
		txttipoevento = new JTextField();
		txttipoevento.setBounds(317, 301, 206, 20);
		txttipoevento.setColumns(10);
		txttipoevento.setBackground(new Color(229, 229, 229));
		contentPane.add(txttipoevento);
		
		txtlocal = new JTextField();
		txtlocal.setBounds(317, 210, 206, 20);
		txtlocal.setColumns(10);
		txtlocal.setBackground(new Color(229, 229, 229));
		contentPane.add(txtlocal);
		
		txtprelector = new JTextField();
		txtprelector.setBounds(317, 254, 206, 20);
		txtprelector.setColumns(10);
		txtprelector.setBackground(new Color(229, 229, 229));
		contentPane.add(txtprelector);
		
		final JTextArea txtArea = new JTextArea();
		txtArea.setBackground(new Color(225, 225, 225));
		txtArea.setBounds(319, 443, 206, 59);
		contentPane.add(txtArea);
		
		final JSpinner intMax = new JSpinner();
		intMax.setBounds(317, 391, 78, 20);
		contentPane.add(intMax);
		
		JButton btnNewButton_4 = new JButton("Salvar");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				/**String tema_evento,local_evento,nome_palestrante,tipo_evento,data_evento;**/
				String enome,dataevento,nevento,levento,pvento,area;
				int max;
				
				enome = txtnome.getText();
				dataevento = txtdataevento.getText();
				nevento = txttipoevento.getText();
				levento = txtlocal.getText();
				pvento = txtprelector.getText();
				max = intMax.countComponents();
				area = txtArea.getText();
				
				
				try {
					
					PreparedStatement pst;
					Connection con;
					con = new ConexaoDB().conectaBD();  // Aqui importei a minha conexão por meio da classe ConexaoDB
					pst = con.prepareStatement("Insert into eventos(tema_evento,local_evento,nome_palestrante,numMax_participantes,tipo_evento,data_evento,descricao_evento) values(?,?,?,?,?,?,?)");
					
					pst.setString(1, enome);
					pst.setString(2, levento);
					pst.setString(3, pvento);
					pst.setInt(4, max);
					pst.setString(5, nevento);
					pst.setString(6, dataevento);
					pst.setString(7, area);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Evento Adicionado com sucesso!!!");
					// table_load;
					txtnome.setText("");
					txtdataevento.setText("");
					txttipoevento.setText("");
					txtlocal.setText("");
					txtprelector.setText("");
					intMax.setToolTipText("");
					txtArea.setText("");
					txtnome.requestFocus();
					
				} catch (Exception e2) {
					e2.printStackTrace();
				}
	
				
			}
			
			// Classe para visualização dos Eventos Adicionados
			
		});
		btnNewButton_4.setBounds(184, 542, 106, 35);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_4_1 = new JButton("Sair");
		btnNewButton_4_1.setBounds(317, 542, 106, 35);
		contentPane.add(btnNewButton_4_1);
		
		JButton btnNewButton_4_1_1 = new JButton("Limpar");
		btnNewButton_4_1_1.setBounds(454, 542, 106, 35);
		contentPane.add(btnNewButton_4_1_1);
		
		JLabel lblNewLabel_8_1 = new JLabel("N. Participantes:");
		lblNewLabel_8_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8_1.setBounds(201, 393, 108, 14);
		contentPane.add(lblNewLabel_8_1);
		
		JLabel lblNewLabel_8_1_1 = new JLabel("Descrição:");
		lblNewLabel_8_1_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_8_1_1.setBounds(201, 443, 108, 14);
		contentPane.add(lblNewLabel_8_1_1);
		
		JLabel other = new JLabel("");
		other.setBounds(184, 124, 376, 394);
		other.setBackground(new Color(210, 210, 210));
		other.setFont(new Font("Tahoma", Font.PLAIN, 13));
		other.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Registo de Novo Evento", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		contentPane.add(other);
	}

}
