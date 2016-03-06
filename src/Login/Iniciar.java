package Login;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Conexion.Conectar;
import Imagenes.Img;
import Principal.PanelPrincipal;
import Principal.PanelPrincipal1;
import Principal.Principal;
import Usuarios.EncriptacionPrincipal;

public class Iniciar {
	public static int conta=1;
	public static String loger="";
	public static String loger1="";
	public void abrir() throws SQLException{
		 
		PanelPrincipal prin =new PanelPrincipal();
		prin.setVisible(true);
		
	}
	public void  iniSecion(JTextField txtUsuario,JPasswordField pswContra){
		
		Conectar n=new Conectar();
		System.out.println(conta);
		if(conta>=6){
			Principal boq=new Principal ();
			boq.bloqueo();
			txtUsuario.setText("");
			pswContra.setText("");
			
		}else{
		String tipoUsuario=null;
		Connection cx= n.conexion(txtUsuario);
		String sql="select * from usuarios where usuario='"+txtUsuario.getText()+"'";
		Statement comando1;
		
		try {
			comando1 = cx.createStatement();
			comando1.execute(sql);
			ResultSet rs= comando1.executeQuery(sql);
			String pass=new String(pswContra.getPassword());
			EncriptacionPrincipal encrip=new EncriptacionPrincipal();
			String pasen=encrip.encriptar(pass);
			String sql2="select * from usuarios where password='"+pasen+"'";
			if(rs.next()){
				System.out.println("3");
				comando1.execute(sql2);
				rs= comando1.executeQuery(sql2);
				if(rs.next()){
					Icon echo;
					echo=new ImageIcon("src/Imagenes/ImgSesion.png");
					Img ob=new Img();
					String nombre=rs.getString("nombre");
					String apellido = rs.getString("apellido_paterno");
					String user=rs.getString("usuario");
					loger=nombre + " " + apellido + " (" + user + ")";
					loger1=user;
					String bienvenida="Bienvenid@ ";
					int tipo=rs.getInt("Perfil_id_perfil");
					if(tipo==1){
						JOptionPane.showMessageDialog(txtUsuario,bienvenida+nombre,"Bienvenido",JOptionPane.DEFAULT_OPTION,ob.login());
						Principal prin=new Principal();
						PanelPrincipal menpri=new PanelPrincipal();
						menpri.setVisible(true);
						prin.cerrar();
					}
					if(tipo==2){
						JOptionPane.showMessageDialog(txtUsuario,bienvenida+nombre,"Bienvenido",JOptionPane.DEFAULT_OPTION,ob.login());
						Principal prin=new Principal();
						PanelPrincipal1 menpri=new PanelPrincipal1();
						menpri.setVisible(true);
						prin.cerrar();
					}
					
				}else{
					String fail="Usuario o contraseña incorrectos";
					JOptionPane.showMessageDialog(txtUsuario,fail);
					conta++;
					
				}
				
			}else{
				String fail2="Usuario o Contraseña Incorrectos";
				JOptionPane.showMessageDialog(txtUsuario,fail2);
				conta++;
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(txtUsuario, "Ocurrio un error en la base de datos "+e);
			
			}
		}
		
		pswContra.setText("");
		
	}

		private String getResourse(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
