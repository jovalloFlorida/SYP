//Ejercicio 12. Realiza un programa en Java que dadas 10 notas introducidas por teclado (valores de 0 a 10), las agrupe en suspensos, aprobados, notables, sobresalientes y matrícula, y muestre por pantalla cuantas notas hay en cada grupo.

package es.florida.ET01;

import java.util.Scanner;

public class Ejercicio12 {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int notasSuspendida = 0, notasAprobada = 0, notasSuficiente = 0, notasBien = 0, notasNotable = 0,
				notasSobresaliente = 0, notasMatricula = 0;
		double nota;
		for (int i = 1; i < 11; i++) {
			System.out.print("Introduce la nota " + i + ": ");
			nota = teclado.nextDouble();
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

}
