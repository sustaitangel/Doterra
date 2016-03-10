package Ventas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Conexion.Conectar;

public class BuscarArticulo {
	public void buscar(int tipox,JTable tabla,String txtCodigo,DefaultTableModel modelo,JTextField txtNombreProducto,JTextField txtNombre){
		Conectar cx=new Conectar();
		Connection cn= cx.conexion(null);
		String sql = null;
		if(tipox==1){
		 sql="SELECT clave, nombre, precio_cliente, pv  FROM productos where clave='"+txtCodigo+"'";
		}
		if(tipox==2){
			 sql="SELECT clave, nombre, precio_distribuidor, pv  FROM productos where clave='"+txtCodigo+"'";
			}
		if(tipox==3){
			 sql="SELECT clave, nombre, precio_gota, pv  FROM productos where clave='"+txtCodigo+"'";
			}
		int stok=existencia(txtCodigo);
		
		if(stok>=1){
			
		try {
			Statement comando;
			comando = cn.createStatement();	
			ResultSet rs01= comando.executeQuery(sql);
					ResultSetMetaData rsx1=rs01.getMetaData();
					int nColumn1=rsx1.getColumnCount();						
							while(rs01.next()){
								Object[] fila= new Object[nColumn1];
								for(int y=0;y<nColumn1;y++){
									fila[y]=rs01.getObject(y+1);
						}
								modelo.addRow(fila);;
						} 
							int cantidad=1;	
							calcular(tabla,cantidad,0,0,txtCodigo);
			
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error "+e);
				e.printStackTrace();
			}
		}
		if(stok==-1){
			System.out.println("agotado");
		}
		if(stok==0){
			JOptionPane.showMessageDialog(null, "El Producto Está Agotado ");
		}
		txtNombreProducto.setText("");
		txtNombre.setText("");
		
	}
	
	public void calcular(JTable tabla, int b, int seleccion,int memoria, String codigo){
		//JOptionPane.showMessageDialog(null, b);
		int filas= tabla.getRowCount();
		float iva;
		float precio;
		float precioiva;
		float preciopublico;
		int cantidad;
		int cantidadDb ;
		int nuevaCantidad;
		Conectar cx=new Conectar();
		Connection cn= cx.conexion(null);	
		Statement comando;
		String sql="";
		try{
			comando = cn.createStatement();
			int i=tabla.getRowCount () - 1;
			iva=Float.parseFloat(tabla.getValueAt(i, 3).toString());
			int exis=existencia(String.valueOf(codigo));
			cantidad=b;
			int elbueno=exis;
			if(exis>=1){
				
			if(tabla.getValueAt(i,4)==null){
				cantidad=1;
				tabla.setValueAt(cantidad, i, 4);
				precio=Float.parseFloat(tabla.getValueAt(i, 2).toString());
				iva=iva*100;
				precioiva=iva+precio;
				//nuevaCantidad=cantidadDb-cantidad;
				//sql="UPDATE productos SET cantidad ='"+nuevaCantidad+"'WHERE codigo='"+codigo+"'";
				//comando.execute(sql);
				preciopublico=(precioiva*cantidad);
				DecimalFormat formateador = new DecimalFormat(".##");
				//tabla.setValueAt(formateador.format(preciopublico), i, 4);
	 		}
			if(b>=1){
								
				iva=Float.parseFloat(tabla.getValueAt(seleccion, 3).toString());
				cantidad=b;
				precio=Float.parseFloat(tabla.getValueAt(seleccion, 2).toString());
				iva=iva*100;
				precioiva=iva+precio;
				cantidadDb=existencia(String.valueOf(codigo));
				//JOptionPane.showMessageDialog(null,(b-VentasProductos.memoria));
				if((b-memoria)<=cantidadDb){
				nuevaCantidad=cantidadDb-cantidad+memoria;
				sql="UPDATE productos SET cantidad ='"+nuevaCantidad+"'WHERE clave='"+codigo+"'";
				comando.execute(sql);
				preciopublico=(precioiva*cantidad);
				DecimalFormat formateador = new DecimalFormat(".##");
				//tabla.setValueAt(formateador.format(preciopublico), seleccion, 4);
				}else{
					JOptionPane.showMessageDialog(null, "No hay sufucientes en existencia");
					cantidad=b;					
					int b1=elbueno-cantidad;					
					int b2=b1+elbueno;					
					int j=memoria;
					if(j==1){
						elbueno=(b1*-1)+b2;
					}
					else if(j>1){
						int b3=(memoria+exis)-1;
						elbueno=b3;
					}
					
					tabla.setValueAt(1, i, 4);
					sql="UPDATE productos SET cantidad ='"+elbueno+"'WHERE clave='"+codigo+"'";
					comando.execute(sql);
					iva=Float.parseFloat(tabla.getValueAt(seleccion, 3).toString());
					precio=Float.parseFloat(tabla.getValueAt(i, 2).toString());
					iva=iva*100;
					precioiva=iva+precio;
					cantidad=1;
					preciopublico=(precioiva*cantidad);
					DecimalFormat formateador = new DecimalFormat(".##");
					//tabla.setValueAt(formateador.format(preciopublico), i, 4);
				}
				
			}
			
			if(b==1){
					iva=Float.parseFloat(tabla.getValueAt(seleccion, 3).toString());
					precio=Float.parseFloat(tabla.getValueAt(seleccion, 2).toString());
					iva=iva*100;
					precioiva=iva+precio;
					preciopublico=(precioiva*cantidad);
					DecimalFormat formateador = new DecimalFormat(".##");
					//tabla.setValueAt(formateador.format(preciopublico), seleccion, 4);
			}
			
			}else{
				cantidadDb=existencia(String.valueOf(codigo));
				int suma=memoria-cantidad;
				if(suma>=1&&cantidadDb==0){
					iva=Float.parseFloat(tabla.getValueAt(seleccion, 3).toString());
					cantidad=b;
					precio=Float.parseFloat(tabla.getValueAt(seleccion, 2).toString());
					iva=iva*100;
					precioiva=iva+precio;
					cantidadDb=existencia(String.valueOf(codigo));
					nuevaCantidad=cantidadDb+memoria-cantidad;
					sql="UPDATE productos SET cantidad ='"+nuevaCantidad+"'WHERE clave='"+codigo+"'";
					comando.execute(sql);
					//preciopublico=(precioiva*cantidad);
					DecimalFormat formateador = new DecimalFormat(".##");
					//tabla.setValueAt(formateador.format(preciopublico), seleccion, 4);
				}
				
			}
			
			
		}catch(SQLException e){
			
		}
	}
	
