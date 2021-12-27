/**
 * Clase para crear los Constructores y Getters y Setters
 */
package es.florida.AE04;

import java.io.Serializable;

public class Contrasenya implements Serializable{
	
	String contrasenyaTextoPlano;
	String contrasenyaEncriptada;
	
	public Contrasenya() {
		super();
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
