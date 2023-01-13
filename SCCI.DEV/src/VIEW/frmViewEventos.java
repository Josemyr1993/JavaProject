package VIEW;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import ConexaoDB.ConexaoDB;
import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.Font;
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

public class frmViewEventos extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtTema;
	private JTextField txtLocal;
	private JTextField txtPalestr;
	private JTextField txtTipo;
	private JTextField txtData;
	private JTextField txtDescr;
	private JTable table;
	private JTextField txtcodEv;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmViewEventos frame = new frmViewEventos();
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
/*
public void showTableData() {
	try {
		Connection con = null;
		//con = new ConexaoDB().conectaBD();
		ResultSet rs = null;
		PreparedStatement pst = null;
		con = new ConexaoDB().conectaBD();
		String sql = "SELECT*FROM eventos";
		pst = con.prepareStatement(sql);
		rs=pst.executeQuery();
			
		table.setModel(DbUtils.resultSetToTableModel(rs));
			
	}catch (Exception e) {
		JOptionPane.showMessageDialog(null, e);
			
	}
		
} */

	public frmViewEventos() {
		setTitle("Gertor View");
		//showTableData();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1173, 529);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(0, 0, 1157, 57);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Tema do Evento");
		lblNewLabel.setBounds(42, 150, 88, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblLocalDoEvento = new JLabel("Local do Evento");
		lblLocalDoEvento.setBounds(42, 183, 88, 14);
		contentPane.add(lblLocalDoEvento);
		
		JLabel lblNomePalest = new JLabel("Nome Palest.");
		lblNomePalest.setBounds(42, 218, 88, 14);
		contentPane.add(lblNomePalest);
		
		JLabel lblParticipantes = new JLabel("Participantes");
		lblParticipantes.setBounds(42, 255, 88, 14);
		contentPane.add(lblParticipantes);
		
		JLabel lblTipoEvento = new JLabel("Tipo Evento");
		lblTipoEvento.setBounds(42, 293, 88, 14);
		contentPane.add(lblTipoEvento);
		
		JLabel lblDataEvento = new JLabel("Data Evento");
		lblDataEvento.setBounds(42, 327, 88, 14);
		contentPane.add(lblDataEvento);
		
		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setBounds(42, 360, 88, 14);
		contentPane.add(lblDescrio);
		
		txtTema = new JTextField();
		txtTema.setBounds(140, 147, 222, 20);
		contentPane.add(txtTema);
		txtTema.setColumns(10);
		
		txtLocal = new JTextField();
		txtLocal.setColumns(10);
		txtLocal.setBounds(140, 180, 222, 20);
		contentPane.add(txtLocal);
		
		txtPalestr = new JTextField();
		txtPalestr.setColumns(10);
		txtPalestr.setBounds(140, 215, 222, 20);
		contentPane.add(txtPalestr);
		
		final JSpinner txtMax = new JSpinner();
		txtMax.setBounds(140, 252, 50, 20);
		contentPane.add(txtMax);
		
		txtTipo = new JTextField();
		txtTipo.setColumns(10);
		txtTipo.setBounds(140, 290, 222, 20);
		contentPane.add(txtTipo);
		
		txtData = new JTextField();
		txtData.setColumns(10);
		txtData.setBounds(140, 324, 222, 20);
		contentPane.add(txtData);
		
		txtDescr = new JTextField();
		txtDescr.setColumns(10);
		txtDescr.setBounds(140, 357, 222, 20);
		contentPane.add(txtDescr);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400, 100, 747, 321);
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
				
				
				txtTema.setText(tema);
				txtLocal.setText(local);
				txtPalestr.setText(palestr);
				txtMax.setToolTipText(max);
				txtTipo.setText(tipo);
				txtData.setText(data);
				txtDescr.setText(descr);
	
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID Evento", "Tema Evento", "Local Evento", "Nome Palestrante", "Max Participantes", "Tipo Evento", "Data Evento", "Descri\u00E7\u00E3o", "Cod_Evento"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("Inserir");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				//con = new ConexaoDB().conectaBD();
				ResultSet rs = null;
				PreparedStatement pst = null;
				//String txtMax;
				try {
					String sql = "INSERT INTO eventos"
							+"(tema_evento,local_evento,nome_palestrante,numMax_participantes,tipo_evento,data_evento,descricao_evento,cod_evento)"
							+"VALUES(?,?,?,?,?,?,?,?)";
					con = new ConexaoDB().conectaBD();
					
					pst = con.prepareStatement(sql);
					pst.setString(1, txtTema.getText());
					pst.setString(2, txtLocal.getText());
					pst.setString(3, txtPalestr.getText());
					pst.setInt(4, txtMax.getComponentCount());
					pst.setString(5, txtTipo.getText());
					pst.setString(6, txtData.getText());
					pst.setString(7, txtDescr.getText());
					pst.setString(8, txtcodEv.getText());
					pst.executeUpdate();
					
					JOptionPane.showMessageDialog(null, "Inserido Com Sucesso");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Código do Evento Duplicado!!!");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(313, 444, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				//con = new ConexaoDB().conectaBD();
				ResultSet rs = null;
				PreparedStatement pst = null;
				//String txtMax;
				try {
					String sql = "UPDATE eventos SET tema_evento =?,local_evento =?,nome_palestrante =?,numMax_participantes =?,tipo_evento =?,data_evento =?,descricao_evento =? WHERE cod_evento =?";
					con = new ConexaoDB().conectaBD(); 
					pst = con.prepareStatement(sql);
					
					
					pst.setString(1, txtTema.getText());
					pst.setString(2, txtLocal.getText());
					pst.setString(3, txtPalestr.getText());
					pst.setInt(4, txtMax.countComponents());
					pst.setString(5, txtTipo.getText());
					pst.setString(6, txtData.getText());
					pst.setString(7, txtDescr.getText());
					pst.setString(8, txtcodEv.getText());
					
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnAtualizar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAtualizar.setBounds(459, 444, 98, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
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
					/**pst.setString(2, txtLocal.getText());
					pst.setString(3, txtPalestr.getText());
					pst.setInt(4, txtData.getComponentCount());
					pst.setString(5, txtTipo.getText());
					pst.setString(6, txtData.getText());
					pst.setString(7, txtDescr.getText());*/
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Delete procedido com Sucesso");
					
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, e2);
				}
			}
		});
		btnApagar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnApagar.setBounds(610, 444, 98, 23);
		contentPane.add(btnApagar);
		
		JButton btnNovo = new JButton(" Carregar Eventos");
		btnNovo.addActionListener(new ActionListener() {
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
		btnNovo.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNovo.setBounds(400, 68, 157, 23);
		contentPane.add(btnNovo);
		
		JLabel lblCodEvento = new JLabel("Cod. Evento");
		lblCodEvento.setBounds(42, 393, 88, 14);
		contentPane.add(lblCodEvento);
		
		txtcodEv = new JTextField();
		txtcodEv.setColumns(10);
		txtcodEv.setBounds(140, 388, 111, 20);
		contentPane.add(txtcodEv);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new TitledBorder(null, "Registar Evento", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lblNewLabel_1.setBounds(32, 100, 358, 321);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Limpar Tabela");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table.setModel(new DefaultTableModel());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(575, 68, 157, 23);
		contentPane.add(btnNewButton_1);
	}
}
