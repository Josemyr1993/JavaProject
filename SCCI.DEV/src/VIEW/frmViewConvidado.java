package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import ConexaoDB.ConexaoDB;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class frmViewConvidado extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField txtTema;
	private JTextField txtLocal;
	private JTextField txtNome;
	private JTextField txtcodEv;
	private JTextField txtNome2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmViewConvidado frame = new frmViewConvidado();
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
	public frmViewConvidado() {
		setTitle("Convidado View");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1135, 554);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(201, 201, 201));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bem Vindo Palestrante");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(24, -2, 190, 59);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(0, 0, 1119, 59);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(49, 113, 586, 289);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
DefaultTableModel model = (DefaultTableModel) table.getModel();
				

				String id = model.getValueAt(table.getSelectedRow(), 0).toString();
				String tema = model.getValueAt(table.getSelectedRow(), 1).toString();
				String local = model.getValueAt(table.getSelectedRow(), 2).toString();
				String palestr = model.getValueAt(table.getSelectedRow(), 3).toString();
				String max = model.getValueAt(table.getSelectedRow(), 4).toString();
				String tipo = model.getValueAt(table.getSelectedRow(), 5).toString();
				String data = model.getValueAt(table.getSelectedRow(), 6).toString();
				String descr = model.getValueAt(table.getSelectedRow(), 7).toString();
				String cod_eve = model.getValueAt(table.getSelectedRow(), 8).toString();

				
				txtTema.setText(tema);
				txtLocal.setText(local);
				txtcodEv.setText(cod_eve);
				


			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Ver Todos Eventos");
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(47, 70, 154, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Tema Evento");
		lblNewLabel_1.setBounds(705, 163, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Local");
		lblNewLabel_1_1.setBounds(705, 218, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nome");
		lblNewLabel_1_2.setBounds(705, 272, 103, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Participar Como");
		lblNewLabel_1_3.setBounds(705, 327, 94, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Código Evento");
		lblNewLabel_1_3_1.setBounds(705, 388, 94, 14);
		contentPane.add(lblNewLabel_1_3_1);
		
		txtTema = new JTextField();
		txtTema.setBounds(818, 160, 168, 20);
		contentPane.add(txtTema);
		txtTema.setColumns(10);
		
		txtLocal = new JTextField();
		txtLocal.setColumns(10);
		txtLocal.setBounds(818, 215, 168, 20);
		contentPane.add(txtLocal);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(818, 269, 168, 20);
		contentPane.add(txtNome);
		
		final JRadioButton rbPalestrante = new JRadioButton("Palestrante");
		rbPalestrante.setBounds(818, 323, 109, 23);
		contentPane.add(rbPalestrante);
		
		final JRadioButton rbExpectador = new JRadioButton("Expectador");
		rbExpectador.setBounds(818, 349, 109, 23);
		contentPane.add(rbExpectador);
		
		txtcodEv = new JTextField();
		txtcodEv.setEditable(false);
		txtcodEv.setBounds(818, 385, 168, 20);
		contentPane.add(txtcodEv);
		txtcodEv.setColumns(10);
		
		JLabel label = new JLabel("");
		label.setBorder(new TitledBorder(null, "Registar-se ao Evento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		label.setBounds(664, 111, 356, 354);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton("Cadastrar-se");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					Connection con = null;
					//con = new ConexaoDB().conectaBD();
					ResultSet rs = null;
					PreparedStatement pst = null;
					//String txtMax;
					try {
						String sql = "insert into eventos_convidados(tema_evento,local_evento,nome_participante,categoria_participante,cod_evento) values (?,?,?,?,?)";
						con = new ConexaoDB().conectaBD(); 
						pst = con.prepareStatement(sql);

						pst.setString(1, txtTema.getText());
						pst.setString(2, txtLocal.getText());
						pst.setString(3, txtNome.getText());
						if(rbPalestrante.isSelected())
							pst.setString(4, rbPalestrante.getText());
						else
							pst.setString(4, rbExpectador.getText());
						pst.setString(5, txtcodEv.getText());
						
						pst.executeUpdate();
						JOptionPane.showMessageDialog(null, "Cadastrado ao Evento com Sucesso!!!");
						
					} catch (Exception e2) {
						JOptionPane.showMessageDialog(null, e2);
					}
				}
		});
		btnNewButton_1.setBounds(886, 476, 134, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Limpar Tabela");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(211, 71, 128, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Ver meus Eventos");
		btnNewButton_3.addActionListener(new ActionListener() {
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
				
					// Aqui iremos executar o processo de pesquisa de eventos a qual o utilizador está cadastrado por meio de insersão do Nome inserido no processo de cadastro ao Evento
					String u = txtNome2.getText();
					String query = "select*from eventos_convidados where nome_participante='"+u+"'";
					//String query = "select id_evento,tema_evento,local_evento,nome_participante,categoria_participante,cod_evento from eventos_convidados where nome_participante='"+NomeConv+"'";
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

					String id_evento, tema_evento, local_evento, nome_participante, categoria_participante, cod_evento;
					while (rs.next()) {
						id_evento = rs.getString(1);
						tema_evento= rs.getString(2);
						local_evento = rs.getString(3);
						nome_participante = rs.getString(4);
						categoria_participante = rs.getString(5);
						cod_evento = rs.getString(6);
						String[] row = { id_evento, tema_evento, local_evento, nome_participante, categoria_participante, cod_evento };
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
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBounds(49, 425, 173, 23);
		contentPane.add(btnNewButton_3);
		
		txtNome2 = new JTextField();
		txtNome2.setForeground(new Color(0, 0, 0));
		txtNome2.setColumns(10);
		txtNome2.setBounds(243, 425, 209, 22);
		contentPane.add(txtNome2);
	}
}
