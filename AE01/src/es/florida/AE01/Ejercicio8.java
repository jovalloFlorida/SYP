/*Ejericio 8. Escribe un método que pida por teclado 2 números como extremos de un intervalo. Luego imprime por pantalla todos los números
 *  entre ese intervalo, indicando junto al número si es un número primo o no. Al terminar de mostrar los números por pantalla, 
 *  debe mostrar un mensaje indicando el tiempo consumido en la ejecución del método.*/

package es.florida.AE01;

import java.util.Scanner;

public class Ejercicio8 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el numero del inicio del intervalo: ");
		int intervaloInicio = teclado.nextInt();
		if (intervaloInicio <= 1) { //Comprobamos que los numero primos tienen que ser mayores a 1
			intervaloInicio = 2;
		}
		System.out.print("Introduce el numero del final del intervalo: ");
		int intervaloFinal = teclado.nextInt();
		teclado.close();

		for (int i = intervaloInicio; i <= intervaloFinal; i++) {
			if (esPrimo(i)) {
				System.out.println("El número " + i + " es primo");
			} else {
				System.out.println("El número " + i + " no es primo");
			}
		}
	}

	public static boolean esPrimo(int numero) { //Comprobacion si el numero es primo (true / false)
		int contador = 2;
		boolean primo = true;
		while ((primo) && (contador != numero)) {
			if (numero % contador == 0)
				primo = false;
			contador++;
		}
		return primo;
	}

}
