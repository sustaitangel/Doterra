package Productos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Conexion.Conectar;

import com.mysql.jdbc.PreparedStatement;

public class AgregarProducto {
	Conectar conex = new Conectar();
	java.sql.Connection con = conex.conexion(null);
	java.sql.Statement list;
	ResultSet rs;
	public void agregar(JTextField txtCodigo, JTextField txtUnidad, JTextField txtNombre, JTextField txtNombreEspanol, 
			JTextField txtPrecioCliente, JTextField txtPrecioDistribuidor, JTextField txtPrecioGota,
			JTextField txtPv, int tipo, JTextField txtCantidad ){
		try {
			Conectar cx=new Conectar();
			Connection cn=cx.conexion(null);
			JTextField hola = null;
			Statement comando;
			comando=(Statement) cn.createStatement();
			con = conex.conexion(hola);
			String existente="SELECT * FROM productos WHERE clave='"+txtCodigo.getText()+"'";
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(existente);
			if(rs.next()){
				JOptionPane.showMessageDialog(null, "El Producto ya existe");
			}else{
				if(txtCantidad.getText().length()==0){
					txtCantidad.setText("0");
				}
				
					String sql = "insert into productos (clave,nombre,nombre_espanol,unidad,precio_cliente," +
							"precio_distribuidor,precio_gota,pv,categoria_id_categoria, cantidad) values (?,?,?,?,?,?,?,?,?,?)";
					PreparedStatement ps = (PreparedStatement) con.prepareCall(sql);
					ps.setString(1, txtCodigo.getText());
					ps.setString(2, txtNombre.getText());
					ps.setString(3, txtNombreEspanol.getText());
					ps.setString(4, txtUnidad.getText());
					ps.setString(5, txtPrecioCliente.getText());
					ps.setString(6, txtPrecioDistribuidor.getText());
					ps.setString(7, txtPrecioGota.getText());
					ps.setString(8, txtPv.getText());
					ps.setLong(9, tipo);
					ps.setString(10, txtCantidad.getText());
				
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
