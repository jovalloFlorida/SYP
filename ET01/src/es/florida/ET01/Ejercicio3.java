// Ejercicio3. Realiza un programa que lea dos números desde teclado y muestre la suma por pantalla

package es.florida.ET01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio3 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introduce el primer numero para hacer la suma: ");
		String numero1 = br.readLine();
		System.out.print("Introduce el segundo numero para hacer la suma: ");
		String numero2 = br.readLine();
		System.out.print(
				"La suma de los 2 numeros introducidos es: " + (Integer.parseInt(numero1) + Integer.parseInt(numero2)));
		isr.close();
		br.close();

	}

}
