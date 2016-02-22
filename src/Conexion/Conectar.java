package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Usuarios.TipoUsuario;

public class Conectar {
	Connection conect = null;
	   public Connection conexion(JTextField hola)
	    {
	      try {  
	           //Cargamos el Driver MySQL
	           Class.forName("org.gjt.mm.mysql.Driver");
	           conect = DriverManager.getConnection("jdbc:mysql://localhost/doterra","root","sistemas");
	        } catch (Exception e) {
	            JOptionPane.showMessageDialog(hola, "Error"+e);
	        }
	        return conect;
	    }
	   public ArrayList<TipoUsuario> obtenerTipos(){
			
			ArrayList listipos = new ArrayList();
			String sentencia="select descripcion from perfil";
			try{
				Connection conexion=DriverManager.getConnection("jdbc:mysql://localhost/doterra","root" ,"sistemas");
				Statement comando=conexion.createStatement();
			
				ResultSet registro = comando.executeQuery(sentencia);
				String tipo;
				while(registro.next()){
					tipo=registro.getString(1);
					TipoUsuario tipos= new TipoUsuario(tipo);
					listipos.add(tipos);
				}
				registro.close();
				comando.close();
			}catch(SQLException ex){
				JOptionPane.showMessageDialog(null, ex.getMessage());
			}
			return listipos;
		}
	   
}
