package es.florida.ET02;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ET02_Ejercicio4 {

	/**
	 * Crear una modificación del programa número 2 para que lea el resultado que ha
	 * escrito el programa 3 y lo muestre por pantalla. Deberá implementar algún
	 * procedimiento para controlar que el fichero esté efectivamente escrito y su
	 * contenido disponible
	 */

	public static void main(String[] args) {

		int num1 = 1;
		int num2 = 10;
		String nombreFichero = "resultado.txt";

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
		command.add(nombreFichero);
		System.out.println("Comando que se pasa a ProcessBuilder: " + command);
		System.out.println("Comando a ejecutar en cmd.exe: " + command.toString().replace(",", ""));
		ProcessBuilder builder = new ProcessBuilder(command);
		try {
			builder.start();
			//Process p = builder.start();
			//p.waitFor(); //Si usas el waitFor no se utiliza el bucle while
		    //} catch (IOException | InterruptedException e) {
		} catch (IOException e) {
			e.printStackTrace();
		}
		boolean ficheroLeido = false;
		while (!ficheroLeido) {
			File fichero = new File(nombreFichero);
			FileReader fr;
			try {
				fr = new FileReader(fichero);
				BufferedReader br = new BufferedReader(fr);
				String resultado = br.readLine();
				System.out.println("Resultado leido de fichero: " + resultado);
				ficheroLeido = true;
				fr.close();
				br.close();
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
