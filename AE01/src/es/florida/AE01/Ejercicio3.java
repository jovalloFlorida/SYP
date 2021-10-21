//Ejercicio 3. Escribe un método que sume los números pares hasta el número que acepta como parámetro y devuelva el resultado de la suma.

package es.florida.AE01;

import java.util.Scanner;

public class Ejercicio3 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce un numero para hacer la suma de sus pares: ");
		int parametro = teclado.nextInt();
		calculoPares(parametro);
		teclado.close();

	}

	public static void calculoPares(int parametro) {
		int suma = 0;
		for (int x = 1; x <= parametro; x++) {
			if (x % 2 == 0) {
				suma = suma + x;
			}
		}
		System.out.println("El resultado de la suma de los pares hasta el numero " + parametro + " es: " + suma);
	}

}
