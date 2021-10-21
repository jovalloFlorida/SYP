package es.florida.ET02;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ET02_Ejercicio3 {

	public static void main(String[] args) {
		/**
		 * Crear una modificación del programa número 1 para que escriba el resultado en
		 * un fichero en disco.
		 */
		int num1 = Integer.parseInt(args[0]);
		int num2 = Integer.parseInt(args[1]);
		String nombreFichero = args[2];
		int suma = 0;
		for (int i = num1; i <= num2; i++) {
			suma = suma + i;
		}
		System.out.println("Suma numeros entre " + num1 + " y " + num2 + " (inclusive)  " + suma);
		File fichero = new File(nombreFichero);
		FileWriter fw;
		BufferedWriter bw;
		System.out.println("Iniciando escritura en fichero...");
		try {
			fw = new FileWriter(fichero);
			bw = new BufferedWriter(fw);
			bw.write(String.valueOf(suma));
			bw.close();
			fw.close();
			System.out.println("Fichero escrito con exito");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
