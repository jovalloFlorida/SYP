package es.florida.AE05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GestorHTTP implements HttpHandler {

	int temperaturaActual = 15;
	private int temperaturaTermostato = 15;

	/**
	 * Metodo que comprueba que las peticiones son Get o Post
	 */
	@Override
	public void handle(HttpExchange httpExchange) throws IOException {
		String requestParamValue = null;
		if ("GET".equals(httpExchange.getRequestMethod())) {
			requestParamValue = handleGetRequest(httpExchange);
			handleGETResponse(httpExchange, requestParamValue);
		} else if ("POST".equals(httpExchange.getRequestMethod())) {
			try {
				requestParamValue = handlePostRequest(httpExchange);
			} catch (IOException | InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			handlePOSTResponse(httpExchange, requestParamValue);
		}
	}

	/**
	 * Metodo para obetener la informacion que nos estan mandano por el GET
	 * 
	 * @param httpExchange
	 * @return
	 */
	private String handleGetRequest(HttpExchange httpExchange) {
		return httpExchange.getRequestURI().toString().split("//?")[1];
	}

	/**
	 * Metodo para procesar la respuesta del parametro recibido, generando una
	 * respuesta que enviamos un string al cliente, en este caso una pequeña pagina
	 * web muy sencilla.
	 * 
	 * @param httpExchange
	 * @param requestParamValue
	 * @throws IOException
	 */
	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "<html><body><p>Temperatura Actual: " + temperaturaActual
				+ "</p><br><p>Temperatura Termostato: " + temperaturaTermostato + "</p></body></html>";
		httpExchange.sendResponseHeaders(200, htmlResponse.length());
		outputStream.write(htmlResponse.getBytes());
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * Metodo para procesar la informacion que nos llega, para realizar la
	 * actualizacion de la temperatura y llamar al al metodo regularTemperatura()
	 * 
	 * @param httpExchange
	 * @return
	 * @throws IOException
	 * @throws InterruptedException
	 */
	private String handlePostRequest(HttpExchange httpExchange) throws IOException, InterruptedException {
		InputStream inputStream = httpExchange.getRequestBody();
		InputStreamReader isr = new InputStreamReader(inputStream);
		BufferedReader br = new BufferedReader(isr);
		String frase = br.readLine();
		System.out.println("\nActualizando hasta la Temperatura deseada...\n");
		if (frase.split("=")[0].equals("setTemperatura")) {
			String temperaturaOrdenada = frase.split("=")[1];
			temperaturaTermostato = Integer.parseInt(temperaturaOrdenada);
			if (temperaturaTermostato < 0 || temperaturaTermostato > 80) {
				String postRequest = "El valor de temperatura " + temperaturaOrdenada + "No es es correcto...";
				return postRequest;
			}
			String postRequest = "Actualizada Temperatura deseada hasta: " + temperaturaOrdenada + " grados...";
			regularTemperatura();
			return postRequest;
		} else {
			String postRequest = "Error de comando.";
			return postRequest;
		}
	}

	/**
	 * Metodo para el tratamiento de la respuesta recibida
	 * 
	 * @param httpExchange
	 * @param requestParamValue
	 * @throws IOException
	 */
	private void handlePOSTResponse(HttpExchange httpExchange, String requestParamValue) throws IOException {
		OutputStream outputStream = httpExchange.getResponseBody();
		//String htmlResponse = "Orden recibida: " + requestParamValue;
		String htmlResponse = "Respuesta a la peticion POST";
		httpExchange.sendResponseHeaders(200, htmlResponse.length());
		outputStream.write(htmlResponse.getBytes());
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * Metodo para el calculo de la temperaturaActual con una pausa de 5 segundos.
	 * @throws InterruptedException
	 */
	private void regularTemperatura() throws InterruptedException {

		while (temperaturaTermostato != temperaturaActual) {
			Thread.sleep(5000);
			if (temperaturaTermostato > temperaturaActual) {
				temperaturaActual += 1;
				System.out.println("Temperatura Actual: " + temperaturaActual);
			} else {
				temperaturaActual -= 1;
				System.out.println("Temperatura Actual: " + temperaturaActual);
			}

		}
		System.out.print("\nAlcanzada Temperatura deseada...\n");
	}

}
