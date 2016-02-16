package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JTextField;

import Imagenes.Img;
import Principal.PanelPrincipal;
import Principal.PanelPrincipal;
import Principal.PanelPrincipal;
import Sqls.IniSesion;

import javax.swing.JButton;
import javax.swing.JPasswordField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setResizable(false);
		setTitle("-- doTerra-- Iniciar Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 460, 207);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setToolTipText("Bienvenido");
		lblBienvenido.setForeground(new Color(123, 104, 238));
		lblBienvenido.setFont(new Font("Franklin Gothic Book", Font.BOLD, 19));
		lblBienvenido.setBounds(146, 11, 106, 35);
		contentPane.add(lblBienvenido);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblUsuario.setForeground(new Color(34, 139, 34));
		lblUsuario.setBounds(38, 55, 57, 20);
		contentPane.add(lblUsuario);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
				String vacio=passwordField.getText();
				if(car==KeyEvent.VK_ENTER && vacio.length()==0 ){
					JOptionPane.showMessageDialog(textField, "Escriba Contraseña");
										
				}
				if(car==KeyEvent.VK_ENTER && vacio.length()!=0) {
						IniSesion ini=new IniSesion();
						ini.iniSecion(textField, passwordField);
						System.out.println("hola"+IniSesion.conta);
						if(IniSesion.conta>=5){
						
					}
				}
			}
		});
		textField.setBounds(105, 57, 124, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setForeground(new Color(34, 139, 34));
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblContrasena.setBounds(10, 100, 85, 20);
		contentPane.add(lblContrasena);
		
		Img n=new Img();
		JLabel lblNewLabel = new JLabel(n.login());
		lblNewLabel.setBounds(239, 44, 200, 79);
		contentPane.add(lblNewLabel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.this.dispose();
			}
		});
		btnCancelar.setBounds(77, 145, 106, 23);
		contentPane.add(btnCancelar);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String pass=new String(passwordField.getPassword());
				if(pass.length()==0){
					JOptionPane.showMessageDialog(textField, "Escriba Contraseña");
				}else{
				IniSesion ini=new IniSesion();
				ini.iniSecion(textField, passwordField);
				
				System.out.println("hola"+IniSesion.conta);
				}
			}
		});
		btnEntrar.setBounds(199, 145, 106, 23);
		contentPane.add(btnEntrar);
		
		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
				if(car==KeyEvent.VK_ENTER){
					IniSesion n=new IniSesion();
					n.iniSecion(textField, passwordField);
				}
			}
		});
		passwordField.setBounds(105, 102, 124, 20);
		contentPane.add(passwordField);
	}
}
