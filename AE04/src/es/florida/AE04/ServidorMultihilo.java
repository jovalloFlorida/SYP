/**
 * Clase para crear Hilos para atender la conexion
 */
package es.florida.AE04;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServidorMultihilo {
	

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		
		int numeroPuerto = 1234;
		
		System.err.println("SERVIDOR >>> Arranca el servidor, espera peticion...");
		ServerSocket socketEscucha = null;
		
		try {
			socketEscucha = new ServerSocket(numeroPuerto);
		} catch (IOException e) {
			System.err.println("SERVIDOR >>> Error");
			return;
		}
		
		while (true) {
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >>> Conexion recibida --> Lanza hilo clase Peticion");
			Servidor servidor = new Servidor(conexion);
			Thread hilo = new Thread(servidor);
			hilo.start();
		}
	}
}
