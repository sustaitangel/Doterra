package Reportes;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import Imagenes.Img;
import Login.InSesion;
import Reporte.GeneradordeReportes;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;

import com.toedter.calendar.JDayChooser;

import java.awt.Button;

public class ReporteVentas extends JFrame {

	private JPanel contentPane;
	private JTextField txtFolio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReporteVentas frame = new ReporteVentas();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ReporteVentas() {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(InSesion.class.getResource("/Imagenes/logoin.png")));
		setTitle("--doTerra-- Reporte Ventas--");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 569, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		final JDateChooser dateChooser_2 = new JDateChooser();
		final JDateChooser dateChooser = new JDateChooser();
		final JDateChooser dateChooser_1 = new JDateChooser();
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "Reporte de Ventas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane.setBounds(10, 10, 553, 295);
		contentPane.add(layeredPane);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "Venta del D\u00EDa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_1.setBounds(10, 28, 533, 159);
		layeredPane.add(layeredPane_1);
		
		JLabel lblSeleccioneElDia = new JLabel("Seleccione el dia :");
		lblSeleccioneElDia.setForeground(new Color(34, 139, 34));
		lblSeleccioneElDia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccioneElDia.setBounds(10, 39, 115, 23);
		layeredPane_1.add(lblSeleccioneElDia);
		
		
		Img n25 = new Img ();
		JButton btnReporteDia = new JButton(n25.GenerarReporte());
		btnReporteDia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ano = dateChooser_2.getCalendar().get(Calendar.YEAR);
				int mes = dateChooser_2.getCalendar().get(Calendar.MONTH) + 1;
				int dia = dateChooser_2.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fecha= String.valueOf(ano)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia);
				GeneradordeReportes n= new GeneradordeReportes();
				n.venta(fecha);
			}
		});
		btnReporteDia.setBounds(254, 34, 82, 28);
		layeredPane_1.add(btnReporteDia);
		
		dateChooser_2.setBounds(135, 39, 109, 23);
		layeredPane_1.add(dateChooser_2);
		
		JLabel lblSeleccioneDelDia = new JLabel("Seleccione del dia :");
		lblSeleccioneDelDia.setForeground(new Color(34, 139, 34));
		lblSeleccioneDelDia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccioneDelDia.setBounds(10, 89, 123, 23);
		layeredPane_1.add(lblSeleccioneDelDia);
		
		dateChooser.setBounds(135, 89, 109, 23);
		layeredPane_1.add(dateChooser);
		
		JLabel lblAlDia = new JLabel("Al dia :");
		lblAlDia.setForeground(new Color(34, 139, 34));
		lblAlDia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblAlDia.setBounds(254, 93, 46, 14);
		layeredPane_1.add(lblAlDia);
		
		dateChooser_1.setBounds(310, 89, 109, 23);
		layeredPane_1.add(dateChooser_1);
		
		Img n60 = new Img ();
		JButton btnGenerar = new JButton(n60.GenerarReporte());
		btnGenerar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ano = dateChooser.getCalendar().get(Calendar.YEAR);
				int mes = dateChooser.getCalendar().get(Calendar.MONTH) + 1;
				int dia = dateChooser.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fecha= String.valueOf(ano)+"-"+String.valueOf(mes)+"-"+String.valueOf(dia);
				
				int ano1 = dateChooser_1.getCalendar().get(Calendar.YEAR);
				int mes1 = dateChooser_1.getCalendar().get(Calendar.MONTH) + 1;
				int dia1 = dateChooser_1.getCalendar().get(Calendar.DAY_OF_MONTH);
				String fecha1= String.valueOf(ano1)+"-"+String.valueOf(mes1)+"-"+String.valueOf(dia1);
				
				GeneradordeReportes n= new GeneradordeReportes();
				n.venta1(fecha,fecha1);
			}
		});
		btnGenerar.setBounds(423, 84, 82, 28);
		layeredPane_1.add(btnGenerar);
		
	
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "Detalle de Venta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_2.setBounds(10, 195, 533, 86);
		layeredPane.add(layeredPane_2);
		
		JLabel lblFolioVenta = new JLabel("Folio Venta :");
		lblFolioVenta.setBounds(24, 37, 90, 22);
		layeredPane_2.add(lblFolioVenta);
		lblFolioVenta.setForeground(new Color(34, 139, 34));
		lblFolioVenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtFolio = new JTextField();
		txtFolio.setBounds(108, 39, 115, 20);
		layeredPane_2.add(txtFolio);
		txtFolio.setColumns(10);
		
		Img n26 = new Img();
		JButton btnDetalleVenta = new JButton(n26.GenerarReporte());
		btnDetalleVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String folio=txtFolio.getText();
				GeneradordeReportes c= new GeneradordeReportes();
				c.ventaFolio(folio);
			}
		});
		btnDetalleVenta.setBounds(233, 38, 82, 28);
		layeredPane_2.add(btnDetalleVenta);
	}
}
