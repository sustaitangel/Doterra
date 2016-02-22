package Productos;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Conexion.Conectar;

import com.mysql.jdbc.PreparedStatement;

public class Componentes {
	JTextField hola = null;
	Conectar conex = new Conectar();
	java.sql.Connection con = conex.conexion(hola);
	java.sql.Statement list;
	ResultSet rs;
	
	void limpiar(JTextField codigo, JTextField nombre, 
			JTextArea descripcion, JTextField cantidad, JTextField precio){
		codigo.setText("");
		nombre.setText("");
		descripcion.setText("");
		cantidad.setText("");
		precio.setText("");
	}
	
	void mayusculas(KeyEvent e){
		char keyChar = e.getKeyChar();
	    if (Character.isLowerCase(keyChar)) {
	    	e.setKeyChar(Character.toUpperCase(keyChar));
	    }
	}
	
	void numerosEnteros(KeyEvent e){
		char c = e.getKeyChar();
		if(c < '0' || c > '9') e.consume();
	}
	
	void numerosFlotantes(JTextField campo,KeyEvent e){
		char c = e.getKeyChar();
		if ((c < '0' || c > '9') && campo.getText().contains(".") 
				&& (c!=(char)KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		} else if ((c < '0' || c > '9') && (c != '.') && (c!=(char)KeyEvent.VK_BACK_SPACE)) {
			e.consume();
		}
	}
	void habilitar(JButton eliminar, JButton actualizar){
		eliminar.setEnabled(true);
		actualizar.setEnabled(true);
	}
	
	void deshabilitar(JButton eliminar, JButton actualizar){
		eliminar.setEnabled(false);
		actualizar.setEnabled(false);
	}
	
	void eliminarProducto(JTable tableVerProductos){
		int replay = JOptionPane.showConfirmDialog(null, "El registro será eliminado. ¿Desea continuar?");
		if (replay == JOptionPane.YES_OPTION) {
			try {
				JTextField hola = null;
				con = conex.conexion(hola);
				String sql = "delete from productos where clave=" + tableVerProductos.getValueAt(tableVerProductos.getSelectedRow(), 0);
				list = con.createStatement();
				int n = list.executeUpdate(sql);
				if (n > 0) {
					JOptionPane.showMessageDialog(null, "Registro eliminado correctamente");
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Error " +  e.getMessage());
			}
		} else{}
	}
	void actualizarProductos1(JTextField txtClave,JTextField txtNombreProducto,
			JTextField txtPrecioCliente,JTextField txtCantidad,JTextField txtPrecioDistribuidor,JTextField txtPrecioGota,JTextField txtUnidad,JTextField txtPv){
		String sql="";
		Conectar cx=new Conectar();
		Connection cn=cx.conexion(null);
		Statement comando;
		con = conex.conexion(hola);
		String existente="SELECT * FROM productos WHERE clave='"+txtClave.getText()+"'";
		try {
			comando=(Statement) cn.createStatement();
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(existente);
			if(rs.next()){
				String cantidadDtb=rs.getString("cantidad");
				int cantidad=Integer.parseInt(cantidadDtb);
				String cantidadT= txtCantidad.getText();
				int cantidadTexto=Integer.parseInt(cantidadT);
				int ncant=cantidad+cantidadTexto;
					PreparedStatement ps;
					if (txtClave.equals("")) {
					
						sql = "update productos set cantidad = ? where clave = '" + txtClave.getText() + "'";
						ps = (PreparedStatement) con.prepareStatement(sql);
						ps.setInt(1, ncant);	
						}else {
						sql = "update productos set cantidad = ? where clave = '" +  txtClave.getText()+ "'";
						ps = (PreparedStatement) con.prepareStatement(sql);
						ps.setInt(1, ncant);
					}
					int n = ps.executeUpdate();
					if (n > 0) {
						//JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
					}
			}
						
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
		}
		
	}
	void actualizarProductos(JTextField txtClave,JTextField txtNombreProducto,
			JTextField txtPrecioCliente,JTextField txtCantidad,JTextField txtPrecioDistribuidor,JTextField txtPrecioGota,JTextField txtUnidad,JTextField txtPv){
		String sql="";
		Conectar cx=new Conectar();
		Connection cn=cx.conexion(null);
		Statement comando;
		con = conex.conexion(hola);
		String existente="SELECT * FROM productos WHERE Clave='"+txtClave.getText()+"'";
		try {
			comando=(Statement) cn.createStatement();
			ResultSet rs= ((java.sql.Statement) comando).executeQuery(existente);
			if(rs.next()){
				String cantidadDtb=rs.getString("cantidad");
				int cantidad=Integer.parseInt(cantidadDtb);
				String cantidadT= txtCantidad.getText();
				int cantidadTexto=Integer.parseInt(cantidadT);
				int ncant=cantidad+cantidadTexto;
					PreparedStatement ps;
					
						sql = "update productos set clave = ?, nombre = ?,precio_gota = ?, precio_cliente = ?," +
								"cantidad = ?, precio_distribuidor = ?,pv = ?,unidad = ? where id_producto = '" + "'";
						ps = (PreparedStatement) con.prepareStatement(sql);
						ps.setString(1, txtClave.getText());
						ps.setString(2, txtNombreProducto.getText());
						ps.setString(3, txtUnidad.getText());
						ps.setInt(4, ncant);
						ps.setString(5, txtPrecioCliente.getText());
						ps.setString(6, txtPrecioDistribuidor.getText());
						ps.setString(7, txtPrecioGota.getText());
						ps.setString(8, txtPv.getText());
			
			
						int n = ps.executeUpdate();
				
				if (n > 0) {
					JOptionPane.showMessageDialog(null, "Registro modificado correctamente");
				}
			}	
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null, "Error " + e.getMessage());
		}
		
	}
	
}
