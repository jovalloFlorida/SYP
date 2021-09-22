//Ejercicio 14. Desarrolla un programa que lea el valor del radio de una circunferencia y devuelva por pantalla el diámetro y el área con una precisión de 3 decimales

package es.florida.ET01;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Ejercicio14 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el radio de la circunferencia: ");
		double radio = teclado.nextDouble();
		double diametro = radio * radio;
		double area = Math.PI * Math.pow(radio, 2);
		System.out.println("El diametro es: " + String.format("%.3f", diametro));
		System.out.println("El area es: " + String.format("%.3f", area));
		teclado.close();

	}

}
