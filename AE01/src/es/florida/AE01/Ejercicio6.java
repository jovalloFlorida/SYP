// Ejercicio6. Escribe un método que pida 5 números enteros (sin validación de momento), los muestre por consola en orden inverso y 
// devuelva la suma de todos los números proporcionados

package es.florida.AE01;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		int suma = 0;
		int[] listaNumeros = new int[5];
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < 5; i++) {
			System.out.print("Introduce numero " + (i + 1) + ": ");
			int numero = teclado.nextInt();
			listaNumeros[i] = numero;
		}
		System.out.print("Listado de numeros introducidos en orden inverso: ");
		for (int x = 4; x >= 0; x--) {		//recorremos el Array en orden inverso y lo sacamos por pantalla
			System.out.print(listaNumeros[x]);
			suma = suma + listaNumeros[x];
		}
		System.out.println("\nLa suma de los numeros introducidos es: " + suma);
		teclado.close();
	}
}
