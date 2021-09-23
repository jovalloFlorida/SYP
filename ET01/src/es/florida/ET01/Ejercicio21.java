//Ejercicio 21. Crea un programa que almacene en una estructura el nombre de 5 personas que se irán introduciendo por teclado de uno en uno

package es.florida.ET01;

import java.util.Scanner;

public class Ejercicio21 {

	public static void main(String[] args) {
		String[] nombres = new String[5];
		Scanner teclado = new Scanner(System.in);
		String cadaNombre;
		for (int i = 0; i < 5; i++) {
			System.out.print("Introduce un nombre: ");
			cadaNombre = teclado.next();
			nombres[i] = cadaNombre;
		}
		for (int x=0; x< nombres.length;x++) {
			System.out.print(nombres[x] + " ");
		}
		teclado.close();

	}

}
