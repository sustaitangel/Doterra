package Reporte;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import Conexion.Conectar;

public class GeneradordeReportes {
	public void venta(String fecha){
		Conectar cx=new Conectar();
		Connection cn= cx.conexion(null);
		try{
			 String ubicacion=System.getProperty("user.dir")+"/src/Reporte/ReporteVentas.jasper";
			 @SuppressWarnings("deprecation")
			JasperReport reporte=(JasperReport)JRLoader.loadObjectFromFile(ubicacion);
			 Map modelo =new HashMap();
			 modelo.put("Fecha",fecha);
			 JasperPrint print =JasperFillManager.fillReport(reporte, modelo,cn);
			 JasperViewer view=new JasperViewer(print,false);
			 view.setVisible(true);
			
		}catch(Exception ek){
			JOptionPane.showMessageDialog(null, ek);
		}
	}
	public void venta1(String del,String al){
		Conectar cx=new Conectar();
		Connection cn= cx.conexion(null);
		try{
			 String ubicacion=System.getProperty("user.dir")+"/src/Reporte/ReporteVentas1.jasper";
			 @SuppressWarnings("deprecation")
			JasperReport reporte=(JasperReport)JRLoader.loadObjectFromFile(ubicacion);
			 Map modelo =new HashMap();
			 modelo.put("del",del);
			 modelo.put("al",al);
			 JasperPrint print =JasperFillManager.fillReport(reporte, modelo,cn);
			 JasperViewer view=new JasperViewer(print,false);
			 view.setVisible(true);
			
		}catch(Exception ek){
			JOptionPane.showMessageDialog(null, ek);
		}
	}
	public void ventaFolio(String folio){
		Conectar cx=new Conectar();
		Connection cn= cx.conexion(null);
		try{
			 String ubicacion=System.getProperty("user.dir")+"/src/Reporte/FolioVenta.jasper";
			 @SuppressWarnings("deprecation")
			JasperReport reporte=(JasperReport)JRLoader.loadObjectFromFile(ubicacion);
			 Map modelo =new HashMap();
			 modelo.put("folio",folio);
			 JasperPrint print =JasperFillManager.fillReport(reporte, modelo,cn);
			 JasperViewer view=new JasperViewer(print,false);
			 view.setVisible(true);
			
		}catch(Exception ek){
			JOptionPane.showMessageDialog(null, ek);
		}
	}

}
