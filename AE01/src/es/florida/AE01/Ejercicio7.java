/*Ejercicio 7. Escribe un método que pida por teclado el nombre y los años de experiencia como desarrollador de software y muestre el nivel
y el salario en base al siguiente criterio:
	a. Si lleva menos de 1 año --> “Desarrollador Junior L1 – 15000-18000”
	b. Si lleva entre 1 y 2 años --> “Desarrollador Junior L2 – 18000-22000”
	c. Si lleva entre 3 y 5 años --> ”Desarrollador Senior L1 – 22000-28000”
	d. Si lleva entre 5 y 8 años --> “Desarrollador Senior L2 – 28000-36000”
	e. Si lleva más de 8 años --> “Analista / Arquitecto. Salario a convenir en base a rol”*/

package es.florida.AE01;

import java.util.Scanner;

public class Ejercicio7 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce tu nombre: ");
		String nombre = teclado.nextLine();
		System.out.print("Introduce los años de esperiencia como desarrollador de software: ");
		int experiencia = teclado.nextInt();

		if (experiencia < 1) {
			System.out.println(nombre + " tienes el nivel Desarrollador Junior L1, con Salario entre el rango de 15000-18000");
		} else if (experiencia >= 1 && experiencia <= 2) {
			System.out.println(nombre + " tienes el nivel Desarrollador Junior L2, con Salario entre el rango de 18000-22000");
		} else if (experiencia >= 3 && experiencia <= 5) {
			System.out.println(nombre + " tienes el nivel Desarrollador Senior L1, con Salario entre el rango de 22000-28000");
		} else if (experiencia >= 5 && experiencia <= 8) {
			System.out.println(nombre + " tienes el nivel Desarrollador Senior L2, con Salario entre el rango de 28000-26000");
		} else if (experiencia > 8) {
			System.out.println(nombre + " tienes el nivel Analista / Arquitecto, con Salario a convenir en base a rol");
		}
		teclado.close();
	}
}
