package Imagenes;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Img {
	public Icon fondo(){
		Icon fondo= new ImageIcon(getClass().getResource("logo_fondo.png"));
		return fondo;
	}
	public Icon login(){
		Icon doterra= new ImageIcon(getClass().getResource("logoSesion.png"));
		return doterra;
	}
	public Icon btnProductos(){
		Icon productos= new ImageIcon(getClass().getResource("btnProductos.png"));
		return productos;
	}
	public Icon btnVentas(){
		Icon Ventas= new ImageIcon(getClass().getResource("btnVentas.png"));
		return Ventas;
	}
	public Icon btnInventario(){
		Icon inventario= new ImageIcon(getClass().getResource("btnInventario.png"));
		return inventario;
	}
	public Icon btnReportes(){
		Icon reporte= new ImageIcon(getClass().getResource("btnReportes.png"));
		return reporte;
	}
	public Icon btnUsuarios(){
		Icon usuario= new ImageIcon(getClass().getResource("btnUsuarios.png"));
		return usuario;
	}
	public Icon btnCancelar(){
		Icon cancelar= new ImageIcon(getClass().getResource("btnCancelar.png"));
		return cancelar;
	}
	public Icon btnGuardar(){
		Icon guardar= new ImageIcon(getClass().getResource("btnGuardar.png"));
		return guardar;
	}
	public Icon Buscar(){
		Icon Buscar= new ImageIcon(getClass().getResource("btnBuscar.png"));
		return Buscar;
	}
	public Icon Eliminar(){
		Icon eliminar= new ImageIcon(getClass().getResource("btnEliminar.png"));
		return eliminar;
	}
	public Icon Actualizar(){
		Icon actualizar= new ImageIcon(getClass().getResource("btnActualizar.png"));
		return actualizar;
	}
	public Icon TerminarVenta(){
		Icon terminar= new ImageIcon(getClass().getResource("btnTerminarVenta.png"));
		return terminar;
	}
	public Icon CancelarVenta(){
		Icon cancelarventa= new ImageIcon(getClass().getResource("btnCancelarVenta.png"));
		return cancelarventa;
	}
	public Icon ReporteProductos(){
		Icon rproductos= new ImageIcon(getClass().getResource("btnReportesProductos.png"));
		return rproductos;
	}
	public Icon ReporteVentas(){
		Icon rventas= new ImageIcon(getClass().getResource("btnReporteVentas.png"));
		return rventas;
	}
	public Icon GenerarReporte(){
		Icon greporte= new ImageIcon(getClass().getResource("btnGenerarReporte.png"));
		return greporte;
	}
	public Icon btnClientes(){
		Icon clientes= new ImageIcon(getClass().getResource("btnClientes.png"));
		return clientes;
	}
	public Icon btnVerClientes(){
		Icon verclientes= new ImageIcon(getClass().getResource("btnVerClientes.png"));
		return verclientes;
	}
}
