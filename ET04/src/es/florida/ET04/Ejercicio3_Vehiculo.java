/**
 * Para trabajar el envío y recepción de objetos serializados, crea una clase que represente un objeto con algunos atributos, 
 * de manera análoga a la clase Persona utilizada en el ejemplo de teoría. Recuerda que debe implementar Serializable para que se pueda enviar 
 */

package es.florida.ET04;

import java.io.Serializable;

public class Ejercicio3_Vehiculo implements Serializable{

	String marca;
	String modelo;
	
	public Ejercicio3_Vehiculo() {
		super();
	}

	public Ejercicio3_Vehiculo(String marca, String modelo) {
		super();
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Ejercicio3_Vehiculo [marca=" + marca + ", modelo=" + modelo + "]";
	}
	
	

	
	
}
