//Ejercicio 16. Escribe un programa que dada la fecha de nacimiento de una persona devuelva su número de la suerte (utiliza el algoritmo de cálculo que prefieras).  

package es.florida.ET01;

import java.util.Scanner;

public class Ejercicio16 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce tu fecha de nacimiento: ");
		String fechaNacimiento = teclado.nextLine();
		int numeroSuerte = (int)Math.floor(Math.random()*1500 +1);
		System.out.println("Tu numero de la suerte es: " + numeroSuerte);
		
		teclado.close();
	

	}

}
