/**
 * Clase para lanzar la aplicacion  programa NEO Help!
 * 
 * @author Jose Valverde
 *
 */
package es.florida.AE02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LanzadorPeticion {

	public static void main(String[] args) throws IOException, InterruptedException {
		/**
		 * Declaracion de variables
		 */
		int numeroCores = Runtime.getRuntime().availableProcessors();
		String clase = "es.florida.AE02.ProbabilidadNEO";
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = clase;

		File fichero = new File("NEOs.txt"); // Declaracion del fichero de lectura
		Process process = null;
		System.out.println(
				"Calculando la probabilidad de que un objeto tipo NEO colisione con la Tierra en los próximos 50 años...\n");

		try {
			int contadorCores = 0;
			FileReader fr = new FileReader(fichero);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();

			while (linea != null) {
				List<String> command = new ArrayList<>(); // Lista de Arrays para almacenar los procesos
				String[] informacionNEO = linea.split(","); // Array para almacenar por campos separados por comas
				command.add(javaBin);
				command.add("-cp");
				command.add(classpath);
				command.add(className);
				command.add(String.valueOf(informacionNEO[0]));
				command.add(String.valueOf(informacionNEO[1]));
				command.add(String.valueOf(informacionNEO[2]));
				ProcessBuilder builder = new ProcessBuilder(command);
				if (contadorCores < numeroCores) {
					process = builder.inheritIO().start();
					command.clear();
					process.waitFor(); // Temporizador para que no aparezcan los mensajes de error.
					contadorCores++;
					linea = br.readLine();
				} else {
					System.out.println("Nucleos ocupados con procesos..."); // Mensaje si supera el numero de procesos
					contadorCores = 0;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("\nCalculado la probabilidad de colisiones con la Tierra en los próximos 50 años...");
	}
}
