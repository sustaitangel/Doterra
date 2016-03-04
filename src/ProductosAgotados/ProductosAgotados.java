package ProductosAgotados;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Conexion.Conectar;

public class ProductosAgotados {
	JTextField hola = null;
	Conectar conex = new Conectar();
	java.sql.Connection con = conex.conexion(hola);
	java.sql.Statement list;
	ResultSet rs;
	int contador = 0;
	public void calcular() throws SQLException{
		
		list = con.createStatement();//<=
		String sqlsString = "select nombre from productos where cantidad <= 5 ";
		ResultSet resultSet = list.executeQuery(sqlsString);
		while (resultSet.next()) {
			contador++;
		}
	}
	public int contador(){
		return contador;
	}
}
