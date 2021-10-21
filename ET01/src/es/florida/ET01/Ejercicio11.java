//Ejercicio 11. Implementa un programa que dado un DNI (sin letra) por teclado devuelva el DNI con la letra correcta.

package es.florida.ET01;

import java.io.IOException;
import java.util.Scanner;

public class Ejercicio11 {

	public static void main(String[] args) throws IOException {
		
		char[] arrayletras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el numero de DNI sin la letra: ");
		int numeroDNI = teclado.nextInt();
		int resto = numeroDNI % 23;
		System.out.println("La letra de tu DNI es: " + arrayletras[resto]);
		teclado.close();
		
	}
}

