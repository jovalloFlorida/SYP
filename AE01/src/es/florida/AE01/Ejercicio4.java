//Ejercicio 4. Escribe el c�digo necesario para calcular el factorial del n�mero 15, en menos de 5 instrucciones.

package es.florida.AE01;

public class Ejercicio4 {

	public static void main(String[] args) {
		double factorial = 1 , numero=15;
		while ( numero!=0) {
			  factorial=factorial*numero;
			  numero--;
			}
		System.out.println(factorial);
	}
}
