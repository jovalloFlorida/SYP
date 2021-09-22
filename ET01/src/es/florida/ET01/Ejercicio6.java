//Ejercicio6. Realiza un programa que lea cinco números desde teclado y muestre la suma por pantalla. Sugerencia: utilizar una estructura de bucle.

package es.florida.ET01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio6 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int num; 
		int total = 0;
		for (int i=0; i<5; i++) {
			System.out.print("Introduce un numero: ");
			String numero = br.readLine();
			num = Integer.parseInt(numero);
			total = total + num;
		}
		System.out.print("La suma total de los 5 numeros introducidos es: " + total);
		isr.close();
		br.close();
	}
}
