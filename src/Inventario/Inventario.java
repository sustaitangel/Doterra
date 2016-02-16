package Inventario;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLayeredPane;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

import java.awt.Color;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import Imagenes.Img;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

public class Inventario extends JFrame {

	private JPanel contentPane;
	private JTextField txtBuscarInventario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inventario frame = new Inventario();
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
	public Inventario() {
		setTitle("--doTerra-- Inventario de productos--");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 651, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Inventario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane.setBounds(10, 11, 615, 361);
		contentPane.add(layeredPane);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(null, "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_1.setBounds(10, 30, 595, 76);
		layeredPane.add(layeredPane_1);
		
		JLabel lblNombreClave = new JLabel("Nombre \u00F3 Clave");
		lblNombreClave.setForeground(new Color(34, 139, 34));
		lblNombreClave.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreClave.setBounds(57, 11, 88, 14);
		layeredPane_1.add(lblNombreClave);
		
		txtBuscarInventario = new JTextField();
		txtBuscarInventario.setBounds(10, 30, 175, 20);
		layeredPane_1.add(txtBuscarInventario);
		txtBuscarInventario.setColumns(10);
		
		Img n12=new Img();
		JButton btnBuscar = new JButton(n12.Buscar());
		btnBuscar.setBounds(197, 21, 61, 39);
		layeredPane_1.add(btnBuscar);
		
		JRadioButton rdbtnProductosAgotados = new JRadioButton("Productos Agotados");
		rdbtnProductosAgotados.setForeground(new Color(34, 139, 34));
		rdbtnProductosAgotados.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnProductosAgotados.setBounds(286, 11, 139, 23);
		layeredPane_1.add(rdbtnProductosAgotados);
		
		JRadioButton rdbtnTodosLosRegistros = new JRadioButton("Todos los registros");
		rdbtnTodosLosRegistros.setForeground(new Color(34, 139, 34));
		rdbtnTodosLosRegistros.setFont(new Font("Tahoma", Font.BOLD, 11));
		rdbtnTodosLosRegistros.setBounds(286, 46, 139, 23);
		layeredPane_1.add(rdbtnTodosLosRegistros);
		
		JButton btnExportar = new JButton("Exportar PDF");
		btnExportar.setBounds(463, 30, 111, 20);
		layeredPane_1.add(btnExportar);
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "Lista de productos", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_2.setBounds(10, 119, 595, 231);
		layeredPane.add(layeredPane_2);
		
		JScrollPane scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(10, 24, 575, 196);
		layeredPane_2.add(scrollPane1);
	}
}
