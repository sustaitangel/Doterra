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
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;

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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 373, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("120px"),
				FormFactory.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("82px"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("13px"),
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("86px"),},
			new RowSpec[] {
				RowSpec.decode("20px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.PARAGRAPH_GAP_ROWSPEC,
				RowSpec.decode("20px"),
				FormFactory.UNRELATED_GAP_ROWSPEC,
				RowSpec.decode("20px"),}));
		
		JLabel lblBienvenido = new JLabel("Bienvenido");
		lblBienvenido.setToolTipText("Bienvenido");
		lblBienvenido.setForeground(new Color(123, 104, 238));
		lblBienvenido.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		contentPane.add(lblBienvenido, "2, 1, 3, 1, right, fill");
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setForeground(new Color(34, 139, 34));
		contentPane.add(lblUsuario, "4, 3, center, fill");
		
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
		contentPane.add(textField, "6, 3, 3, 1, fill, top");
		textField.setColumns(10);
		
		JLabel lblContrasena = new JLabel("Contrase\u00F1a:");
		lblContrasena.setForeground(new Color(34, 139, 34));
		lblContrasena.setFont(new Font("Tahoma", Font.BOLD, 12));
		contentPane.add(lblContrasena, "4, 5, left, fill");
		
		Img n=new Img();
		JLabel lblNewLabel = new JLabel(n.login());
		contentPane.add(lblNewLabel, "2, 3, 1, 3, left, bottom");
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login.this.dispose();
			}
		});
		contentPane.add(btnCancelar, "4, 7, 3, 1, fill, fill");
		
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
		contentPane.add(btnEntrar, "8, 7, fill, fill");
		
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
		contentPane.add(passwordField, "6, 5, 3, 1, fill, top");
	}
}
