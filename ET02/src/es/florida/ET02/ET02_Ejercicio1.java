package es.florida.ET02;

public class ET02_Ejercicio1 {

	public static void main(String[] args) {
		/**
		 * Realiza un programa en Java que dados dos n�meros enteros, devuelva por
		 * pantalla la suma de todos los n�meros que hay entre ellos (incluy�ndolos).
		 */

		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		int suma = 0;
		for (int i = num1; i <= num2; i++) {
			suma = suma + i;
		}
		System.out.println("Suma numeros entre " + num1 + " y " + num2 + " (inclusive)  " + suma);

	}

}
