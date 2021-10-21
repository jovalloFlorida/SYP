//Ejercicio 5. Escribe un método que acepte un array o una lista de elementos y devuelva el mayor de ellos

package es.florida.AE01;

import java.util.Scanner;

public class Ejercicio5 {

	public static void main(String[] args) {

		int[] listaNumeros = new int[5];
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("Introduce numero " + (i + 1) + ": ");
			int numero = teclado.nextInt();
			listaNumeros[i] = numero;
		}
		int numeroMayor = 0;
		for (int x = 0; x < listaNumeros.length; x++) { // Recorremos el array y verificamos el numero mayor
			if (listaNumeros[x] > numeroMayor) {
				numeroMayor = listaNumeros[x];
			}
		}
		System.out.println("El numero mayor introducido es: " + numeroMayor);
		teclado.close();
	}
}
