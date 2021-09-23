//Ejercicio 20. Ampliar el programa anterior incluyendo también los caracteres de ASCII extendido

package es.florida.ET01;

public class Ejercicio20 {

	public static void main(String[] args) {
		for (int i = 0; i < 256; i++) {
			System.out.println("Caracter ASCII " + (i + 1) + ": " + (char) i);
		}

	}

}