	public int existencia(String txtCodigo){
		Conectar cx=new Conectar();
		int ex=0;
		Connection cn= cx.conexion(null);
		String sql="SELECT * FROM productos where clave='"+txtCodigo+"'";
		
		try {
			Statement comando;
			comando = cn.createStatement();	
			ResultSet rs01= comando.executeQuery(sql);
			if(rs01.next()){
				ex=rs01.getInt("cantidad");
				
			}else{
				ex=-1;
				JOptionPane.showMessageDialog(null, "El producto no está dado de alta ");
			}
			
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error "+e);
				e.printStackTrace();
			}
		return ex;
	}
	public void quitarFila(JTable tabla_1,DefaultTableModel modelo1){
		Conectar cx=new Conectar();
		Connection cn= cx.conexion(null);	
		Statement comando;
		String sql="";
		int y=tabla_1.getSelectedRow();
		String codigo =tabla_1.getValueAt(y,0).toString();
		int actualTabla=Integer.parseInt(tabla_1.getValueAt(y, 4).toString());
		int exis=existencia(String.valueOf(codigo));
		int nuevaCantidad=exis+actualTabla;
		sql="UPDATE productos SET cantidad ='"+nuevaCantidad+"'WHERE clave='"+codigo+"'";
		try {
			comando = cn.createStatement();
			comando.execute(sql);
		    modelo1=(DefaultTableModel) tabla_1.getModel();
		    modelo1.removeRow(tabla_1.getSelectedRow());
				            //tabla_1.addRowSelectionInterval(0,0);
				           // modelo1=null;
				     } catch (Exception e) {
				            //JOptionPane.showMessageDialog(null, "Seleccione la fila que desea quitar.");
				        }

	}
	public void BuscarVenta(JTextField txtCodigo,JTable tabla,DefaultTableModel modelo, JLabel etiqueta){
		Conectar cx=new Conectar();
		Connection cn= cx.conexion(null);
		String sql="SELECT clave,nombre, precio, precioIva, cantidad FROM vista_detalleVenta where folio='"+txtCodigo.getText()+"'";
		String sql1="SELECT * FROM vistaVenta where folio='"+txtCodigo.getText()+"'";
		//(System.out.println(sql);
		try {
			Statement comando;
			comando = cn.createStatement();	
			ResultSet rs01= comando.executeQuery(sql);
			
					ResultSetMetaData rsx1=rs01.getMetaData();
					int nColumn1=rsx1.getColumnCount();						
							while(rs01.next()){
								Object[] fila= new Object[nColumn1];
								for(int y=0;y<nColumn1;y++){
									fila[y]=rs01.getObject(y+1);
						}
								modelo.addRow(fila);;
						} 
			
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error "+e);
				e.printStackTrace();
			}
		try{
			Statement comando;
			comando = cn.createStatement();	
			ResultSet rs02= comando.executeQuery(sql1);
			if(rs02.next()){
				float x=rs02.getFloat("total");
				float y= rs02.getFloat("descuento");
				float total=x+y;
				etiqueta.setText(String.valueOf(total));
				//JOptionPane.showMessageDialog(null, total);
			}
		}catch(SQLException e){
			JOptionPane.showMessageDialog(null, "Error "+e);
			e.printStackTrace();
		}
	}
}
