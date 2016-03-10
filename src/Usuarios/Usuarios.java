package Usuarios;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import Conexion.Conectar;
import Imagenes.Img;
import Login.InSesion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class Usuarios extends JFrame {

	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtApaterno;
	private JTextField txtAmaterno;
	private JPasswordField passwordContrasena;
	private JPasswordField passwordRepetirContrasena;
	private JTextField txtNombreUsuario;
	int tipo;
	String tipo1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuarios frame = new Usuarios();
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
	public Usuarios() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InSesion.class.getResource("/Imagenes/logoin.png")));
		setTitle("--doTerra-- Usuarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "Alta de Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane.setBounds(10, 11, 414, 275);
		contentPane.add(layeredPane);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setForeground(new Color(34, 139, 34));
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombre.setBounds(94, 30, 58, 24);
		layeredPane.add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(159, 33, 134, 20);
		layeredPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido Paterno :");
		lblApellidoPaterno.setForeground(new Color(34, 139, 34));
		lblApellidoPaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoPaterno.setBounds(36, 53, 116, 24);
		layeredPane.add(lblApellidoPaterno);
		
		txtApaterno = new JTextField();
		txtApaterno.setBounds(159, 56, 134, 20);
		layeredPane.add(txtApaterno);
		txtApaterno.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido Materno :");
		lblApellidoMaterno.setForeground(new Color(34, 139, 34));
		lblApellidoMaterno.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblApellidoMaterno.setBounds(33, 77, 119, 24);
		layeredPane.add(lblApellidoMaterno);
		
		txtAmaterno = new JTextField();
		txtAmaterno.setBounds(159, 80, 134, 20);
		layeredPane.add(txtAmaterno);
		txtAmaterno.setColumns(10);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a :");
		lblContrasea.setForeground(new Color(34, 139, 34));
		lblContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblContrasea.setBounds(68, 99, 84, 24);
		layeredPane.add(lblContrasea);
		
		passwordContrasena = new JPasswordField();
		passwordContrasena.setBounds(159, 102, 134, 21);
		layeredPane.add(passwordContrasena);
		
		JLabel lblRepertirContrasea = new JLabel("Repertir Contrase\u00F1a :");
		lblRepertirContrasea.setForeground(new Color(34, 139, 34));
		lblRepertirContrasea.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRepertirContrasea.setBounds(10, 123, 142, 24);
		layeredPane.add(lblRepertirContrasea);
		
		passwordRepetirContrasena = new JPasswordField();
		passwordRepetirContrasena.setBounds(159, 126, 134, 21);
		layeredPane.add(passwordRepetirContrasena);
		
		JLabel lblTipoDeUsuario = new JLabel("Tipo De Usuario :");
		lblTipoDeUsuario.setForeground(new Color(34, 139, 34));
		lblTipoDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTipoDeUsuario.setBounds(44, 148, 108, 24);
		layeredPane.add(lblTipoDeUsuario);
		
		JComboBox comboBoxTipoUsuario = new JComboBox();
		comboBoxTipoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tipo1=(String)comboBoxTipoUsuario.getSelectedItem();
				 if(tipo1.equals("Administrador"))
				 {
					 tipo=1;
				 }
				 if(tipo1.equals("Empleado"))
				 {
					 tipo=2;
				 }
			}
		});
		
		Conectar con=new Conectar();
		ArrayList<TipoUsuario>lista1= con.obtenerTipos();
		for (int i=0;i<lista1.size();i++)
		{
			TipoUsuario otipo=lista1.get(i);
			comboBoxTipoUsuario.addItem(otipo.getNombreArticulo());
		
		}
		comboBoxTipoUsuario.setBounds(159, 151, 134, 21);
		layeredPane.add(comboBoxTipoUsuario);
		
		Img n22 = new Img();
		JButton btnCancelar = new JButton(n22.btnCancelar());
		btnCancelar.setBounds(204, 212, 89, 34);
		layeredPane.add(btnCancelar);
		
		Img n23 = new Img();
		JButton btnGuardar = new JButton(n23.btnGuardar());
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AltaDtb alta=new AltaDtb();
				alta.altaUsuario(txtNombre, txtApaterno, txtAmaterno, passwordContrasena, 
						passwordRepetirContrasena, txtNombreUsuario, tipo);
			}
		});
		btnGuardar.setBounds(94, 212, 89, 34);
		layeredPane.add(btnGuardar);
		
		JLabel lblNombreDeUsuario = new JLabel("Nombre de usuario :");
		lblNombreDeUsuario.setForeground(new Color(34, 139, 34));
		lblNombreDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNombreDeUsuario.setBounds(22, 177, 130, 24);
		layeredPane.add(lblNombreDeUsuario);
		
		txtNombreUsuario = new JTextField();
		txtNombreUsuario.setBounds(159, 183, 134, 20);
		layeredPane.add(txtNombreUsuario);
		txtNombreUsuario.setColumns(10);
	}
}
