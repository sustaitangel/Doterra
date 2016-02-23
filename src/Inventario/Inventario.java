package Inventario;

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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

import javax.swing.JTextField;
import javax.swing.JButton;

import Conexion.Conectar;
import Imagenes.Img;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Inventario extends JFrame {

	private JPanel contentPane;
	private static   String matriz[][]={};
	private static   String vector[]={"ID","Producto","P.Distribuidor","P.Gota","P.Cliente","Cantidad"};
	public static   DefaultTableModel modelo2= new DefaultTableModel(matriz,vector);
	private JTextField txtBuscarInventario;
	private JTable tableProductos;
	private ButtonGroup rb = new ButtonGroup();
	Conectar conex = new Conectar();
	java.sql.Connection con;
	java.sql.Statement list;
	ResultSet rs;
	String[] titulos = {"ID","Clave","Producto","P.Distribuidor","P.Gota","P.Cliente","Cantidad"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario frame = new Inventario();
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
				sql = "select id_producto,clave,nombre,precio_distribuidor,precio_gota,precio_cliente,cantidad " +
						"from productos as p " +
						"inner join categoria as cat on id_categoria = categoria_id_categoria";
			} else {
				sql = "select id_producto,clave,nombre,precio_distribuidor,precio_gota,precio_cliente,cantidad " +
						"from productos as p " +
						"inner join categoria as cat on id_categoria = categoria_id_categoria " +
						"where nombre like '%" + buscar + "%'" +
						" OR codigo LIKE '%" + buscar + "%'" +
						" OR cat.descripcion LIKE '%" + buscar + "%'";
			}
			list =  con.createStatement();
			DefaultTableModel model = new DefaultTableModel(null, titulos);
			tableProductos.setModel(model);
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
	void productosVacios(String buscar){
		JTextField hola = null;
		String sql = "";
		try {
			con = conex.conexion(hola);
			if (buscar.equals("")) {
				sql = "select id_producto,clave,nombre,precio_distribuidor,precio_gota,precio_cliente,cantidad " +
						"from productos as p " +
						"inner join categoria as cat on id_categoria = categoria_id_categoria " +
						"where cantidad = 0";
			} else {
				sql = "select id_producto,clave,nombre,precio_distribuidor,precio_gota,precio_cliente,cantidad " +
						"from productos as p " +
						"inner join categoria as cat on id_categoria = categoria_id_categoria " +
						"where nombre like '%" + buscar + "%'" +
						" OR codigo LIKE '%" + buscar + "%'" +
						" OR cat.descripcion LIKE '%" + buscar + "%'" + " AND cantidad = 0";
			}
			list =  con.createStatement();
			DefaultTableModel model = new DefaultTableModel(null, titulos);
			tableProductos.setModel(model);
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
	public Inventario() {
		setTitle("--doTerra-- Inventario de productos--");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inventario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane.setBounds(10, 11, 615, 361);
		contentPane.add(layeredPane);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_1.setBounds(10, 30, 595, 76);
		layeredPane.add(layeredPane_1);
		
		JLabel lblNombreClave = new JLabel("Nombre \u00F3 Clave");
		lblNombreClave.setForeground(new Color(34, 139, 34));
		lblNombreClave.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreClave.setBounds(57, 11, 88, 14);
		layeredPane_1.add(lblNombreClave);
		
		txtBuscarInventario = new JTextField();
		txtBuscarInventario.setBounds(10, 30, 175, 20);
		layeredPane_1.add(txtBuscarInventario);
		txtBuscarInventario.setColumns(10);
		
		Img n12=new Img();
		JButton btnBuscar = new JButton(n12.Buscar());
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String buscarString = txtBuscarInventario.getText();
				if (!buscarString.equals("")) {
					listarProductos(buscarString);
					txtBuscarInventario.setText("");
				}else{
					listarProductos("");
				}
			}
		});
		btnBuscar.setBounds(197, 21, 61, 39);
		layeredPane_1.add(btnBuscar);
		
		JRadioButton rdbtnProductosAgotados = new JRadioButton("Productos Agotados");
		rdbtnProductosAgotados.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				productosVacios("");
			}
		});
		rdbtnProductosAgotados.setForeground(new Color(34, 139, 34));
		rdbtnProductosAgotados.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnProductosAgotados.setBounds(286, 11, 139, 23);
		layeredPane_1.add(rdbtnProductosAgotados);
		
		JRadioButton rdbtnTodosLosRegistros = new JRadioButton("Todos los registros");
		rdbtnTodosLosRegistros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				listarProductos("");
			}
		});
		rdbtnTodosLosRegistros.setForeground(new Color(34, 139, 34));
		rdbtnTodosLosRegistros.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnTodosLosRegistros.setBounds(286, 46, 139, 23);
		layeredPane_1.add(rdbtnTodosLosRegistros);
		rb.add(rdbtnProductosAgotados);
		rb.add(rdbtnTodosLosRegistros);
		
		JButton btnExportar = new JButton("Exportar PDF");
		btnExportar.setBounds(463, 30, 111, 20);
		layeredPane_1.add(btnExportar);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "Lista de productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_2.setBounds(10, 119, 595, 231);
		layeredPane.add(layeredPane_2);
		layeredPane_2.setLayout(null);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 24, 575, 196);
		layeredPane_2.add(scrollPane1);
		
		
		tableProductos = new JTable(){
			public boolean isCellEditable(int rowIndex, int columnIndex) { 
				if (columnIndex==5) return true; 
				if (columnIndex==3) return false;
				if (columnIndex==2) return true;
				else 
				return false; 
				} 
		};
		scrollPane1.setColumnHeaderView(tableProductos);tableProductos.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Clave","Producto", "P.Distribuidor", "P.Gota", "P.Cliente", "Cantidad"
				}
			) {
				boolean[] columnEditables = new boolean[] {
					true, true, true, true, true, true, true, false
				};
				public boolean isCellEditable(int row, int column) {
					return columnEditables[column];
				}
			});
	}
}
