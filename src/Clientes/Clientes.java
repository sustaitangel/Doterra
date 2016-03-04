package Clientes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import Conexion.Conectar;
import Imagenes.Img;
import Productos.AgregarProducto;

import javax.swing.JTabbedPane;
import javax.swing.Icon;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

import javax.swing.JTable;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtApaterno;
	private JTextField txtAmaterno;
	private JTextField txtEmail;
	private JTextField txtTelefono;
	private JTextField txtBuscar;
	private JTable tableClientes;
	private JTable tableClientes_1;
	java.sql.Connection con;
	Conectar conex = new Conectar();
	java.sql.Statement list;
	ResultSet rs;
	private static   String matriz[][]={};
	private static   String vector[]={"ID","Nombre","A.paterno","A.Materno","Email","Telefono"};
	public static   DefaultTableModel modelo2= new DefaultTableModel(matriz,vector);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public void limpiar(){
		txtId.setText("");
		txtNombre.setText("");
		txtApaterno.setText("");
		txtAmaterno.setText("");
		txtEmail.setText("");
		txtTelefono.setText("");
		
	}
	void listarClientes(String buscar){
		JTextField hola = null;
		String sql = "";
		try {
			con = conex.conexion(hola);
			String[] titulos = {"ID","Nombre","A.paterno","A.materno","Email","Telefono"};
			if (buscar.equals("")) {
				sql = "select id_cliente,nombre,a_paterno,a_materno,email,telefono " +
						"from clientes as c ";
				
			} else {
				sql = "select id_cliente,nombre,a_paterno,a_materno,email,telefono " +
						"from clientes as c " +
						"where nombre like '%" + buscar + "%'" +
						" OR  a_paterno LIKE '%" + buscar + "%'";
				
			}
			list =  con.createStatement();
			DefaultTableModel model = new DefaultTableModel(null, titulos);
			tableClientes_1.setModel(model);
			rs = list.executeQuery(sql);
			
			while (rs.next()) {
				model.addRow(new Object[] {rs.getString("id_cliente"),rs.getString("nombre"),rs.getString("a_paterno")
					,rs.getString("a_materno"),rs.getString("email"),rs.getString("telefono")});
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Clientes() {
		setTitle("--doTerra-- Alta Clientes--");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 563, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Alta de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane.setBounds(10, 11, 527, 371);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 26, 507, 334);
		layeredPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Clientes", null, panel, null);
		panel.setLayout(null);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_1.setBounds(10, 11, 482, 73);
		panel.add(layeredPane_1);
		
		JLabel lblNombre = new JLabel("Buscar por Nombre o Apellido");
		lblNombre.setForeground(new Color(34, 139, 34));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombre.setBounds(10, 11, 171, 21);
		layeredPane_1.add(lblNombre);
		
		txtBuscar = new JTextField();
		txtBuscar.setBounds(21, 31, 152, 21);
		layeredPane_1.add(txtBuscar);
		txtBuscar.setColumns(10);
		
		Img n39 = new Img();
		JButton btnBuscar = new JButton(n39.Buscar());
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String buscarString = txtBuscar.getText();
				if (!buscarString.equals("")) {
					listarClientes(buscarString);
					txtBuscar.setText("");
				}else{
					listarClientes("");
				}
				
			}
		});
		btnBuscar.setBounds(199, 21, 61, 41);
		layeredPane_1.add(btnBuscar);
		
		Img n37 = new Img();
		JButton btnEliminar = new JButton(n37.Eliminar());
		btnEliminar.setBounds(270, 21, 61, 41);
		layeredPane_1.add(btnEliminar);
		
		Img n38 = new Img();
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_2.setBounds(10, 95, 482, 200);
		panel.add(layeredPane_2);
		layeredPane_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 462, 168);
		layeredPane_2.add(scrollPane);
		
		tableClientes = new JTable(){
			public boolean isCellEditable(int rowIndex, int columnIndex) { 
				if (columnIndex==5) return true; 
				if (columnIndex==3) return false;
				if (columnIndex==2) return true;
				else 
				return false; 
				} 
			
		};;
		tableClientes_1 = new JTable();
		tableClientes_1.setCellSelectionEnabled(true);
		tableClientes_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setColumnHeaderView(tableClientes_1);
		tableClientes_1.setBackground(new Color(255, 255, 255));
		scrollPane.setColumnHeaderView(tableClientes_1);
		scrollPane.setViewportView(tableClientes_1);
		tableClientes_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Nombre", "A.paterno", "A.materno", "Email", "Telefono"
			}
		));
		tableClientes_1.getColumnModel().getColumn(0).setPreferredWidth(60);
		tableClientes_1.getColumnModel().getColumn(3).setPreferredWidth(67);
		tableClientes_1.getColumnModel().getColumn(5).setResizable(false);
		
		
	
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Alta Clientes", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Id Cliente :");
		label.setForeground(new Color(34, 139, 34));
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(131, 11, 70, 22);
		panel_1.add(label);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(211, 13, 110, 20);
		panel_1.add(txtId);
		
		JLabel label_1 = new JLabel("Nombre :");
		label_1.setForeground(new Color(34, 139, 34));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(141, 44, 58, 22);
		panel_1.add(label_1);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(211, 44, 110, 20);
		panel_1.add(txtNombre);
		
		JLabel label_2 = new JLabel("Apellido Paterno :");
		label_2.setForeground(new Color(34, 139, 34));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(85, 77, 116, 14);
		panel_1.add(label_2);
		
		txtApaterno = new JTextField();
		txtApaterno.setColumns(10);
		txtApaterno.setBounds(211, 75, 110, 20);
		panel_1.add(txtApaterno);
		
		JLabel label_3 = new JLabel("Apellido Materno :");
		label_3.setForeground(new Color(34, 139, 34));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(82, 102, 119, 22);
		panel_1.add(label_3);
		
		txtAmaterno = new JTextField();
		txtAmaterno.setColumns(10);
		txtAmaterno.setBounds(211, 104, 110, 20);
		panel_1.add(txtAmaterno);
		
		JLabel label_4 = new JLabel("e-mail :");
		label_4.setForeground(new Color(34, 139, 34));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(153, 135, 48, 22);
		panel_1.add(label_4);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(211, 135, 110, 22);
		panel_1.add(txtEmail);
		
		JLabel label_5 = new JLabel("Telefono :");
		label_5.setForeground(new Color(34, 139, 34));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(137, 163, 64, 22);
		panel_1.add(label_5);
		
		txtTelefono = new JTextField();
		txtTelefono.setColumns(10);
		txtTelefono.setBounds(211, 165, 110, 22);
		panel_1.add(txtTelefono);
		
		Img n35 = new Img ();
		JButton btnCancelar = new JButton(n35.btnCancelar());
		btnCancelar.setBounds(147, 196, 89, 34);
		panel_1.add(btnCancelar);
		
		Img n36 = new Img ();
		JButton btnGuardar = new JButton(n36.btnGuardar());
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AgregarCliente n= new AgregarCliente();
				n.agregar(txtId, txtNombre, txtApaterno, txtAmaterno,txtEmail, txtTelefono);
				limpiar();
			}
		});
		btnGuardar.setBounds(242, 196, 89, 34);
		panel_1.add(btnGuardar);
		
		
	}
}
