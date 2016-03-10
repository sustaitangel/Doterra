package Principal;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

import Clientes.Clientes;
import Imagenes.Img;
import Inventario.Inventario;
import Login.InSesion;
import Login.Iniciar;
import Productos.AltaProductos;
import Reportes.Reporte;
import Sqls.IniSesion;
import Usuarios.Usuarios;
import Ventas.VentaProductos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelPrincipal1 extends JFrame {

	private JPanel contentPane;
	public static InSesion k=new InSesion();
	JLabel lblHora;
	RelojFecha relojFecha = new RelojFecha();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelPrincipal1 frame = new PanelPrincipal1();
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
	public PanelPrincipal1() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InSesion.class.getResource("/Imagenes/logoin.png")));
		setTitle("-- Vive doTerra - Vive doTERRA - Vive Sanamente , Vive doTERRA --");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 625, 411);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		Img n1=new Img();
		JButton btnProductos = new JButton(n1.btnProductos());
		btnProductos.setEnabled(false);
		btnProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaProductos ob=new  AltaProductos();
				ob.setVisible(true);
				ob.setLocation(500, 100);
			}
		});
		btnProductos.setBounds(10, 11, 89, 55);
		contentPane.add(btnProductos);
		
		Img n2=new Img();
		JButton btnPedidoProductos = new JButton(n2.btnVentas());
		btnPedidoProductos.setEnabled(false);
		btnPedidoProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentaProductos ob1 =new VentaProductos();
				ob1.setVisible(true);
				ob1.setLocation(500,100);
				
			}
		});
		btnPedidoProductos.setBounds(109, 11, 89, 55);
		contentPane.add(btnPedidoProductos);
		
		Img n3=new Img();
		JButton btnInventario = new JButton(n3.btnInventario());
		btnInventario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Inventario ob2 = new Inventario();
				ob2.setVisible(true);
				ob2.setLocation(500,100);
			}
		});
		btnInventario.setBounds(208, 11, 89, 55);
		contentPane.add(btnInventario);
		
		Img n4=new Img();
		JButton btnReportes = new JButton(n4.btnReportes());
		btnReportes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Reporte ob4 = new Reporte();
				ob4.setVisible(true);
				ob4.setLocation(500,100);
			}
		});
		btnReportes.setBounds(307, 11, 89, 55);
		contentPane.add(btnReportes);
		
		Img n5=new Img();
		JButton btnUsuarios = new JButton(n5.btnUsuarios());
		btnUsuarios.setEnabled(false);
		btnUsuarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Usuarios ob5 = new Usuarios();
				ob5.setVisible(true);
				ob5.setLocation(500,100);
			}
		});
		btnUsuarios.setBounds(506, 11, 89, 55);
		contentPane.add(btnUsuarios);
		
		Img n=new Img();
		JLabel lblNewLabel = new JLabel(n.fondo());
		lblNewLabel.setBounds(104, 116, 427, 170);
		contentPane.add(lblNewLabel);
		
		JLabel lblUstedEstEn = new JLabel("Usted est\u00E1 en el sistema c\u00F3mo :");
		lblUstedEstEn.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUstedEstEn.setForeground(new Color(147, 112, 219));
		lblUstedEstEn.setBounds(10, 335, 215, 26);
		contentPane.add(lblUstedEstEn);
		
		Img ob30 = new Img();
		JButton btnClientes = new JButton(ob30.btnClientes());
		btnClientes.setEnabled(false);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Clientes  ob10 = new Clientes();
				ob10.setVisible(true);
				ob10.setLocation(900,100);
			}
		});
		btnClientes.setBounds(407, 11, 89, 55);
		contentPane.add(btnClientes);
		
		JLabel lblUsuario = new JLabel();
		lblUsuario.setForeground(new Color(34, 139, 34));
		lblUsuario.setText(Iniciar.loger);
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblUsuario.setBounds(220, 335, 220, 26);
		contentPane.add(lblUsuario);
		JLabel lblFecha = new JLabel("");
		lblFecha.setForeground(new Color(34, 139, 34));
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFecha.setBounds(176, 297, 167, 27);
		relojFecha.fecha(lblFecha);
		contentPane.add(lblFecha);
		
		JLabel lblHora = new JLabel("");
		lblHora.setForeground(new Color(34, 139, 34));
		lblHora.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHora.setBounds(382, 297, 149, 27);
		contentPane.add(lblHora);
		relojFecha.reloj(lblHora);
	}
	public void cerrar(){
		k.dispose();
	}
}
