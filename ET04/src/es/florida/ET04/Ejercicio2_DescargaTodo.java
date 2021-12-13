/**
 * Modifica el programa anterior para que puedas descargar también imágenes y otros tipos de archivos que no sean ficheros de texto. 
 * Ten en cuenta que tendrás que manejar los datos como bytes, ya no valdrá utilizar objetos de tipo Reader que leen líneas o caracteres.
 */
package es.florida.ET04;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Ejercicio2_DescargaTodo {

	public void descargarArchivo(String url_descargar, String nombreArchivo) {
		System.out.println("Descargando " + url_descargar + " a " + nombreArchivo);
		int posicionPunto = nombreArchivo.indexOf(".");
		String extension = nombreArchivo.substring(posicionPunto);
		try {
			URL url = new URL(url_descargar);
			InputStream is = url.openStream();
			if (extension.equals(".txt")) {
				InputStreamReader reader = new InputStreamReader(is);
				BufferedReader bReader = new BufferedReader(reader);
				FileWriter escritorFichero = new FileWriter(nombreArchivo);
				String linea;

				while ((linea = bReader.readLine()) != null) {
					escritorFichero.write(linea + "\n");
				}
				escritorFichero.close();
				bReader.close();
				reader.close();
				is.close();
			} else { // Tambien funciona para .txt
				byte[] todo = is.readAllBytes();
				FileOutputStream fos = new FileOutputStream(nombreArchivo);
				fos.write(todo);
				fos.close();
			}
		} catch (MalformedURLException e) {
			System.out.println("URL mal escrita!");
		} catch (IOException e) {
			System.out.println("Fallo en la lectura del fichero");
		}

	}

	public static void main(String[] args) {

		Ejercicio2_DescargaTodo gestorDescargas = new Ejercicio2_DescargaTodo();
		
		//Descarga fichero .txt
		String url = "http://localhost:80/PSP_Sockets/install.log";
		String ficheroDescargado = "ficheroDescargado.txt";
		gestorDescargas.descargarArchivo(url, ficheroDescargado);

		//Descarga fichero .jpg
		url = "http://localhost:80/PSP_Sockets/homer.jpg";
		ficheroDescargado = "ficheroDescargado.jpg";
		gestorDescargas.descargarArchivo(url, ficheroDescargado);

	}
}
