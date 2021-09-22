//Ejercicio 

package es.florida.ET01;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PlantillaScanner {

	public static void main(String[] args) throws IOException {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce el numero de DNI sin la letra: ");
		int variable = teclado.nextInt();
				
		teclado.close();
		
	}
}
