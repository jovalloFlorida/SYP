//Ejercicio 19. Realizar un programa que muestre por pantalla los caracteres ASCII (código y carácter).

package es.florida.ET01;


public class Ejercicio19 {

	public static void main(String[] args) {
		for (int i = 0; i < 128; i++) {
			System.out.println("Caracter ASCII " + (i+1)+ ": " + (char)i);
		}

	}

}
