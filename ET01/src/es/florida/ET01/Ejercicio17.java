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
		
		boolean mayuscula = false;
		boolean numero = false;
		char caracter;
		
		for (int i=0;i< passwd.length();i++) {
			caracter = passwd.charAt(i);
			if (Character.isDigit(caracter)) {
				numero = true;
			}
			if (Character.isUpperCase(caracter)) {
				mayuscula = true;
			}
		}
		
		if (numero == true && mayuscula == true) {
			System.out.println("La contrase�a introducida es correcta");
		} else {
			System.out.println("La contrase�a introducida es incorrecta, debe tener al menos 5 caracteres, un numero y una mayuscula");
		}
			
		
		teclado.close();

	}

}
