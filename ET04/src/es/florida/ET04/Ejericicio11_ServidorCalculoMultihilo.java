/**
 * Modifica el programa servidor para que sea multihilo, es decir, que para cada conexión de un cliente cree un nuevo hilo. 
 * Realiza las pruebas que has hecho en el ejercicio 10 para ver el funcionamiento. Para facilitar la traza de cada hilo, 
 * haz que en los mensajes que se muestran del servidor aparezca reflejado el nombre del hilo.
 */

package es.florida.ET04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Ejericicio11_ServidorCalculoMultihilo {

	public static void main(String[] args) throws IOException {
		System.err.println("SERVIDOR >>> Arranca el servidor, espera peticion...");
		ServerSocket socketEscucha = null;
		try {
			socketEscucha=new ServerSocket(9876);
		}catch (IOException e){
			System.err.println("SERVIDOR >>> Error");
		}
		while (true) {
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >>> Conexion recibida --> Lanza hilo clase Peticion");
			Ejercicio11_ServidorCalculoMultihilo_Hilo h = new Ejercicio11_ServidorCalculoMultihilo_Hilo(conexion);
			Thread hilo = new Thread(h);
			hilo.start();
		}
		
		
	}

}
