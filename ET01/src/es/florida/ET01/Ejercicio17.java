//Ejercicio 17. Realiza un programa que controle los requisitos de una contrase�a introducida por teclado (m�nimo 5 caracteres, 1 n�mero y 1 letra may�scula).

package es.florida.ET01;

import java.util.Scanner;

public class Ejercicio17 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduce una contrase�a de minimo 5 caracteres: ");
		String passwd = teclado.nextLine();
		while (passwd.length() < 5) {
			System.out.print("Introduce un minimo de 5 caracteres: ");
			passwd = teclado.nextLine();
		}
		
		//TODO comprobar el numero y la mayuscula
		
		System.out.println("Tu contrase�a es: " + passwd);
		
		teclado.close();

	}

}
