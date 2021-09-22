//Ejercicio4. Programa que lea dos números desde teclado y muestre el menor y el mayor en pantalla. Si son iguales deberá mostrar un mensaje indicándolo.

package es.florida.ET01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio4 {

	public static void main(String[] args) throws IOException {
		
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.print("Introduce el primer numero para compararlos: ");
		String numero1=br.readLine();
		int num1 = Integer.parseInt(numero1);
		
		System.out.print("Introduce el segundo numero para compararlos: ");
		String numero2=br.readLine();
		int num2 = Integer.parseInt(numero2);

		if (num1 > num2) {
			System.out.print("El numero " + num1 + " es mayor que el " + num2);
		}else if (num2>num1) {
			System.out.print("El numero " + num2 + " es mayor que el " + num1);
		}else {
			System.out.print("Los dos numeros son iguales");
		}
		isr.close();
		br.close();
	}

}
