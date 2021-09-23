//Ejercicio 30. Genera archivos ejecutables (.JAR) de algunos ejercicios y ejecútalos por línea de comandos

package es.florida.ET01;

import java.util.Scanner;

public class Ejercicio30 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime tu nombre: ");
		String nombre = teclado.nextLine();
		System.out.println("Hola " + nombre);
		teclado.close();
		
		//Comando para ejecutar: java -jar HolaMundo.jar
	}
}
