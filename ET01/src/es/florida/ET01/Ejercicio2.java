//Ejercicio2. Programa Java que lea un nombre desde teclado y muestre por pantalla un mensaje tipo “Hola xxxxx”.

package es.florida.ET01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Dime tu nombre: ");
		String nombre = br.readLine();
		System.out.println("Hola " + nombre);
		isr.close();
		br.close();

	}

}
