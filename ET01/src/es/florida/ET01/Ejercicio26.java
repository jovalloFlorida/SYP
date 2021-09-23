//Ejercicio 26. Realiza una modificación sobre el programa de las notas (ejercicio 12) implemente la funcionalidad de determinar la calificación (suspenso, aprobado,…) en un método aparte (fuera del método “main”).

package es.florida.ET01;

import java.util.Scanner;

public class Ejercicio26 {

	static int notasSuspendida = 0, notasAprobada = 0, notasSuficiente = 0, notasBien = 0, notasNotable = 0,
			notasSobresaliente = 0, notasMatricula = 0;
	
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		
		double nota;
		for (int i = 1; i < 11; i++) {
			System.out.print("Introduce la nota " + i + ": ");
			nota = teclado.nextDouble();
			comprobarNotas(nota);
		}
		notasAprobada = notasSuficiente + notasBien + notasNotable + notasSobresaliente + notasMatricula;
		System.out.println("Hay " + notasSuspendida + " Suspendidas");
		System.out.println("Hay " + notasAprobada + " Aprobadas");
		System.out.println("Hay " + notasSuficiente + " Suficientes");
		System.out.println("Hay " + notasBien + " Bien");
		System.out.println("Hay " + notasNotable + " Notables");
		System.out.println("Hay " + notasSobresaliente + " Sobresalientes");
		System.out.println("Hay " + notasMatricula + " Matriculas");

		teclado.close();
	}

	
	public static void comprobarNotas(double nota) {
		if (nota < 5) {
			notasSuspendida++;
		} else if (nota >= 5 && nota < 6) {
			notasSuficiente++;
		} else if (nota >= 6 && nota < 7) {
			notasBien++;
		} else if (nota >= 7 && nota < 9) {
			notasNotable++;
		} else if (nota >= 9 && nota < 10) {
			notasSobresaliente++;
		} else if (nota == 10) {
			notasMatricula++;
		}
	}
	
}
