package Lixo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import ConexaoDB.ConexaoDB;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Component;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;

public class frmNovoEvento extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField txtTema;
	private JTextField txtLocal;
	private JTextField txtNomePalestrante;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtdata;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmNovoEvento frame = new frmNovoEvento();
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
	public frmNovoEvento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 626, 622);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Area do Gestor - Novo Evento");
		lblNewLabel.setForeground(new Color(112, 112, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(23, 19, 281, 14);
		contentPane.add(lblNewLabel);
		
		txtTema = new JTextField();
		txtTema.setBounds(68, 208, 190, 29);
		contentPane.add(txtTema);
		txtTema.setColumns(10);
		
		txtLocal = new JTextField();
		txtLocal.setBounds(68, 277, 190, 29);
		contentPane.add(txtLocal);
		txtLocal.setColumns(10);
		
		txtNomePalestrante = new JTextField();
		txtNomePalestrante.setBounds(68, 356, 190, 29);
		contentPane.add(txtNomePalestrante);
		txtNomePalestrante.setColumns(10);
		
		final JTextArea txtDescricao = new JTextArea();
		txtDescricao.setBounds(347, 354, 190, 106);
		contentPane.add(txtDescricao);
		
		final JComboBox<String> jComboBox1 = new JComboBox();
		jComboBox1.setModel(new DefaultComboBoxModel(new String[] {"-- Selecione --"}));
		jComboBox1.setBounds(347, 207, 190, 29);
		contentPane.add(jComboBox1);
		
		JLabel lblNewLabel_1 = new JLabel("Tema do Evento");
		lblNewLabel_1.setBounds(68, 183, 124, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Local do Evento");
		lblNewLabel_2.setBounds(68, 252, 124, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nome Palestrante");
		lblNewLabel_3.setBounds(68, 331, 124, 14);
		contentPane.add(lblNewLabel_3);
		
		final JSpinner intNumMax = new JSpinner();
		intNumMax.setBounds(68, 431, 49, 29);
		contentPane.add(intNumMax);
		
		JLabel lblNewLabel_4 = new JLabel("Número máximo de participantes");
		lblNewLabel_4.setBounds(68, 406, 216, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Data do Evento");
		lblNewLabel_5.setBounds(347, 252, 105, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Descrição do Evento");
		lblNewLabel_6.setBounds(347, 331, 130, 14);
		contentPane.add(lblNewLabel_6);
		
		JButton Reset = new JButton("Reset");
		buttonGroup.add(Reset);
		Reset.setBounds(448, 537, 89, 23);
		contentPane.add(Reset);
		
		final JButton Adicionar = new JButton("Adicionar");
		buttonGroup.add(Adicionar);
		Adicionar.addActionListener(new ActionListener() {
			private ResultSet rs;

			public void actionPerformed(ActionEvent e) {
											
				/**try {
					String temaEvento;
					String localEvento;
					String nomePalestrante;
					int numMaxParticipante;
					String tipoEvento;
					String dataEvento;
					String descricaoEvento;
					
					// Aqui recuperamos as variáveis que serão setadas no formulário por meio dos campos do form
					temaEvento = txtTema.getText();
					localEvento = txtLocal.getText();
					nomePalestrante = txtNomePalestrante.getText();
					numMaxParticipante = intNumMax.getComponentCount();
					tipoEvento = jComboBox1.getToolTipText();
					dataEvento = txtdata.getText();
					descricaoEvento = txtDescricao.getText();
					
					EventoDTO objeventodto = new EventoDTO();
					
					
					//Class.forName("com.mysql.cj.jdbc.Driver");
					//Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/scci_dev","root","Programacao2023");
					// Aqui reutilizamos a class ConexaoDB para gerar uma nova conexão na base de dados para não ficar conforme o código acima.
					Connection con;
					con = new ConexaoDB().conectaBD();
					
					String sql = "insert into eventos(tema_evento,local_evento,nome_palestrante,numMax_participantes,data_evento,descricao_evento) values(?,?,?,?,?,?)";
					PreparedStatement ps=con.prepareStatement(sql);
					
					
					// Aqui é onde cada variável é setada no formulário, ou seja o valor que o utilizador insir, será recuparado pelo método get e criará um novo objeto.
					ps.setString(1, txtTema.getText());
					ps.setString(2, txtLocal.getText());
					ps.setString(3, txtNomePalestrante.getText());
					ps.setInt(4, intNumMax.getComponentCount());
					ps.setString(5, jComboBox1.getToolTipText());
					ps.setString(6, txtdata.getToolTipText());
					ps.setString(7, txtDescricao.getText());
					
					// Mostrar Informação de sucesso quando validado no botão
					int i=ps.executeUpdate();
					JOptionPane.showMessageDialog(Adicionar, " Evento Adicionado Com Sucesso!");
					
					// Para Fechar a conexão e ps
					ps.close();
					con.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				} **/
				
			}
			
		});
		
		Adicionar.setBounds(347, 537, 89, 23);
		contentPane.add(Adicionar);
		
		JLabel lblNewLabel_7 = new JLabel("New label");
		lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\jsebastiao1\\Desktop\\JavaProject\\JavaProject\\Images\\footer2-0.png"));
		lblNewLabel_7.setBounds(482, 0, 130, 141);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(0, 0, 612, 56);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_8 = new JLabel("Adicionar Novo Evento ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_8.setBounds(232, 117, 150, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Tipo de Evento");
		lblNewLabel_9.setBounds(347, 183, 105, 14);
		contentPane.add(lblNewLabel_9);
		
		txtdata = new JTextField();
		txtdata.setBounds(347, 277, 190, 29);
		contentPane.add(txtdata);
		txtdata.setColumns(10);
	}
}
