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

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

import Clientes.Clientes;
import Imagenes.Img;
import Principal.RelojFecha;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;

public class VentaProductos extends JFrame {

	private JPanel contentPane;
	private JTextField txtImporte;
	private JTextField txtTotalpv;
	private JTextField txtTotal;
	private JTable table;
	public static String tp;
	private static   String matriz[][]={};
	private static   String vector[]={"Código","Nombre","Tipo de Venta","PV","Cantidad"};
	public static   DefaultTableModel modelo1= new DefaultTableModel(matriz,vector);
	public JLabel lblDt = new JLabel();
	RelojFecha relojFecha = new RelojFecha();
	public JTextField txtClave = new JTextField();
	private ButtonGroup rb = new ButtonGroup();
	public static JTextField txtCliente = new JTextField();
	public int tipox;

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
		setBounds(100, 100, 617, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "Venta de Productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane.setBounds(10, 11, 581, 467);
		contentPane.add(layeredPane);
		
		JLabel lblClave = new JLabel("Clave :");
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClave.setForeground(new Color(34, 139, 34));
		lblClave.setBounds(22, 30, 46, 14);
		layeredPane.add(lblClave);
		txtClave.setEnabled(false);
		
		
		txtClave.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char ec=e.getKeyChar();
				String codigo=null;
				if(ec==KeyEvent.VK_ENTER){
					String vector[]={"Código","Nombre",tp,"PV","Cantidad"};
					DefaultTableModel modelo1= new DefaultTableModel(matriz,vector);
					table.setModel(modelo1);
					BuscarArticulo buscar=new BuscarArticulo();
					codigo=txtClave.getText();				
					buscar.buscar(tipox,table, codigo, modelo1,txtClave,txtClave);
					suma();
				}
			}
		});
		txtClave.setBounds(78, 29, 130, 20);
		layeredPane.add(txtClave);
		txtClave.setColumns(10);
		
		JLabel lblFolio = new JLabel("Folio:");
		lblFolio.setForeground(new Color(34, 139, 34));
		lblFolio.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFolio.setBounds(22, 79, 41, 14);
		layeredPane.add(lblFolio);
		Generador ob= new Generador();
		String folio= ob.folio();
		lblDt.setText(folio);
		lblDt.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDt.setForeground(new Color(34, 139, 34));
		lblDt.setBounds(58, 79, 73, 14);
		layeredPane.add(lblDt);
		
		JLabel lblFecha1 = new JLabel("Fecha:");
		lblFecha1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha1.setForeground(new Color(34, 139, 34));
		lblFecha1.setBounds(17, 97, 46, 14);
		layeredPane.add(lblFecha1);
		
		JLabel lblImporte = new JLabel("Importe :");
		lblImporte.setForeground(new Color(34, 139, 34));
		lblImporte.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblImporte.setBounds(347, 30, 67, 14);
		layeredPane.add(lblImporte);
		
		txtImporte = new JTextField();
		txtImporte.setBounds(424, 29, 86, 20);
		layeredPane.add(txtImporte);
		txtImporte.setColumns(10);
		
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
		btnTerminarventa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Calendar cal=Calendar.getInstance();
				int mes=cal.get(Calendar.MONTH);
				mes=mes+1;
				String folio1=lblDt.getText();
				String fecha1=cal.get(Calendar.YEAR)+"-"+mes+"-"+cal.get(Calendar.DATE);
				GuardarVenta ob= new GuardarVenta();
				ob.guardarventa( folio1, txtImporte, txtCliente, txtTotalpv, txtTotal, fecha1);
				ob.detalleVenta(modelo1, table, fecha1, folio1,txtCliente);
				ob.vaciar(table);
				limpiar();
				
				
			}
		});
		btnTerminarventa.setBounds(225, 416, 79, 40);
		layeredPane.add(btnTerminarventa);
		
		Img n15 = new Img();
		JButton btnCancelar = new JButton(n15.CancelarVenta());
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarArticulo n=new BuscarArticulo();
				int x=table.getSelectedColumn();
				int y=table.getSelectedRow();
				if(table.isCellSelected(y, x)){
					n.quitarFila(table, modelo1);
					suma();
				}else{
					JOptionPane.showMessageDialog(null, "Seleccione Artículo");
				}
			}
		});
		btnCancelar.setBounds(321, 416, 79, 40);
		layeredPane.add(btnCancelar);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "Carrito de Compras", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_1.setBounds(10, 184, 561, 226);
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
		txtCliente.setEnabled(false);
		txtCliente.setBounds(78, 54, 130, 20);
		layeredPane.add(txtCliente);
		txtCliente.setColumns(10);
		
		Img n40 = new Img();
		JButton btnVerClientes = new JButton(n40.btnVerClientes());
		btnVerClientes.setEnabled(false);
		btnVerClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clientes ob20 =  new Clientes();
				ob20.setVisible(true);
				ob20.setLocation(500,100);
			}
		});
		btnVerClientes.setBounds(218, 55, 86, 19);
		layeredPane.add(btnVerClientes);
		
		JLabel lblFecha = new JLabel("");
		lblFecha.setForeground(new Color(34, 139, 34));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFecha.setBounds(58, 97, 150, 14);
		relojFecha.fecha(lblFecha);
		layeredPane.add(lblFecha);
		
		JRadioButton rdbCliente = new JRadioButton("Venta Cliente");
		rdbCliente.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtClave.setEnabled(true);
				txtCliente.setEnabled(true);
				btnVerClientes.setEnabled(true);
				tp="Precio Cliente";
				String vector[]={"Código","Nombre",tp,"PV","Cantidad"};
				DefaultTableModel modelo1= new DefaultTableModel(matriz,vector);
				table.setModel(modelo1);
				tipox=1;
			}
		});
		rdbCliente.setBounds(22, 139, 138, 23);
		layeredPane.add(rdbCliente);
		
		JRadioButton rdbDistribuidor = new JRadioButton("Venta Distribuidor");
		rdbDistribuidor.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtClave.setEnabled(true);
				txtCliente.setEnabled(true);
				btnVerClientes.setEnabled(true);
				tp="Precio Distribuidor";
				String vector[]={"Código","Nombre",tp,"PV","Cantidad"};
				DefaultTableModel modelo1= new DefaultTableModel(matriz,vector);
				table.setModel(modelo1);
				tipox=2;
			}
		});
		rdbDistribuidor.setBounds(162, 139, 142, 23);
		layeredPane.add(rdbDistribuidor);
		
		JRadioButton rdbGota = new JRadioButton("Venta Gota");
		rdbGota.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtClave.setEnabled(true);
				txtCliente.setEnabled(true);
				btnVerClientes.setEnabled(true);
				tp="Precio gota";
				String vector[]={"Código","Nombre",tp,"PV","Cantidad"};
				DefaultTableModel modelo1= new DefaultTableModel(matriz,vector);
				table.setModel(modelo1);
				tipox=3;
			}
		});
		rdbGota.setBounds(306, 139, 109, 23);
		layeredPane.add(rdbGota);
		
		rb.add(rdbGota);
		rb.add(rdbDistribuidor);
		rb.add(rdbCliente);
	}
	public void suma(){
		int j=table.getRowCount()-1;
		if(j>=0){
			float n2=0;
			float n2x=0;
			for(int i=0;i<=j;i++){
				float n= Float.parseFloat(table.getValueAt(i, 2).toString());
				float cantidad=Integer.parseInt(table.getValueAt(i, 4).toString());
				float n1=n*cantidad;
				float nx=n= Float.parseFloat(table.getValueAt(i, 2).toString());
				n2=n2+n1;
				DecimalFormat formateador = new DecimalFormat(".##");
				DecimalFormat formateador1 = new DecimalFormat(".##");
				formateador.format(n2);
				
				n2x=n2x+nx;
				txtTotal.setText(String.valueOf(formateador1.format(n2x)));
			}
			float n3=0;
			float n2x3=0;
			for(int i=0;i<=j;i++){
				float n12= Float.parseFloat(table.getValueAt(i, 3).toString());
				float cantidad=Integer.parseInt(table.getValueAt(i, 4).toString());
				float n1=n12*cantidad;
				float nx=n12= Float.parseFloat(table.getValueAt(i, 3).toString());
				n3=n3+n1;
				DecimalFormat formateador = new DecimalFormat(".##");
				DecimalFormat formateador1 = new DecimalFormat(".##");
				formateador.format(n2);
				
				n2x3=n2x3+nx;
				txtTotalpv.setText(String.valueOf(formateador1.format(n2x3)));
			}
		}else{
			txtTotal.setText("0.0");
			//txtSubtotal.setText("0.0");
			txtImporte.setText("");
			
			//txtCambio.setText("");
		}
	}
	public void limpiar(){
		txtTotal.setText("0.0");
		txtImporte.setText("");
		txtTotalpv.setText("0.0");
		txtCliente.setText("");
		Generador ob= new Generador();
		String folio= ob.folio();
		lblDt.setText(folio);
	}
}
