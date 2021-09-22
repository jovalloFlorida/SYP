//Ejercicio 

package es.florida.ET01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio7 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int num;
		int total = 0;
		int contador = 0;
		while (contador < 5) {
			System.out.print("Introduce un numero: ");
			String numero = br.readLine();
			num = Integer.parseInt(numero);
			total = total + num;
			contador = contador + 1;
		}
		System.out.print("La suma total de los 5 numeros introducidos es: " + total);
		isr.close();
		br.close();
	}
}
