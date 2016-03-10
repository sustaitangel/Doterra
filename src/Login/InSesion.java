package Login;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

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
import Principal.Principal;
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

public class InSesion extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsuario;
	private JPasswordField pswContra;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InSesion frame = new InSesion();
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
	public InSesion() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InSesion.class.getResource("/Imagenes/logoin.png")));
		setResizable(false);
		setTitle("-- doTerra-- Iniciar Sesion");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblBienvenido.setForeground(new Color(128, 0, 128));
		lblBienvenido.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		contentPane.add(lblBienvenido, "2, 1, 3, 1, right, fill");
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsuario.setForeground(new Color(34, 139, 34));
		contentPane.add(lblUsuario, "4, 3, center, fill");
		
		txtUsuario = new JTextField();
		txtUsuario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
				String vacio=pswContra.getText();
				if(car==KeyEvent.VK_ENTER && vacio.length()==0 ){
					JOptionPane.showMessageDialog(txtUsuario, "Escriba Contraseña");
										
				}
				if(car==KeyEvent.VK_ENTER && vacio.length()!=0) {
						IniSesion ini=new IniSesion();
						ini.iniSecion(txtUsuario, pswContra);
						System.out.println("hola"+IniSesion.conta);
						InSesion.this.dispose();
						if(IniSesion.conta>=5){
						
					}
				}
			}
		});
		contentPane.add(txtUsuario, "6, 3, 3, 1, fill, top");
		txtUsuario.setColumns(10);
		
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
				InSesion.this.dispose();
			}
		});
		contentPane.add(btnCancelar, "4, 7, 3, 1, fill, fill");
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String pass=new String(pswContra.getPassword());
				if(pass.length()==0){
					JOptionPane.showMessageDialog(txtUsuario, "Escriba Contraseña");
				}else{
					Iniciar ini=new Iniciar();
					ini.iniSecion(txtUsuario, pswContra);

					System.out.println("hola"+Iniciar.conta);
					if(Iniciar.conta>=5){
						
						JOptionPane.showMessageDialog(txtUsuario,"Ha Excedido el número de intentos");
						Principal x=new Principal();
						x.bloqueo();
	}
}
			}
		});
		contentPane.add(btnEntrar, "8, 7, fill, fill");
		
		pswContra = new JPasswordField();
		pswContra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char car=e.getKeyChar();
				if(car==KeyEvent.VK_ENTER){

					String pass=new String(pswContra.getPassword());
					if(pass.length()==0){
						JOptionPane.showMessageDialog(txtUsuario, "Escriba Contraseña");
					}else{
						Iniciar ini=new Iniciar();
						ini.iniSecion(txtUsuario, pswContra);

						System.out.println("hola"+Iniciar.conta);
						if(Iniciar.conta>=5){
								
							JOptionPane.showMessageDialog(txtUsuario,"Ha Excedido el número de intentos");
							Principal x=new Principal();
							x.bloqueo();
	}
}
				}
			}
		});
		contentPane.add(pswContra, "6, 5, 3, 1, fill, top");
	}
}
