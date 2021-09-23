package es.florida.HolaMundo;

import java.util.Scanner;

public class HolaMundo {

	public static void main(String[] args) {
		
		//System.out.println("Hola Mundo");
		
		Scanner teclado = new Scanner(System.in);
		System.out.print("Dime tu nombre: ");
		String nombre = teclado.nextLine();
		System.out.println("Hola " + nombre);
		teclado.close();
	}

}
