package Usuarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Conexion.Conectar;

public class AltaDtb {
	public void altaUsuario(JTextField txtUsuario,JTextField txtApaterno,JTextField txtAmaterno,
			JPasswordField txtContrasena,JPasswordField txtRepetirContrasena, JTextField txtNombreUsuario,int tipo){
		Conectar cx=new Conectar();
		Connection cn=cx.conexion(txtNombreUsuario);
		Statement comando;
		if(txtNombreUsuario.getText().length()==0){
			JOptionPane.showMessageDialog(txtContrasena, "Use Un Nombre de Usuario");
		}else{
			try{
				comando=(Statement) cn.createStatement();
				String existente="Select * From usuarios where usuario='"+txtNombreUsuario.getText()+"'";
				ResultSet rs= ((java.sql.Statement) comando).executeQuery(existente);
				if(rs.next()){
					JOptionPane.showMessageDialog(txtNombreUsuario, "En nombre de usuario ya existe");
				}else{
					String pass= txtContrasena.getText();
					if(txtContrasena.getText().equals(txtRepetirContrasena.getText())){
						EncriptacionPrincipal pasen=new EncriptacionPrincipal();
						String PasEncriptado=pasen.encriptar(pass);
						String sqlGuardar="INSERT INTO usuarios (nombre,apellido_paterno,apellido_materno,password,"
								+ "usuario,Perfil_id_perfil)VALUES ('"+txtUsuario.getText()+"',"
								+ "'"+txtApaterno.getText()+"','"+txtAmaterno.getText()+"','"+PasEncriptado+"','"
										+ ""+txtNombreUsuario.getText()+"','"+tipo+"')";
						System.out.println(sqlGuardar);		
						comando.execute(sqlGuardar);
						Icon echo;
						echo=new ImageIcon("src/Imagenes/aplicar.png");
						JOptionPane.showMessageDialog(txtUsuario,"Usuario agregado exitosamente","Guardado",JOptionPane.DEFAULT_OPTION,echo);
						Limpiar(txtNombreUsuario, txtContrasena, txtRepetirContrasena,
								  txtAmaterno, txtApaterno, txtUsuario);
					}else{
						JOptionPane.showMessageDialog(txtContrasena, "Las contraseñas no coinciden");
					}
					
				}
			}catch(SQLException e){
				JOptionPane.showMessageDialog(txtContrasena, "Error "+e);
			}
			
		}
	}
	public void llenarCmb(JComboBox tipo){
		final JComboBox<String> comboBox = new JComboBox<String>();
		 Conectar con=new Conectar();
			ArrayList<TipoUsuario>lista1= con.obtenerTipos();
			for (int i=0;i<lista1.size();i++)
			{
				TipoUsuario otipo=lista1.get(i);
				comboBox.addItem(otipo.getNombreArticulo());
			
			}
	}
	
	
		public void Limpiar(JTextField txtUsuario,JTextField txtApaterno,JTextField txtAmaterno,
				JTextField txtAmaterno2,JTextField txtApaterno2,JTextField txtNombreUsuario){
			txtUsuario.setText("");
			txtApaterno.setText("");
			txtAmaterno.setText("");
			txtAmaterno2.setText("");
			txtApaterno2.setText("");
			txtNombreUsuario.setText("");
			}
		public void eliminar(JTextField txtBajaUsuario){
			Conectar cx=new Conectar();
			Connection cn=cx.conexion(txtBajaUsuario);
			Statement comando;
			int r=JOptionPane.showConfirmDialog(txtBajaUsuario,"¿Desea eliminar a "+txtBajaUsuario.getText()+"?",
					"Confirmar",JOptionPane.YES_NO_OPTION);
			
				
			if(r==JOptionPane.YES_OPTION){
			try {
				comando =(Statement) cn.createStatement();
				String sql1="SELECT * FROM usuarios WHERE usuario='"+txtBajaUsuario.getText()+"'";
				ResultSet rs=((java.sql.Statement) comando).executeQuery(sql1);
				if(rs.next()){
					String sql2="DELETE  from usuarios where usuario='"+txtBajaUsuario.getText()+"'";
					comando.execute(sql2);
					JOptionPane.showMessageDialog(txtBajaUsuario, "Se eliminó con éxito");
					limpiar(txtBajaUsuario);
					
				}else{
					JOptionPane.showMessageDialog(txtBajaUsuario, "El usario no existe");
					limpiar(txtBajaUsuario);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				JOptionPane.showMessageDialog(txtBajaUsuario, "error"+e1);
				limpiar(txtBajaUsuario);
			}
		}else{
			JOptionPane.showMessageDialog(txtBajaUsuario, "No se Eliminó");
			limpiar(txtBajaUsuario);
		}
		}
		public void limpiar(JTextField txtBajaUsuario){
			txtBajaUsuario.setText("");
		}

}
