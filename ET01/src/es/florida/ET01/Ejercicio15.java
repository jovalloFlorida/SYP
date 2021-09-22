//Ejercicio 15. Amplia el programa anterior para que devuelve el volumen de una esfera definida por el mismo radio.

package es.florida.ET01;

import java.util.Scanner;

public class Ejercicio15 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el radio de la circunferencia: ");
		double radio = teclado.nextDouble();
		double diametro = radio * radio;
		double area = Math.PI * Math.pow(radio, 2);
		double volumen = 4 / 3 * Math.PI * Math.pow(radio, 3);
		System.out.println("El diametro es: " + String.format("%.3f", diametro));
		System.out.println("El area es: " + String.format("%.3f", area));
		System.out.println("El volumen es: " + String.format("%.3f", volumen));
		teclado.close();

	}

}
