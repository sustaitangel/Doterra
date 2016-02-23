package Clientes;

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
import javax.swing.JTabbedPane;
import javax.swing.Icon;
import javax.swing.JScrollPane;

public class Clientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clientes frame = new Clientes();
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
	public Clientes() {
		setTitle("--doTerra-- Alta Clientes--");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 549, 432);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Alta de Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane.setBounds(10, 11, 513, 371);
		contentPane.add(layeredPane);
		layeredPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 26, 493, 334);
		layeredPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Clientes", null, panel, null);
		panel.setLayout(null);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Buscar", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_1.setBounds(10, 11, 468, 73);
		panel.add(layeredPane_1);
		
		JLabel lblNombreOApellidos = new JLabel("Nombre o Apellidos");
		lblNombreOApellidos.setForeground(new Color(34, 139, 34));
		lblNombreOApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNombreOApellidos.setBounds(31, 11, 129, 21);
		layeredPane_1.add(lblNombreOApellidos);
		
		textField_6 = new JTextField();
		textField_6.setBounds(21, 31, 152, 21);
		layeredPane_1.add(textField_6);
		textField_6.setColumns(10);
		
		Img n39 = new Img();
		JButton btnBuscar = new JButton(n39.Buscar());
		btnBuscar.setBounds(199, 21, 61, 41);
		layeredPane_1.add(btnBuscar);
		
		Img n37 = new Img();
		JButton btnEliminar = new JButton(n37.Eliminar());
		btnEliminar.setBounds(270, 21, 61, 41);
		layeredPane_1.add(btnEliminar);
		
		Img n38 = new Img();
		
		JLayeredPane layeredPane_2 = new JLayeredPane();
		layeredPane_2.setBorder(new TitledBorder(null, "Clientes", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(128, 0, 128)));
		layeredPane_2.setBounds(10, 95, 468, 200);
		panel.add(layeredPane_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 21, 448, 168);
		layeredPane_2.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Alta Clientes", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("Id Cliente :");
		label.setForeground(new Color(34, 139, 34));
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		label.setBounds(131, 11, 70, 22);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(211, 13, 110, 20);
		panel_1.add(textField);
		
		JLabel label_1 = new JLabel("Nombre :");
		label_1.setForeground(new Color(34, 139, 34));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(141, 44, 58, 22);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(211, 44, 110, 20);
		panel_1.add(textField_1);
		
		JLabel label_2 = new JLabel("Apellido Paterno :");
		label_2.setForeground(new Color(34, 139, 34));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_2.setBounds(85, 77, 116, 14);
		panel_1.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(211, 75, 110, 20);
		panel_1.add(textField_2);
		
		JLabel label_3 = new JLabel("Apellido Materno :");
		label_3.setForeground(new Color(34, 139, 34));
		label_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_3.setBounds(82, 102, 119, 22);
		panel_1.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(211, 104, 110, 20);
		panel_1.add(textField_3);
		
		JLabel label_4 = new JLabel("e-mail :");
		label_4.setForeground(new Color(34, 139, 34));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_4.setBounds(153, 135, 48, 22);
		panel_1.add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(211, 135, 110, 22);
		panel_1.add(textField_4);
		
		JLabel label_5 = new JLabel("Telefono :");
		label_5.setForeground(new Color(34, 139, 34));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_5.setBounds(137, 163, 64, 22);
		panel_1.add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(211, 165, 110, 22);
		panel_1.add(textField_5);
		
		Img n35 = new Img ();
		JButton btnCancelar = new JButton(n35.btnCancelar());
		btnCancelar.setBounds(147, 196, 89, 34);
		panel_1.add(btnCancelar);
		
		Img n36 = new Img ();
		JButton btnGuardar = new JButton(n36.btnGuardar());
		btnGuardar.setBounds(242, 196, 89, 34);
		panel_1.add(btnGuardar);
		
		Img n32 = new Img();
		
		Img n33 = new Img ();
	}
}
