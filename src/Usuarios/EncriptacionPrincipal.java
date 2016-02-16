package Usuarios;

import org.apache.commons.codec.digest.DigestUtils;

public class EncriptacionPrincipal {
	public String encriptar(String pass){
		String pasword=pass;
		String encriptado= DigestUtils.md5Hex(pasword);
		return encriptado;
	}
	
	
}
