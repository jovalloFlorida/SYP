//Ejercicio 13. Programa que lea un valor de grados centígrados desde teclado y lo muestre en grados Fahrenheit con una precisión de 1 decimal.

package es.florida.ET01;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio13 {

	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce temperatura en grados Celsius: ");
		double temperaturaCelsius = teclado.nextDouble();
		double temperaturaFa = temperaturaCelsius * 9 / 5 + 32;
		System.out.println("La Tempreratura en ºF es: " + String.format("%.1f", temperaturaFa));
		teclado.close();
		
	}
}