//Ejercicio 28. Crea un programa que permita generar 5 objetos de clase “Vehículo”. Cada vehículo tendrá tres atributos: tipo (coche, motocicleta,…), marca y modelo. Una vez creados, el programa los mostrará por pantalla.

package es.florida.ET01;

import java.util.Scanner;

public class Ejercicio28 {

	public static void main(String[] args) {
		String tipo, marca, modelo;
		Scanner teclado = new Scanner(System.in);
		Vehiculo[] arrayVehiculos = new Vehiculo[5];
		for (int i = 0; i < 5; i++) {
			System.out.println("Caracteristicas del vehiculo " + i);
			System.out.print("Tipo: ");
			tipo = teclado.nextLine();
			System.out.print("Marca: ");
			marca = teclado.nextLine();
			System.out.print("Modelo: ");
			modelo = teclado.nextLine();
			Vehiculo vehiculoActual = new Vehiculo(tipo, marca, modelo);
			arrayVehiculos[i] = vehiculoActual;
		}
		System.out.println("Lista de vehiculos: ");
		for (Vehiculo vehiculoActual : arrayVehiculos) {
			System.out.println(vehiculoActual.toString());
		}
		teclado.close();

	}

}
