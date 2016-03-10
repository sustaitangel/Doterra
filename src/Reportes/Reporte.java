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

import javax.swing.JButton;

import Imagenes.Img;
import Inventario.Inventario;
import Login.InSesion;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reporte extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reporte frame = new Reporte();
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
	public Reporte() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(InSesion.class.getResource("/Imagenes/logoin.png")));
		setTitle("--doTerra-- Reportes --");
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 309, 151);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(null, "Reportes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane.setBounds(10, 11, 270, 92);
		contentPane.add(layeredPane);
		
		Img n20= new Img();
		JButton btnReporteProductos = new JButton(n20.ReporteProductos());
		btnReporteProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			       Inventario ob6 = new Inventario();
			       ob6.setVisible(true);
			       ob6.setLocation(500,100);
			}
		});
		btnReporteProductos.setBounds(39, 21, 89, 49);
		layeredPane.add(btnReporteProductos);
		
		Img n21 = new Img();
		JButton btnReporteVentas = new JButton(n21.ReporteVentas());
		btnReporteVentas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReporteVentas ob10 = new ReporteVentas();
				ob10.setVisible(true);
				ob10.setLocation(500,100);
			}
		});
		btnReporteVentas.setBounds(138, 21, 89, 49);
		layeredPane.add(btnReporteVentas);
	}
}
