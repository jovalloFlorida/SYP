//Ejercicio 27. De la misma forma que en el ejercicio anterior, implementar en un método adicional el cálculo de la letra del DNI (ejercicio 11) para que sea llamado desde “main”.

package es.florida.ET01;

import java.util.Scanner;

public class Ejercicio27 {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el numero de DNI sin la letra: ");
		int numeroDNI = teclado.nextInt();
		
		System.out.println("La letra de tu DNI es: " + obtenerLetra(numeroDNI));
		teclado.close();

	}
	
	public static char obtenerLetra(int numeroDNI) {
		char[] arrayletras = {'T','R','W','A','G','M','Y','F','P','D','X','B','N','J','Z','S','Q','V','H','L','C','K','E'};
		char letraDNI = ' ';
		int resto = numeroDNI % 23;
		letraDNI=arrayletras[resto];
		return letraDNI;
	}

}
