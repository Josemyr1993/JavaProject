package Lixo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.x.protobuf.MysqlxCrud.Update;

import ConexaoDB.ConexaoDB;
import net.proteanit.sql.DbUtils;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JScrollPane;
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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ShowTable extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTable table;
	protected AbstractButton tblData;
	private JButton btnNewButton_2;
	private JTextField txtTema;
	private JTextField txtLocal;
	private JTextField txtPal;
	private JTextField txtPar;
	private JTextField txtEv;
	private JTextField txtDt;
	private JTextField txtDesc;
	private JTextField txtId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowTable frame = new ShowTable();
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
	public ShowTable() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1062, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Carregar Eventos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Importar conector jdbc
					Class.forName("com.mysql.cj.jdbc.Driver");
					// Importamos a Classe ConexaoDB e criamos novo objeto de conexão (con) por meio do módulo Connection (SQL)
					Connection con;
					con = new ConexaoDB().conectaBD();
					// Execussão da query para pesquisa da informação na base de dados e posterior arquivo na variável "query"
					Statement st=con.createStatement();
					String query="select * from eventos";
					// Retorna os valores armazenados na variável "query", neste caso, traz todos os dados conforme disposição da query
					ResultSet rs = st.executeQuery(query);
					ResultSetMetaData rsmd = rs.getMetaData();
					// Criação de modelo de tabela
					DefaultTableModel model=(DefaultTableModel) table.getModel();
					
					// Aqui definimos quantas colunas terá a nossa tabela - Colunas vindas da base de dados
					int cols=rsmd.getColumnCount();
					String[] colName=new String[cols];
					// Array
					for(int i=0;i<cols;i++)
						colName[i]=rsmd.getColumnName(i+1);
					model.setColumnIdentifiers(colName);
					
					String id,tema,local,palestr,max,tipo,data,descr;
					while(rs.next()) {
						id=rs.getString(1);
						tema=rs.getString(2);
						local=rs.getString(3);
						palestr=rs.getString(4);
						max=rs.getString(5);
						tipo=rs.getString(6);
						data=rs.getString(7);
						descr=rs.getString(8);
						String[] row= {id,tema,local,palestr,max,tipo,data,descr};
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(159, 319, 166, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(0, 0, 1046, 52);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(0, 48, 120, 567);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// set data to their textfield
				
				/**DefaultTableModel model = (DefaultTableModel) table.getModel();
				
				// set data to text field when raw is selected
				
				String tema = model.getValueAt(table.getSelectedRow(), 1).toString();
				String local = model.getValueAt(table.getSelectedRow(), 2).toString();
				String palestr = model.getValueAt(table.getSelectedRow(), 3).toString();
				String max = model.getValueAt(table.getSelectedRow(), 4).toString();
				String tipo = model.getValueAt(table.getSelectedRow(), 5).toString();
				String data = model.getValueAt(table.getSelectedRow(), 6).toString();
				String descr = model.getValueAt(table.getSelectedRow(), 7).toString();
				
				txtTema.setText(tema);
				txtLocal.setText(local);
				txtPal.setText(palestr);
				txtPar.setText(max);
				txtEv.setText(tipo);
				txtDt.setText(data);
				txtDesc.setText(descr); **/
				
							
				
				
			}
		});
		scrollPane.setBounds(159, 86, 877, 207);
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
				
				txtId.setText(id);
				txtTema.setText(tema);
				txtLocal.setText(local);
				txtPal.setText(palestr);
				txtPar.setText(max);
				txtEv.setText(tipo);
				txtDt.setText(data);
				txtDesc.setText(descr);
				
				
			}
		});
		scrollPane.setViewportView(table);
		
		final JButton btnNewButton_1 = new JButton("Limpar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Limpar o painel
				table.setModel(new DefaultTableModel());
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(346, 319, 166, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Atualizar Tabela");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Connection con;
				con = new ConexaoDB().conectaBD();
				Statement st;
				try {
					st = con.createStatement();
					
					// Get table model
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					if(table.getSelectedRowCount() == 1) {
						//if single row is selected than update
						//id,tema,local,palestr,max,tipo,data,descr;
						String id = txtId.getText();
						String tema = txtTema.getText();
						String local = txtLocal.getText();
						String palestr = txtPal.getText();
						String max = txtPar.getText();
						String tipo = txtEv.getText();
						String data = txtDt.getText();
						String descr = txtDesc.getText();
						
						
						// Set Update value on table row
						model.setValueAt(id, table.getSelectedRow(), 0);
						model.setValueAt(tema, table.getSelectedRow(), 1);
						model.setValueAt(local, table.getSelectedRow(), 2);
						model.setValueAt(palestr, table.getSelectedRow(), 3);
						model.setValueAt(max, table.getSelectedRow(), 4);
						model.setValueAt(tipo, table.getSelectedRow(), 5);
						model.setValueAt(data, table.getSelectedRow(), 6);
						model.setValueAt(descr, table.getSelectedRow(), 7);
						
						// Aqui
						
						
						// update message display
						JOptionPane.showMessageDialog(null, "Evento Atualizado na tabela Com Sucesso!!!");
						
					} else {
						if(table.getRowCount()==0) {
							// Se a tabela estiver vazia
							JOptionPane.showMessageDialog(null, "Tabela está vazia!!!");
						}else {
							// Se a tabela não for selecionada ou selecionar múltiplas tabelas
							JOptionPane.showMessageDialog(null, "Por favor selecionar uma tabela para atualizar!!!");
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBounds(159, 525, 166, 23);
		contentPane.add(btnNewButton_2);
		
		txtTema = new JTextField();
		txtTema.setBounds(269, 456, 79, 23);
		contentPane.add(txtTema);
		txtTema.setColumns(10);
		
		txtLocal = new JTextField();
		txtLocal.setColumns(10);
		txtLocal.setBounds(358, 456, 79, 23);
		contentPane.add(txtLocal);
		
		txtPal = new JTextField();
		txtPal.setColumns(10);
		txtPal.setBounds(447, 456, 79, 23);
		contentPane.add(txtPal);
		
		txtPar = new JTextField();
		txtPar.setColumns(10);
		txtPar.setBounds(536, 456, 79, 23);
		contentPane.add(txtPar);
		
		txtEv = new JTextField();
		txtEv.setColumns(10);
		txtEv.setBounds(625, 456, 86, 23);
		contentPane.add(txtEv);
		
		txtDt = new JTextField();
		txtDt.setColumns(10);
		txtDt.setBounds(721, 456, 86, 23);
		contentPane.add(txtDt);
		
		txtDesc = new JTextField();
		txtDesc.setColumns(10);
		txtDesc.setBounds(825, 456, 196, 23);
		contentPane.add(txtDesc);
		
		JLabel lblNewLabel_1 = new JLabel("Tema");
		lblNewLabel_1.setBounds(269, 434, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Local");
		lblNewLabel_1_1.setBounds(358, 431, 46, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Palestrante");
		lblNewLabel_1_2.setBounds(447, 431, 69, 14);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Participantes");
		lblNewLabel_1_3.setBounds(536, 431, 86, 14);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Tipo Evento");
		lblNewLabel_1_4.setBounds(625, 431, 85, 14);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Data Evento");
		lblNewLabel_1_5.setBounds(721, 431, 69, 14);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Descrição");
		lblNewLabel_1_6.setBounds(825, 431, 58, 14);
		contentPane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("Id");
		lblNewLabel_1_7.setBounds(173, 434, 46, 14);
		contentPane.add(lblNewLabel_1_7);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(173, 457, 79, 23);
		contentPane.add(txtId);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setBounds(159, 423, 877, 80);
		contentPane.add(lblNewLabel);
		
		JButton limpar2 = new JButton("Limpar");
		limpar2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Limpar form da edição
				
			}
		});
		limpar2.setFont(new Font("Tahoma", Font.BOLD, 13));
		limpar2.setBounds(346, 526, 166, 23);
		contentPane.add(limpar2);
	}
}
