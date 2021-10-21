package es.florida.ET02;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class ET02_Ejercicio6 {
	/**
	 * Crea una ampliación del programa 2 para que redirija la salida de la
	 * ejecución del programa 1 a su flujo de ejecución y lo muestre por consola
	 * (pista: utilizar inheritIO).
	 */
	public static void main(String[] args) {

		int num1 = 1;
		int num2 = 10;

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
		try {
			Process process = builder.inheritIO().start();
			process.waitFor();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
