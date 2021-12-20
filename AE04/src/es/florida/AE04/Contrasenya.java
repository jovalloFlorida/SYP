package es.florida.AE04;

public class Contrasenya {
	
	String contrasenyaTextoPlano;
	String contrasenyaEncriptada;
	
	public Contrasenya() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contrasenya(String contrasenyaTextoPlano, String contrasenyaEncriptada) {
		super();
		this.contrasenyaTextoPlano = contrasenyaTextoPlano;
		this.contrasenyaEncriptada = contrasenyaEncriptada;
	}

	public String getcontrasenyaTextoPlano() {
		return contrasenyaTextoPlano;
	}

	public void setcontrasenyaTextoPlano(String contrasenyaTextoPlano) {
		this.contrasenyaTextoPlano = contrasenyaTextoPlano;
	}

	public String getcontrasenyaEncriptada() {
		return contrasenyaEncriptada;
	}

	public void setcontrasenyaEncriptada(String contrasenyaEncriptada) {
		this.contrasenyaEncriptada = contrasenyaEncriptada;
	}

	@Override
	public String toString() {
		return "Contrasenya [Contrasenya Texto Plano --> " + contrasenyaTextoPlano
				+ ", Contrasenya Encriptada --> " + contrasenyaEncriptada + "]";
	}
	
	
	
	

}
