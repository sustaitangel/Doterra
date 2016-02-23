package Ventas;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Conexion.Conectar;

public class Generador {
		public String folio(){
			int nId=0;
			String folio="";
			 try {
		        	Conectar cx=new Conectar();
					Connection cn= cx.conexion(null);
					Statement comando;
					comando = cn.createStatement();
					String sql="SELECT * FROM ventas WHERE id_venta = (SELECT MAX(id_venta) from ventas)";	
					ResultSet rs= comando.executeQuery(sql);
					if(rs.next()){
						int id=rs.getInt("id_venta");
						nId=id+1;
						if(nId<=99){
							folio="DT000"+nId;
											}
						if(nId>100 &&nId<=999){
							folio="DT00"+nId;
						}
						if(nId>1000 &&nId<=9999){
							 folio="DT0"+nId;
						}
						if(nId>10000 &&nId<=99999){
							 folio="DT0"+nId;
						}
						if(nId>=100000){
							folio="DT"+nId;
						}
					}else{
						folio="DT0001";
					}
			 }catch(SQLException e){
				 JOptionPane.showMessageDialog(null,e);
			 }
			return folio;
			
		}
}
