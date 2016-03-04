package Inventario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Imagenes.Img;

import javax.swing.JTabbedPane;

import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Conexion.Conectar;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.PreparedStatement;

import javax.swing.JTable;

import Productos.ModificarProductos;

import javax.swing.JRadioButton;

public class Inventario2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscarProductos;
	int tipo=3;
	String tipo1;
	Conectar conex = new Conectar();
	java.sql.Connection con;
	java.sql.Statement list;
	ResultSet rs;
	private ButtonGroup rb = new ButtonGroup();
	private JTable tableVerProductos;
	private static   String matriz[][]={};
	private static   String vector[]={"Clave","Nombre","Unidad","P.Cliente","P.Distribuidor","P.Gota","PV","Cantidad"};
	public static   DefaultTableModel modelo2= new DefaultTableModel(matriz,vector);
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario2 frame = new Inventario2();
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
	void listarProductos(String buscar){
		JTextField hola = null;
		String sql = "";
		try {
			con = conex.conexion(hola);
			if (buscar.equals("")) {
				sql = "select id_producto,clave,nombre,unidad,precio_cliente,precio_distribuidor,precio_gota,pv,cantidad" +
						"from productos as p " +
						"inner join categoria as cat on id_categoria = categoria_id_categoria";
			} else {
				sql = "select id_producto,clave,nombre,unidad,precio_cliente,precio_distribuidor,precio_gota,pv,cantidad" +
						"from productos as p " +
						"inner join categoria as cat on id_categoria = categoria_id_categoria " +
						"where nombre like '%" + buscar + "%'" +
						" OR codigo LIKE '%" + buscar + "%'" +
						" OR cat.descripcion LIKE '%" + buscar + "%'";
			}
			list =  con.createStatement();
			DefaultTableModel model = new DefaultTableModel(null, vector);
			tableVerProductos.setModel(model);
			rs = list.executeQuery(sql);
			while (rs.next()) {
				String precioDistribuidor = "$ " + String.format("%.2f", rs.getFloat("precio_distribuidor"));
				String precioGota = "$ " + String.format("%.2f", rs.getFloat("precio_gota"));
				String precioCliente = "$ " + String.format("%.2f", rs.getFloat("precio_cliente"));
				model.addRow(new Object[] {rs.getString("id_producto"),rs.getString("clave"),rs.getString("nombre"),precioDistribuidor,precioGota,precioCliente,rs.getInt("cantidad")});
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	public Inventario2() {
		setResizable(false);
		setTitle("--doTerra-- Alta Productos--");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 733, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Alta de Productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(75, 0, 130)));
		layeredPane.setBounds(10, 10, 698, 417);
		contentPane.add(layeredPane);
		
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 21, 678, 374);
		layeredPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Catalago de productos", null, panel, null);
		panel.setLayout(null);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_1.setBounds(10, 11, 653, 79);
		panel.add(layeredPane_1);
		
		JLabel lblCodigoNombre = new JLabel("Codigo \u00F3 Nombre");
		lblCodigoNombre.setForeground(new Color(34, 139, 34));
		lblCodigoNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblCodigoNombre.setBounds(40, 21, 120, 14);
		layeredPane_1.add(lblCodigoNombre);
		
		txtBuscarProductos = new JTextField();
		txtBuscarProductos.setBounds(27, 36, 170, 20);
		layeredPane_1.add(txtBuscarProductos);
		txtBuscarProductos.setColumns(10);
		
		Img n10=new Img();
		JButton btnBuscar = new JButton(n10.Buscar());
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String buscarString = txtBuscarProductos.getText();
				if (!buscarString.equals("")) {
					listarProductos(buscarString);
					txtBuscarProductos.setText("");
				}else{
					listarProductos("");
				}
			}
		});
		btnBuscar.setBounds(207, 27, 61, 41);
		layeredPane_1.add(btnBuscar);
		
		JRadioButton rdbtnMostrarTodosLos = new JRadioButton("Mostrar Todos Los Registros");
		rdbtnMostrarTodosLos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listarProductos("");
			}
		});
		rb.add(rdbtnMostrarTodosLos);
		rdbtnMostrarTodosLos.setForeground(new Color(34, 139, 34));
		rdbtnMostrarTodosLos.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnMostrarTodosLos.setBounds(303, 17, 211, 23);
		layeredPane_1.add(rdbtnMostrarTodosLos);
		
		JRadioButton rdbtnMostrarAgotados = new JRadioButton("Mostrar Agotados");
		rdbtnMostrarAgotados.setForeground(new Color(34, 139, 34));
		rdbtnMostrarAgotados.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnMostrarAgotados.setBounds(303, 45, 127, 23);
		layeredPane_1.add(rdbtnMostrarAgotados);
		
		JButton btnExportarPdf = new JButton("Exportar Pdf");
		btnExportarPdf.setBounds(518, 31, 109, 30);
		layeredPane_1.add(btnExportarPdf);
		
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "Lista de productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_2.setBounds(10, 104, 653, 231);
		panel.add(layeredPane_2);
		layeredPane_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 633, 197);
		layeredPane_2.add(scrollPane);
		
		tableVerProductos = new JTable();
		tableVerProductos.setCellSelectionEnabled(true);
		tableVerProductos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		scrollPane.setColumnHeaderView(tableVerProductos);
        tableVerProductos.setBackground(new Color(255, 255, 255));
		
		scrollPane.setColumnHeaderView(tableVerProductos);
		scrollPane.setViewportView(tableVerProductos);
		tableVerProductos.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Clave", "Nombre", "Unidad", "P.Cliente", "P.Distribuidor", "P.Gota", "PV", "Cantidad"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableVerProductos.getColumnModel().getColumn(3).setPreferredWidth(67);
		tableVerProductos.getColumnModel().getColumn(4).setPreferredWidth(81);
		tableVerProductos.getColumnModel().getColumn(7).setResizable(false);
	}
}
