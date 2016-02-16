package Reportes;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import Imagenes.Img;

import com.toedter.calendar.JDateChooser;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ReporteVentas extends JFrame {

	private JPanel contentPane;
	private JTextField txtFolioVenta;

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
		setTitle("--doTerra-- Reporte Ventas--");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 277);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "Reporte de Ventas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane.setBounds(10, 10, 414, 225);
		contentPane.add(layeredPane);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "Venta del D\u00EDa", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_1.setBounds(10, 25, 394, 94);
		layeredPane.add(layeredPane_1);
		
		JLabel lblSeleccioneElDia = new JLabel("Seleccione el dia :");
		lblSeleccioneElDia.setForeground(new Color(34, 139, 34));
		lblSeleccioneElDia.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSeleccioneElDia.setBounds(21, 41, 115, 23);
		layeredPane_1.add(lblSeleccioneElDia);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(146, 44, 134, 20);
		layeredPane_1.add(dateChooser);
		
		Img n25 = new Img ();
		JButton btnReporteDia = new JButton(n25.GenerarReporte());
		btnReporteDia.setBounds(290, 39, 82, 28);
		layeredPane_1.add(btnReporteDia);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "Detalle de Venta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_2.setBounds(10, 129, 394, 86);
		layeredPane.add(layeredPane_2);
		
		JLabel lblFolioVenta = new JLabel("Folio Venta :");
		lblFolioVenta.setBounds(24, 37, 90, 22);
		layeredPane_2.add(lblFolioVenta);
		lblFolioVenta.setForeground(new Color(34, 139, 34));
		lblFolioVenta.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		txtFolioVenta = new JTextField();
		txtFolioVenta.setBounds(108, 39, 115, 20);
		layeredPane_2.add(txtFolioVenta);
		txtFolioVenta.setColumns(10);
		
		Img n26 = new Img();
		JButton btnDetalleVenta = new JButton(n26.GenerarReporte());
		btnDetalleVenta.setBounds(233, 38, 82, 28);
		layeredPane_2.add(btnDetalleVenta);
	}
}
