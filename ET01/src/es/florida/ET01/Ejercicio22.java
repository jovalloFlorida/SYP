//Ejercicio 22. Modifica el programa anterior para que almacene en una estructura el nombre de un número cualquiera de personas, introducidos por teclado de uno en uno. La condición de finalización es introducir un 0 por teclado.

package es.florida.ET01;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio22 {

	public static void main(String[] args) {
		ArrayList<String> listaNombres = new ArrayList<String>();
		Scanner teclado = new Scanner(System.in);
		String nombre = "";
		while (!nombre.equals("0")) {
			System.out.print("Introduce un nombre (Pulsa 0 para terminar): ");
			nombre = teclado.nextLine();
			if (!nombre.equals("0")) {
				listaNombres.add(nombre);
			}
		}
		System.out.println(listaNombres.toString());
		teclado.close();
	}
}
