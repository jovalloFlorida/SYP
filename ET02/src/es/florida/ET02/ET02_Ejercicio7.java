package es.florida.ET02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ET02_Ejercicio7 {
	/**
	 * Crear otra ampliación del programa 2 para que redirija la salida de la
	 * ejecución del programa 1 a su flujo de ejecución y lo escriba en un fichero
	 * (pista: utilizar redirectOutput).
	 */
	public static void main(String[] args) {

		int num1 = 1;
		int num2 = 10;
		String nombreFichero="resultado_ej7.txt";
		File fichero = new File(nombreFichero);

		String clase = "es.florida.ET02.ET02_Ejercicio1";
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classPath = System.getProperty("java.class.path");
		String className = clase;
		ArrayList<String> command = new ArrayList<>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classPath);
		command.add(className);
		command.add(String.valueOf(num1));
		command.add(String.valueOf(num2));
		System.out.println("Comando que se pasa a ProcessBuilder: " + command);
		System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",", ""));
		ProcessBuilder builder = new ProcessBuilder(command);
		builder.redirectOutput(fichero);
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
