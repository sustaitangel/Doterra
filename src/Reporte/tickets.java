package Reporte;

import javax.swing.JOptionPane;

import Conexion.Conectar;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

public class tickets {
	public void ticket(String folio){
		Conectar cx=new Conectar();
		Connection cn= cx.conexion(null);
		try{
			 String ubicacion=System.getProperty("user.dir")+"/src/Reporte/TiquetVent.jasper";
			 @SuppressWarnings("deprecation")
			 Map modelo =new HashMap();
			 modelo.put("folio",folio);
			JasperReport reporte=(JasperReport)JRLoader.loadObjectFromFile(ubicacion);
			 JasperPrint print =JasperFillManager.fillReport(reporte, modelo,cn);
			 JasperViewer view=new JasperViewer(print,false);
			 view.setVisible(true);
			
		}catch (Exception ex) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Error  " + ex.getMessage());
		}
	}

}
