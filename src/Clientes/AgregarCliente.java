package Clientes;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Conexion.Conectar;

import com.mysql.jdbc.PreparedStatement;
public class AgregarCliente {
	Conectar conex = new Conectar();
	java.sql.Connection con = conex.conexion(null);
	java.sql.Statement list;
	ResultSet rs;
	public void agregar(JTextField txtId, JTextField txtNombre, JTextField txtApaterno, JTextField txtAmaterno, 
			JTextField txtEmail, JTextField txtTelefono ){
		try {
			Conectar cx=new Conectar();
			Connection cn=cx.conexion(null);
			JTextField hola = null;
			Statement comando;
			comando=(Statement) cn.createStatement();
			con = conex.conexion(hola);
			String existente="SELECT * FROM clientes WHERE id='"+txtId.getText()+"'";
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(existente);
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "El Producto ya existe");
			}else{
				if(txtId.getText().length()==0){
					txtId.setText("0");
				}
				
					String sql = "insert into clientes (id,nombre,a_paterno,a_materno,email," +
							"telefono) values (?,?,?,?,?,?)";
					PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
					ps.setString(1, txtId.getText());
					ps.setString(2, txtNombre.getText());
					ps.setString(3, txtApaterno.getText());
					ps.setString(4, txtAmaterno.getText());
					ps.setString(5, txtEmail.getText());
					ps.setString(6, txtTelefono.getText());
				
					int n = ps.executeUpdate();
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "Registro agregado correctamente");
					}
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
		}
	}

}
