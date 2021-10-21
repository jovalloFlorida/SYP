//Ejercicio 2. Crea un array de elementos que contenga el nombre de 6 compañeros de clase y…
//	a. Haz que se escriban por la consola en líneas consecutivas.
//	b. Haz lo mismo, pero empleando un objeto de tipo lista.

package es.florida.AE01;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {
		// Arrays

		System.out.println("Ejercicio con Arrays\n");
		String[] arrayAlumnos = { "David Gil", "Alejandro Garcia", "Juan Carlos Escriba", "Jose Martinez",
				"Sergio Cubells", "Albert Garcia" };
		for (int x = 0; x < arrayAlumnos.length; x++) {
			System.out.print(arrayAlumnos[x] + ", ");
		}
		// Listas

		System.out.println("\nEjercicio con Listas\n");
		ArrayList<String> listaAlumnos = new ArrayList<>();
		Scanner teclado = new Scanner(System.in);
		for (int i = 0; i < 6; i++) {
			System.out.print("Introduce el nombre del companero " + (i + 1) + ": ");
			String nombreAlumno = teclado.nextLine();
			listaAlumnos.add(nombreAlumno);
		}
		System.out.print(listaAlumnos);
		teclado.close();
	}

}
