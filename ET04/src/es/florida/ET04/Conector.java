package es.florida.ET04;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Conector {
	public static void main(String[] args) throws IOException {
		//String destino = "localhost";
		String destino = "www.google.com";
		int puertoDestino = 80;
		Socket socket = new Socket();
		InetSocketAddress direccion = new InetSocketAddress(destino, puertoDestino);
		try {
			socket.connect(direccion);
			//Para recibir Datos o Mensajes
			InputStream is = socket.getInputStream();
			//Para enviar Datos o Mensajes
			OutputStream os = socket.getOutputStream();
			System.out.println("Conexión realizada");
		} catch (IOException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}
		socket.close();
	}
}
