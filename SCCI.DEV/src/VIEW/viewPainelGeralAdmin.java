package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import ConexaoDB.ConexaoDB;
import auth.RegistroForm;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class viewPainelGeralAdmin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField txtcodEv;
	private JTextField txtuser;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewPainelGeralAdmin frame = new viewPainelGeralAdmin();
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
	public viewPainelGeralAdmin() {
		setTitle("Admin View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 982, 586);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\jsebastiao1\\Desktop\\JavaProject\\JavaProject\\Images\\footer2-0.png"));
		lblNewLabel_2.setBounds(839, 0, 127, 138);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(165, 142, 700, 290);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Carregar Evento");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Importar conector jdbc
					Class.forName("com.mysql.cj.jdbc.Driver");
					// Importamos a Classe ConexaoDB e criamos novo objeto de conexão (con) por meio
					// do módulo Connection (SQL)
					Connection con;
					con = new ConexaoDB().conectaBD();
					// Execussão da query para pesquisa da informação na base de dados e posterior
					// arquivo na variável "query"
					Statement st = con.createStatement();
					String query = "select * from eventos";
					// Retorna os valores armazenados na variável "query", neste caso, traz todos os
					// dados conforme disposição da query
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					// Criação de modelo de tabela
					DefaultTableModel model = (DefaultTableModel) table.getModel();

					// Aqui definimos quantas colunas terá a nossa tabela - Colunas vindas da base
					// de dados
					int cols = rsmd.getColumnCount();
					String[] colName = new String[cols];
					// Array
					for (int i = 0; i < cols; i++)
						colName[i] = rsmd.getColumnName(i + 1);
					model.setColumnIdentifiers(colName);

					String id, tema, local, palestr, max, tipo, data, descr, cod_ev;
					while (rs.next()) {
						id = rs.getString(1);
						tema = rs.getString(2);
						local = rs.getString(3);
						palestr = rs.getString(4);
						max = rs.getString(5);
						tipo = rs.getString(6);
						data = rs.getString(7);
						descr = rs.getString(8);
						cod_ev = rs.getString(9);
						String[] row = { id, tema, local, palestr, max, tipo, data, descr, cod_ev };
						model.addRow(row);
					}
					st.close();
					con.close();

				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(165, 108, 133, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Limpar Tabela");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(327, 108, 122, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Apagar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				//con = new ConexaoDB().conectaBD();
				ResultSet rs = null;
				PreparedStatement pst = null;
				//String txtMax;
				try {
					String sql = "DELETE FROM eventos WHERE cod_evento =?";
					
					con = new ConexaoDB().conectaBD();
					
					pst = con.prepareStatement(sql);
					
					pst.setString(1, txtcodEv.getText());
					
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Evento apagado com sucesso");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton_2.setBounds(776, 443, 89, 23);
		contentPane.add(btnNewButton_2);
		
		txtcodEv = new JTextField();
		txtcodEv.setBounds(327, 445, 122, 20);
		contentPane.add(txtcodEv);
		txtcodEv.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Inserir um ID para apagar");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel.setBounds(165, 448, 151, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_3 = new JButton("Gerir Users");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmViewAdmin objviewadmin = new frmViewAdmin();
				objviewadmin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(10, 115, 122, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1 = new JLabel("Menu");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(48, 73, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(0, 48, 141, 499);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Administrador: ");
		lblNewLabel_3.setBounds(22, 17, 89, 14);
		contentPane.add(lblNewLabel_3);
		
		txtuser = new JTextField();
		txtuser.setEditable(false);
		txtuser.setBounds(116, 14, 86, 20);
		contentPane.add(txtuser);
		txtuser.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(0, 0, 966, 49);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
