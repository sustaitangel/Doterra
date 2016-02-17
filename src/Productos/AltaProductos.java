package Productos;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

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

public class AltaProductos extends JFrame {

	private JPanel contentPane;
	private JTextField txtClave;
	private JTextField txtNombreProducto;
	private JTextField textField;
	private JTextField txtUnidad;
	private JTextField txtPrecioCliente;
	private JTextField txtPrecioDistribuidor;
	private JTextField txtPv;
	private JTextField txtBuscarProductos;
	private JTextField txtCantidad;
	private JTextField txtPrecioGota;
	int tipo=3;
	String tipo1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AltaProductos frame = new AltaProductos();
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
	public AltaProductos() {
		setTitle("--doTerra-- Alta Productos");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 558, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Alta de Productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(75, 0, 130)));
		layeredPane.setBounds(10, 10, 522, 417);
		contentPane.add(layeredPane);
		
		Img n7=new Img ();
		
		Img n8=new Img();
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 21, 502, 374);
		layeredPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Catalago de productos", null, panel, null);
		panel.setLayout(null);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_1.setBounds(10, 11, 477, 79);
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
		btnBuscar.setBounds(207, 27, 61, 41);
		layeredPane_1.add(btnBuscar);
		
		Img n11=new Img();
		JButton btnEliminar = new JButton(n11.Eliminar());
		btnEliminar.setBounds(278, 27, 61, 39);
		layeredPane_1.add(btnEliminar);
		
		Img n12=new Img();
		JButton btnActualizar = new JButton(n12.Actualizar());
		btnActualizar.setBounds(349, 27, 61, 39);
		layeredPane_1.add(btnActualizar);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "Lista de productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_2.setBounds(10, 104, 477, 231);
		panel.add(layeredPane_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 23, 457, 197);
		layeredPane_2.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Alta de Productos", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblClave = new JLabel("Clave :");
		lblClave.setForeground(new Color(34, 139, 34));
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblClave.setBounds(115, 12, 46, 22);
		panel_1.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setBounds(171, 14, 176, 22);
		panel_1.add(txtClave);
		txtClave.setColumns(10);
		JButton btnCancelar = new JButton(n7.btnCancelar());
		btnCancelar.setBounds(133, 301, 89, 34);
		panel_1.add(btnCancelar);
		JButton btnGuardar = new JButton(n8.btnGuardar());
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AgregarProducto n= new AgregarProducto();
				n.agregar(txtClave, txtUnidad, txtNombreProducto, textField, txtPrecioCliente, txtPrecioDistribuidor, txtPrecioGota, txtPv, tipo, txtCantidad);
				limpiar();	
			}
		});
		btnGuardar.setBounds(232, 301, 89, 34);
		panel_1.add(btnGuardar);
		
		JLabel lblCategoria = new JLabel("Categoria :");
		lblCategoria.setForeground(new Color(34, 139, 34));
		lblCategoria.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCategoria.setBounds(85, 45, 76, 22);
		panel_1.add(lblCategoria);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipo1=(String)comboBox.getSelectedItem();
				if(tipo1.equals("Kits de inscripcion")){
					tipo=3;
				}
				if(tipo1.equals("Mezclas de aceites")){
					tipo=2;
				}
				if(tipo1.equals("Puro de grado terapeutico")){
					tipo=1;
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Kits de inscripcion", "Puro de grado terapeutico", "Mezclas de aceites"}));
		comboBox.setBounds(167, 47, 176, 22);
		panel_1.add(comboBox);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del producto :");
		lblNombreDelProducto.setForeground(new Color(34, 139, 34));
		lblNombreDelProducto.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreDelProducto.setBounds(4, 78, 157, 22);
		panel_1.add(lblNombreDelProducto);
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setBounds(167, 80, 176, 22);
		panel_1.add(txtNombreProducto);
		txtNombreProducto.setColumns(10);
		
		JLabel lblNombreEspaol = new JLabel("Nombre espa\u00F1ol :");
		lblNombreEspaol.setForeground(new Color(34, 139, 34));
		lblNombreEspaol.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNombreEspaol.setBounds(39, 111, 122, 22);
		panel_1.add(lblNombreEspaol);
		
		textField = new JTextField();
		textField.setBounds(167, 113, 176, 22);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblUnidad = new JLabel("Unidad :");
		lblUnidad.setForeground(new Color(34, 139, 34));
		lblUnidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUnidad.setBounds(104, 144, 57, 22);
		panel_1.add(lblUnidad);
		
		txtUnidad = new JTextField();
		txtUnidad.setBounds(167, 146, 176, 22);
		panel_1.add(txtUnidad);
		txtUnidad.setColumns(10);
		
		JLabel lblPrecioCliente = new JLabel("Precio cliente :");
		lblPrecioCliente.setForeground(new Color(34, 139, 34));
		lblPrecioCliente.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioCliente.setBounds(62, 177, 99, 22);
		panel_1.add(lblPrecioCliente);
		
		txtPrecioCliente = new JTextField();
		txtPrecioCliente.setBounds(167, 179, 176, 22);
		panel_1.add(txtPrecioCliente);
		txtPrecioCliente.setColumns(10);
		
		JLabel lblPrecioDistribuidor = new JLabel("Precio distribuidor :");
		lblPrecioDistribuidor.setForeground(new Color(34, 139, 34));
		lblPrecioDistribuidor.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioDistribuidor.setBounds(27, 210, 134, 22);
		panel_1.add(lblPrecioDistribuidor);
		
		txtPrecioDistribuidor = new JTextField();
		txtPrecioDistribuidor.setBounds(167, 212, 176, 22);
		panel_1.add(txtPrecioDistribuidor);
		txtPrecioDistribuidor.setColumns(10);
		
		JLabel lblPv = new JLabel("PV :");
		lblPv.setForeground(new Color(34, 139, 34));
		lblPv.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPv.setBounds(133, 273, 28, 14);
		panel_1.add(lblPv);
		
		txtPv = new JTextField();
		txtPv.setBounds(167, 268, 144, 22);
		panel_1.add(txtPv);
		txtPv.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCantidad.setForeground(new Color(34, 139, 34));
		lblCantidad.setBounds(321, 269, 71, 22);
		panel_1.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(396, 271, 76, 22);
		panel_1.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		JLabel lblPrecioPorGota = new JLabel("Precio por gota :");
		lblPrecioPorGota.setForeground(new Color(34, 139, 34));
		lblPrecioPorGota.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrecioPorGota.setBounds(46, 243, 115, 19);
		panel_1.add(lblPrecioPorGota);
		
		txtPrecioGota = new JTextField();
		txtPrecioGota.setBounds(167, 242, 176, 22);
		panel_1.add(txtPrecioGota);
		txtPrecioGota.setColumns(10);
	}
	
	public void limpiar(){
		txtClave.setText("");
		txtNombreProducto.setText("");
		textField.setText("");
		txtUnidad.setText("");
		txtPrecioCliente.setText("");
		txtPrecioDistribuidor.setText("");
		txtPv.setText("");
		txtBuscarProductos.setText("");
		txtCantidad.setText("");
		txtPrecioGota.setText("");
		
	}
}
