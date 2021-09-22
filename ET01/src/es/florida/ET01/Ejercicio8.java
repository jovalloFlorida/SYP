/*Ejercicio 8. Desarrolla un programa que lea por teclado un número del 1 al 12 e indique por pantalla a qué mes
del año en texto corresponde. Sugerencia: utilizar una estructura de programación if … else.*/

package es.florida.ET01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio8 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introduce un numero del 1 al 12: ");
		String numero = br.readLine();
		int num = Integer.parseInt(numero);
		if (num == 1) {
			System.out.println("Enero");
		} else if (num == 2) {
			System.out.println("Febrero");
		} else if (num == 3) {
			System.out.println("Marzo");
		} else if (num == 4) {
			System.out.println("Abril");
		} else if (num == 5) {
			System.out.println("Mayo");
		} else if (num == 6) {
			System.out.println("Junio");
		} else if (num == 7) {
			System.out.println("Julio");
		} else if (num == 8) {
			System.out.println("Agosto");
		} else if (num == 9) {
			System.out.println("Septiembre");
		} else if (num == 10) {
			System.out.println("Octubre");
		} else if (num == 11) {
			System.out.println("Noviembre");
		} else if (num == 12) {
			System.out.println("Diciembre");
		} else {
			System.out.println("Debes introducir un numero del 1 al 12");
		}

		isr.close();
		br.close();
	}
}
