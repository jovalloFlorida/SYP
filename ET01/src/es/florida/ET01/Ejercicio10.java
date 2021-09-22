//Ejercicio 10. Realiza una modificación del ejercicio anterior para que implemente un control de la entrada por teclado (admitir sólo números del 1 al 12).

package es.florida.ET01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio10 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Introduce un numero del 1 al 12: ");
		String numero = br.readLine();
		int num = Integer.parseInt(numero);
		if (num > 0 && num < 13) {
			switch (num) {
			case 1:
				System.out.println("Enero");
				break;
			case 2:
				System.out.println("Febrero");
				break;
			case 3:
				System.out.println("Marzo");
				break;
			case 4:
				System.out.println("Abril");
				break;
			case 5:
				System.out.println("Mayo");
				break;
			case 6:
				System.out.println("Junio");
				break;
			case 7:
				System.out.println("Julio");
				break;
			case 8:
				System.out.println("Agosto");
				break;
			case 9:
				System.out.println("Septiembre");
				break;
			case 10:
				System.out.println("Octubre");
				break;
			case 11:
				System.out.println("Noviembre");
				break;
			case 12:
				System.out.println("Diciembre");
				break;
			default:
				break;
			}
		} else {
			System.out.println("Debes introducir un numero del 1 al 12");
		}

		isr.close();
		br.close();
	}

}
