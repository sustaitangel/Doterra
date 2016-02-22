package Productos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JButton;

import Productos.Componentes;
import Imagenes.Img;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModificarProductos extends JFrame {

	private JPanel contentPane;
	public static JTextField txtClave;
	public static JTextField txtNombreProducto;
	public static JTextField txtUnidad;
	public static JTextField txtPrecioCliente;
	public static JTextField txtPrecioDistribuidor;
	public static JTextField txtPrecioGota;
	public static JTextField txtPv;
	public static JTextField txtCantidad;
	Componentes componentes = new Componentes();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOptionPane.showMessageDialog(null, AltaProductos.Codigo+" aqui abro");
					ModificarProductos frame = new ModificarProductos();
					frame.setVisible(true);
					llenarCampos(AltaProductos.Codigo, null, null, null, null, null, null, null);
					JOptionPane.showMessageDialog(null, AltaProductos.Codigo+" aqui abro");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	static void llenarCampos(String Clave,String NombreProducto,
			String Cantidad,String Pv,String Unidad,String PrecioCliente,String PrecioDistribuidor,String PrecioGota){
		JOptionPane.showMessageDialog(null, AltaProductos.Codigo+" codigo de modificasr");
		txtClave.setText(AltaProductos.Codigo);
		txtNombreProducto.setText(NombreProducto);
		txtCantidad.setText(Cantidad);
		txtPv.setText(Pv);
		txtUnidad.setText(Unidad);
		txtPrecioCliente.setText(PrecioCliente);
		txtPrecioDistribuidor.setText(PrecioDistribuidor);
		txtPrecioDistribuidor.setText(PrecioDistribuidor);
	}
	
	public ModificarProductos() {
		setTitle("--doTerra--Modifcar Productos--");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "Modifcar Productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane.setBounds(10, 11, 414, 290);
		contentPane.add(layeredPane);
		
		JLabel lblClave = new JLabel("Clave :");
		lblClave.setForeground(new Color(34, 139, 34));
		lblClave.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblClave.setBounds(110, 27, 44, 14);
		layeredPane.add(lblClave);
		
		txtClave = new JTextField();
		txtClave.setBounds(162, 25, 117, 20);
		layeredPane.add(txtClave);
		txtClave.setColumns(10);
		
		JLabel lblNombreDelProducto = new JLabel("Nombre del Producto :");
		lblNombreDelProducto.setForeground(new Color(34, 139, 34));
		lblNombreDelProducto.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDelProducto.setBounds(10, 52, 144, 14);
		layeredPane.add(lblNombreDelProducto);
		
		txtNombreProducto = new JTextField();
		txtNombreProducto.setBounds(162, 50, 117, 20);
		layeredPane.add(txtNombreProducto);
		txtNombreProducto.setColumns(10);
		
		JLabel lblUnidad = new JLabel("Unidad :");
		lblUnidad.setForeground(new Color(34, 139, 34));
		lblUnidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUnidad.setBounds(102, 77, 52, 14);
		layeredPane.add(lblUnidad);
		
		txtUnidad = new JTextField();
		txtUnidad.setBounds(162, 75, 117, 20);
		layeredPane.add(txtUnidad);
		txtUnidad.setColumns(10);
		
		JLabel lblPrecioCliente = new JLabel("Precio Cliente :");
		lblPrecioCliente.setForeground(new Color(34, 139, 34));
		lblPrecioCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecioCliente.setBounds(57, 102, 97, 14);
		layeredPane.add(lblPrecioCliente);
		
		txtPrecioCliente = new JTextField();
		txtPrecioCliente.setBounds(162, 100, 117, 20);
		layeredPane.add(txtPrecioCliente);
		txtPrecioCliente.setColumns(10);
		
		JLabel lblPrecioDistribuidor = new JLabel("Precio Distribuidor :");
		lblPrecioDistribuidor.setForeground(new Color(34, 139, 34));
		lblPrecioDistribuidor.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecioDistribuidor.setBounds(26, 127, 128, 14);
		layeredPane.add(lblPrecioDistribuidor);
		
		txtPrecioDistribuidor = new JTextField();
		txtPrecioDistribuidor.setBounds(162, 125, 117, 20);
		layeredPane.add(txtPrecioDistribuidor);
		txtPrecioDistribuidor.setColumns(10);
		
		JLabel lblPrecioGota = new JLabel("Precio Gota :");
		lblPrecioGota.setForeground(new Color(34, 139, 34));
		lblPrecioGota.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPrecioGota.setBounds(71, 152, 83, 14);
		layeredPane.add(lblPrecioGota);
		
		txtPrecioGota = new JTextField();
		txtPrecioGota.setBounds(162, 150, 117, 20);
		layeredPane.add(txtPrecioGota);
		txtPrecioGota.setColumns(10);
		
		JLabel lblPv = new JLabel("PV :");
		lblPv.setForeground(new Color(34, 139, 34));
		lblPv.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPv.setBounds(128, 177, 26, 14);
		layeredPane.add(lblPv);
		
		txtPv = new JTextField();
		txtPv.setBounds(162, 175, 117, 20);
		layeredPane.add(txtPv);
		txtPv.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad :");
		lblCantidad.setForeground(new Color(34, 139, 34));
		lblCantidad.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCantidad.setBounds(88, 202, 66, 14);
		layeredPane.add(lblCantidad);
		
		txtCantidad = new JTextField();
		txtCantidad.setBounds(162, 200, 117, 20);
		layeredPane.add(txtCantidad);
		txtCantidad.setColumns(10);
		
		Img n55 = new Img ();
		JButton btnCancelar = new JButton(n55.btnCancelar());
		btnCancelar.setBounds(118, 231, 89, 34);
		layeredPane.add(btnCancelar);
		
		Img n56 = new Img();
		JButton btnGuardar = new JButton(n56.btnGuardar());
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int replay = JOptionPane.showConfirmDialog(null,"El registro será modificado. ¿Desea continuar?",
						"Confirmar",JOptionPane.YES_NO_OPTION);
				if (replay == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(null, txtClave.getText().length());
					if(txtClave.getText().length()!=0){
						JOptionPane.showMessageDialog(null, "entre");
							componentes.actualizarProductos(txtClave,txtNombreProducto,txtPrecioCliente,
									txtCantidad,txtPrecioDistribuidor,txtUnidad,txtPv,txtPrecioGota);
							
					}
				} else {}
			}
		});
		btnGuardar.setBounds(217, 231, 89, 34);
		layeredPane.add(btnGuardar);
	}
}
