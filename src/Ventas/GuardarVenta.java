package Ventas;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Conexion.Conectar;

public class GuardarVenta {
	public void guardarventa(String folio, JTextField txtefectivo,JTextField txtCliente,JTextField txtSubtotal,JTextField txtTotal,
			String fecha ){
		String efectivo2=txtefectivo.getText();
		String subtotal2=txtSubtotal.getText();
		String total2=txtTotal.getText();
		float efectivo1=Float.parseFloat(efectivo2);
		float subtotal=Float.parseFloat(subtotal2);
		float total=Float.parseFloat(total2);

		Conectar cx=new Conectar();
		Connection cn=cx.conexion(null);
		
		String sql="INSERT INTO ventas (folio,cliente,importe,total_pv,total,fecha)VALUES('"+folio+"','"+txtCliente.getText()+"',"
				+ "'"+efectivo1+"','"+subtotal+"','"+total+"','"+fecha+"')";
		System.out.println(sql);
		try {
			
			Statement comando = (Statement) cn.createStatement();
			comando.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, e);
		}
	}
	
	public void detalleVenta(DefaultTableModel modelo1,JTable table_1,String fecha, String folio,JTextField txtCliente){
		try{
			Conectar cx=new Conectar();
			Connection cn= cx.conexion(null);
			for(int i=0;i<modelo1.getRowCount();i++){
				Statement comando;
				comando = cn.createStatement();
				String id1=(table_1.getValueAt(i, 0).toString());
				String nombre =(table_1.getValueAt(i, 1).toString());
				String Precio1=(table_1.getValueAt(i, 2).toString());
				float precio=Float.parseFloat(Precio1);
				String PrecioIva1=(table_1.getValueAt(i, 3).toString());
				float precioIva=Float.parseFloat(PrecioIva1);
				String cantidad1=(table_1.getValueAt(i, 4).toString());
				int cantidad = Integer.parseInt(cantidad1);
				String sql="INSERT INTO ventas_has_productos (folio,clave,nombre,precio,total_pv,cantidad,fecha, cliente)"
						+ "VALUES('"+folio+"','"+id1+"','"+nombre+"','"+precio+"','"+precioIva+"','"+cantidad+"','"+fecha+"','"+txtCliente.getText()+"')";
				comando.execute(sql);
				System.out.println(sql);
				
			}
			
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, e);
		}
	}
	public void vaciar(JTable table_1){
			try {
	            DefaultTableModel modelo1=(DefaultTableModel) table_1.getModel();
	            int filas=table_1.getRowCount();
	            for (int i = 0;filas>i; i++) {
	                modelo1.removeRow(0);
	            }
	        } catch (Exception e) {
				            //JOptionPane.showMessageDialog(null, "Seleccione la fila que desea quitar.");
				}
			}
}
