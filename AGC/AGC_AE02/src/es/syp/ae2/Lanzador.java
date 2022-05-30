package es.syp.ae2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lanzador {
	
	
	// M�todo: main
	// Descripci�n: m�todo principal. Lanza un mensaje de bienvenida y regula el tiempo entre procesos. Desde aqu� se lanza el m�todo Lector.
	// Par�metros de entrada: .
	// Par�metros de salida: .
	public static void main(String[] args) {
		
		long inicio, fin, tiempoTotal, tiempoMedio;
		
		int numeroNucleos = Runtime.getRuntime().availableProcessors();
		
		System.out.println("Bienvenido a N.I.C. (NEOs Impact Calculator)");
		System.out.println("N� de nucleos disponibles: " + numeroNucleos);
		System.out.println("\nIniciado primera tanda de c�lculos...\n");
		
		String nombreFichero = "NEOs.txt";
		
		inicio = System.currentTimeMillis();
		
		Lector(numeroNucleos, nombreFichero);
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		fin = System.currentTimeMillis();
		tiempoTotal = fin - inicio;
		tiempoMedio = tiempoTotal / numeroNucleos;
		
		System.out.println("\nPrograma terminado. Tiempo total: " + (double) tiempoTotal/1000 + " seg. Tiempo medio por proceso: " + (double) tiempoMedio/1000 + " seg.");
		
	}
	
	
	// M�todo: Lector
	// Descripci�n: recibe el n�mero de n�cleos disponibles y el nombre del fichero de lectura a trav�s 
	//	de la llamada en la clase main y lee las lineas del documento, llamando a la funci�n Proceso y 
	//	pas�ndole los datos por par�metro. Divide el n�mero de procesos "en lotes" seg�n el n�mero de n�cleos.
	//	Cuando llega al n�mero de llamadas (procesos) equivalente al n�mero de nucleos, se realiza una 
	//	interrupci�n de 4 segundos para esperar a que terminen los procesos pendientes del lote anterior antes
	//	de empezar uno nuevo.
	// Par�metros de entrada: numero de n�cleos, nombre del fichero a leer.
	// Par�metros de salida: .
	public static void Lector(int numeroNucleos, String nombreFichero) {
		
		File ficheroLectura = new File(nombreFichero);
		
		try {
			FileReader fr = new FileReader(ficheroLectura);
			BufferedReader br = new BufferedReader(fr);
			String linea = br.readLine();
			
			String[] datosNEO;
						
			int contadorProcesos = 1;

			while (linea !=null) {
				
				if (contadorProcesos <= numeroNucleos) {
					datosNEO = linea.split(",");
					Proceso(datosNEO);
					contadorProcesos++;
				} else {
					
					try {
						Thread.sleep(4000);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					System.out.println("\nIniciado siguiente tanda de c�lculos...\n");
					datosNEO = linea.split(",");
					Proceso(datosNEO);
					contadorProcesos = 1;
				}
				
				linea = br.readLine();
			}

			br.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	// M�todo: Proceso
		// Descripci�n: recibe los datos pasados en el m�todo Lector para armar un comando y ejecutarlo
		//	con proccesbuilder (apuntando al proceso de la clase CalculaNeo).
		// Par�metros de entrada: array de datos.
		// Par�metros de salida: .
	public static void Proceso(String[] datos) {
		
		String clase = "es.syp.ae2.CalculaNEO";
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		String className = clase;
		
		List<String> command = new ArrayList<>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classpath);
		command.add(className);
		command.add(datos[0]);
		command.add(datos[1]);
		command.add(datos[2]);
		ProcessBuilder builder = new ProcessBuilder(command);

		try {
			builder.inheritIO().start();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	
}
