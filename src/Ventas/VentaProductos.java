package Ventas;

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

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import Clientes.Clientes;
import Imagenes.Img;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class VentaProductos extends JFrame {

	private JPanel contentPane;
	private JTextField txtClave;
	private JTextField textField;
	private JTextField txtTotalpv;
	private JTextField txtTotal;
	private JTextField txtCliente;
	private JTable table;
	private static   String matriz[][]={};
	private static   String vector[]={"Código","Nombre","Precio Cliente","PV","Cantidad"};
	public static   DefaultTableModel modelo1= new DefaultTableModel(matriz,vector);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentaProductos frame = new VentaProductos();
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
	public VentaProductos() {
		setTitle("--doTerra--Venta de productos--");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 617, 470);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "Venta de Productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane.setBounds(10, 11, 581, 410);
		contentPane.add(layeredPane);
		
		JLabel lblClave = new JLabel("Clave :");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClave.setForeground(new Color(34, 139, 34));
		lblClave.setBounds(22, 30, 46, 14);
		layeredPane.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ec=e.getKeyChar();
				String codigo=null;
				if(ec==KeyEvent.VK_ENTER){
					BuscarArticulo buscar=new BuscarArticulo();
					codigo=txtClave.getText();				
					buscar.buscar(table, codigo, modelo1,txtClave,txtClave);
					//suma();
				}
			}
		});
		txtClave.setBounds(78, 29, 130, 20);
		layeredPane.add(txtClave);
		txtClave.setColumns(10);
		
		JLabel lblFolio = new JLabel("Folio :");
		lblFolio.setForeground(new Color(34, 139, 34));
		lblFolio.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFolio.setBounds(15, 79, 41, 14);
		layeredPane.add(lblFolio);
		
		JLabel lblDt = new JLabel("DT0001");
		lblDt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblDt.setForeground(new Color(34, 139, 34));
		lblDt.setBounds(66, 79, 73, 14);
		layeredPane.add(lblDt);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFecha.setForeground(new Color(34, 139, 34));
		lblFecha.setBounds(15, 97, 46, 14);
		layeredPane.add(lblFecha);
		
		JLabel lblImporte = new JLabel("Importe :");
		lblImporte.setForeground(new Color(34, 139, 34));
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblImporte.setBounds(347, 30, 67, 14);
		layeredPane.add(lblImporte);
		
		textField = new JTextField();
		textField.setBounds(424, 29, 86, 20);
		layeredPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblTotalPv = new JLabel("Total Pv :");
		lblTotalPv.setForeground(new Color(34, 139, 34));
		lblTotalPv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalPv.setBounds(349, 55, 65, 14);
		layeredPane.add(lblTotalPv);
		
		txtTotalpv = new JTextField();
		txtTotalpv.setBounds(424, 54, 86, 20);
		layeredPane.add(txtTotalpv);
		txtTotalpv.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total :");
		lblTotal.setForeground(new Color(34, 139, 34));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotal.setBounds(368, 79, 46, 14);
		layeredPane.add(lblTotal);
		
		txtTotal = new JTextField();
		txtTotal.setBounds(424, 78, 86, 20);
		layeredPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		Img n14 = new Img();
		JButton btnTerminarventa = new JButton(n14.TerminarVenta());
		btnTerminarventa.setBounds(225, 359, 79, 40);
		layeredPane.add(btnTerminarventa);
		
		Img n15 = new Img();
		JButton btnCancelar = new JButton(n15.CancelarVenta());
		btnCancelar.setBounds(318, 359, 79, 40);
		layeredPane.add(btnCancelar);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "Carrito de Compras", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_1.setBounds(10, 122, 561, 226);
		layeredPane.add(layeredPane_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 27, 541, 188);
		layeredPane_1.add(scrollPane);
		
		table = new JTable(){
			public boolean isCellEditable(int rowIndex, int columnIndex) { 
				if (columnIndex==5) return true; 
				if (columnIndex==3) return false;
				if (columnIndex==2) return true;
				else 
				return false; 
				} 
		};
		
		scrollPane.setColumnHeaderView(table);
		scrollPane.setViewportView(table);
		table.setModel(modelo1);
		table.getColumnModel().getColumn(3).setPreferredWidth(5);
		table.getColumnModel().getColumn(3).setPreferredWidth(5);
		table.getColumnModel().getColumn(4).setPreferredWidth(5);
		
		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setForeground(new Color(34, 139, 34));
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCliente.setBounds(12, 54, 56, 14);
		layeredPane.add(lblCliente);
		
		txtCliente = new JTextField();
		txtCliente.setBounds(78, 54, 130, 20);
		layeredPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		Img n40 = new Img();
		JButton btnVerClientes = new JButton(n40.btnVerClientes());
		btnVerClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clientes ob20 =  new Clientes();
				ob20.setVisible(true);
				ob20.setLocation(500,100);
			}
		});
		btnVerClientes.setBounds(218, 30, 86, 19);
		layeredPane.add(btnVerClientes);
	}
}
