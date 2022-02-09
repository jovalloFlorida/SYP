package es.florida.AE05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.net.httpserver.HttpServer;

public class Servidor {

	// el servidor lo he creado con Java Y ES EL Q EST� ESCUCHANDO
	// una vez ejecuto la aplicaci�n tengo q entrar en esta web:
	// http://localhost:5000/test?name=guapa
	// y me da la respuesta: GET
//	Servidor HTPP arranca en el puerto 7777
//	Recibida URI tipo GET: /test?name=amigo
//	Devuelve respuesta HTML: <html><body><h1>Hola amigo</h1></body></html>

	public static void main(String[] args) throws IOException {

		String host = "127.0.0.1"; // localhost
		int puerto = 7777;
		InetSocketAddress direccionTCPIP = new InetSocketAddress(host, puerto);
		// n�mero de conexiones pendientes q el servidor puede mantener en cola
		int backlog = 0;
		// ojo! import com.sun.net.httpserver.HttpServer;
		HttpServer servidor = HttpServer.create(direccionTCPIP, backlog);

		// Clase que gestionar� los GETs, POSTs, etc.
		GestorHTTP gestorHTTP = new GestorHTTP();
		// Ruta (a partir de localhost en este ejemplo) en el que el servidor dar� respuesta.
		//El servidor aceptar� peticiones a trav�s del navegador en la ruta de contexto �/estufa�.
		String rutaRespuesta = "/estufa";
		// Crea un contexto, asocia la ruta al gestor HTTP
		servidor.createContext(rutaRespuesta, gestorHTTP);

		// Opci�n 1 de ejecuci�n: no multihilo
		// servidor.setExecutor(null);

		// Opci�n 2 de ejecuci�n: multihilo con ThreadPoolExecutor
		//El servidor ser� multihilo y gestionar� las peticiones desde la clase GestorHTTP.java.
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		servidor.setExecutor(threadPoolExecutor);

		servidor.start();
		System.out.println("Servidor HTPP arranca en el puerto " + puerto);

	}


}
