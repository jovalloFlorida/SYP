/**
 * Implementa para que funcione en tu equipo un gestor de descargas de ficheros de texto como el visto en el ejemplo de teoría. 
 * Necesitarás tener los recursos a descargar en el directorio correspondiente de XAMPP.
 */

package es.florida.ET04;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
 
public class Ejercicio1_DescargaTXT {

	public static void main(String[] args) {

		String ruta = "http://localhost:80/PSP_Sockets/install.log";
		String ficheroDescargado = "ficheroDescargado.txt";
		System.out.println("Descargando " + ruta + " a " + ficheroDescargado);

		try {
			URL url = new URL(ruta);
			InputStream is = url.openStream();
			InputStreamReader reader = new InputStreamReader(is);
			BufferedReader bReader = new BufferedReader(reader);
			FileWriter escritorFichero = new FileWriter(ficheroDescargado);
			String linea;
			
			while ((linea=bReader.readLine()) != null) {
				escritorFichero.write(linea + "\n");
			}
			escritorFichero.close();
			bReader.close();
			reader.close();
			is.close();
			
		}catch (MalformedURLException e){
			System.out.println("URL mal escrita!");
		}catch (IOException e) {
			System.out.println("Fallo en la lectura del fichero");
		}
	}

}
