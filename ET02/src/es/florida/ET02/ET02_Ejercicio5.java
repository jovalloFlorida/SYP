package es.florida.ET02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ET02_Ejercicio5 {
	/**
	 * Implementar una modificación del programa número 4 para que llame dos veces
	 * consecutivas al programa 3 (con números distintos), lea los resultados de los
	 * ficheros generados y los muestre por pantalla.
	 */
	public static void main(String[] args) {

		int num1 = 1;
		int num2 = 10;
		String nombreFichero1 = "resultado1.txt";

		int num3 = 1;
		int num4 = 10;
		String nombreFichero2 = "resultado2.txt";

		// Llamada1
		String clase = "es.florida.ET02.ET02_Ejercicio3";
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
		command.add(nombreFichero1);
		System.out.println("Comando que se pasa a ProcessBuilder: " + command);
		System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",", ""));
		ProcessBuilder builder = new ProcessBuilder(command);
		try {
			builder.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Llamada2
		ArrayList<String> command2 = new ArrayList<>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classPath);
		command.add(className);
		command.add(String.valueOf(num3));
		command.add(String.valueOf(num4));
		command.add(nombreFichero2);
		System.out.println("Comando que se pasa a ProcessBuilder: " + command2);
		System.out.println("Comando a ejecutar en cmd.exe: " + command2.toString().replace(",", ""));
		ProcessBuilder builder2 = new ProcessBuilder(command2);
		try {
			builder2.start();
		} catch (IOException e) {
			e.printStackTrace();
		}

		boolean ficheroLeidos = false;
		while (!ficheroLeidos) {
			File fichero1 = new File(nombreFichero1);
			File fichero2 = new File(nombreFichero2);
			FileReader fr1;
			FileReader fr2;
			try {
				fr1 = new FileReader(fichero1);
				BufferedReader br1 = new BufferedReader(fr1);
				String resultado1 = br1.readLine();
				fr1.close();
				br1.close();

				fr2 = new FileReader(fichero2);
				BufferedReader br2 = new BufferedReader(fr2);
				String resultado2 = br2.readLine();
				fr2.close();
				br2.close();

				System.out.println("Resultado1 leido de fichero: " + resultado1);
				System.out.println("Resultado2 leido de fichero: " + resultado2);
				ficheroLeidos = true;

			} catch (FileNotFoundException e) {
				System.out.println("Buscando fichero...");
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
