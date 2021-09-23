//Ejercicio 23. Amplía el programa anterior para que, una vez tenga almacenados los nombres en una variable, los muestre por pantalla de uno en uno de la siguiente forma: primera línea: “1. Primer nombre”, segunda línea: “2. Segundo nombre”,…

package es.florida.ET01;

import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio23 {

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
		int contador = 0;
		for (String contNombre : listaNombres) {
			contador++;
			System.out.println(contador + "." + " "+ contNombre);
		}
		
		teclado.close();

	}

}
