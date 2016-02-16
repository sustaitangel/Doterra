package Usuarios;

public class TipoUsuario {
	
	public String tipoDeUsuario;
	
	public String getNombreArticulo(){
		return (tipoDeUsuario);
	}
	
	public void setNombreArticulo(String NombreTipo){
		
		this.tipoDeUsuario=NombreTipo;
	}
	

	public TipoUsuario(String tipo) {
		// TODO Auto-generated constructor stub
		this.tipoDeUsuario =tipo;
	}

}

