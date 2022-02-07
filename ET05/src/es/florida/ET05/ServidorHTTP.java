package es.florida.ET05;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.sun.net.httpserver.HttpServer;

public class ServidorHTTP {

	// el servidor lo he creado con Java Y ES EL Q ESTÁ ESCUCHANDO
	// una vez ejecuto la aplicación tengo q entrar en esta web:
	// http://localhost:5000/test?name=guapa
	// y me da la respuesta: GET
//	Servidor HTPP arranca en el puerto 5000
//	Recibida URI tipo GET: /test?name=amigo
//	Devuelve respuesta HTML: <html><body><h1>Hola amigo</h1></body></html>

	public static void main(String[] args) throws IOException {

		String host = "localhost"; // 127.0.0.1
		int puerto = 5000;
		InetSocketAddress direccionTCPIP = new InetSocketAddress(host, puerto);
		// número de conexiones pendientes q el servidor puede mantener en cola
		int backlog = 0;
		// ojo! import com.sun.net.httpserver.HttpServer;
		HttpServer servidor = HttpServer.create(direccionTCPIP, backlog);

		// Clase que gestionará los GETs, POSTs, etc.
		GestorHTTP gestorHTTP = new GestorHTTP();
		// Ruta (a partir de localhost en este ejemplo) en el que el servidor dará
		// respuesta
		String rutaRespuesta = "/test";
		// Crea un contexto, asocia la ruta al gestor HTTP
		servidor.createContext(rutaRespuesta, gestorHTTP);

		// Opción 1 de ejecución: no multihilo
		// servidor.setExecutor(null);

		// Opción 2 de ejecución: multihilo con ThreadPoolExecutor
		ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
		servidor.setExecutor(threadPoolExecutor);

		servidor.start();
		System.out.println("Servidor HTPP arranca en el puerto " + puerto);

	}

}
