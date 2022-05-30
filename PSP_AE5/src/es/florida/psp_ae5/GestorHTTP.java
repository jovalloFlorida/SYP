package es.florida.psp_ae5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class GestorHTTP implements HttpHandler {    
	
	int temperaturaActual = 15;
	int temperaturaTermostato = temperaturaActual;
	
	@Override    
	public void handle(HttpExchange httpExchange) throws IOException {

		String requestParamValue=null; 
		if("GET".equals(httpExchange.getRequestMethod())) { 
			requestParamValue = handleGetRequest(httpExchange);
			handleGETResponse(httpExchange,requestParamValue); 
		} else if ("POST".equals(httpExchange.getRequestMethod())) { 
			requestParamValue = handlePostRequest(httpExchange);
			handlePOSTResponse(httpExchange,requestParamValue);
		}  
		
	}
	
	private String handleGetRequest(HttpExchange httpExchange) {
		System.out.println("Recibida URI tipo GET: " + httpExchange.getRequestURI().toString());
		return httpExchange.getRequestURI().toString().split("\\?")[1];
	}
	
	
	private String handlePostRequest(HttpExchange httpExchange) {
		System.out.println("Recibida URI tipo POST: " + httpExchange.getRequestBody().toString());
        InputStream is = httpExchange.getRequestBody();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        StringBuilder sb = new StringBuilder();
        String line;
        try {
			while ((line = br.readLine()) != null) {
			    sb.append(line);
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return sb.toString();
	}
	
	private void handleGETResponse(HttpExchange httpExchange, String requestParamValue)  throws  IOException {
		System.out.println(requestParamValue);
		OutputStream outputStream = httpExchange.getResponseBody();
		String htmlResponse = "<html><body><h1>Par&aacutemetro no reconocido</h1></body></html>";
		if (requestParamValue.equals("temperaturaActual")) {
			htmlResponse = "<html><body><h1>Temperatura actual: " + temperaturaActual + "º - Temperatura termostato: " + temperaturaTermostato + "º</h1></body></html>";
		} 
        httpExchange.sendResponseHeaders(200, htmlResponse.length());
        outputStream.write(htmlResponse.getBytes());
        outputStream.flush();
        outputStream.close();
        System.out.println("Devuelve respuesta HTML: " + htmlResponse);
	}
	
	private void handlePOSTResponse(HttpExchange httpExchange, String requestParamValue)  throws  IOException {
		OutputStream outputStream = httpExchange.getResponseBody();
		
		String htmlResponse = "<html><body><h1>Par&aacutemetro no reconocido</h1></body></html>";
		System.out.println(requestParamValue);
		if (requestParamValue.contains("setTemperatura")) {
			temperaturaTermostato = Integer.parseInt(requestParamValue.split("=")[1]);
			htmlResponse = "<html><body><h1>Set nueva temperatura: " + temperaturaTermostato + "º</h1></body></html>";
			httpExchange.sendResponseHeaders(200, htmlResponse.length());
	        outputStream.write(htmlResponse.getBytes());
	        regularTemperatura();
		} else if (requestParamValue.contains("notificarAveria")) {
			String emailRemitente = requestParamValue.split("=")[1].split(";")[0];
			String emailRemitentePass = requestParamValue.split("=")[2];
			System.out.println(emailRemitente + " " + emailRemitentePass);
			ClienteEmail correo = new ClienteEmail(emailRemitente, emailRemitentePass);
			htmlResponse = "<html><body><h1>Notificacion de averia</h1></body></html>";
			httpExchange.sendResponseHeaders(200, htmlResponse.length());
	        outputStream.write(htmlResponse.getBytes());
		}
        outputStream.flush();
        outputStream.close();
        
        System.out.println("Devuelve respuesta HTML: " + htmlResponse);
	}
	
	public void regularTemperatura() {
		System.out.println("Nueva temperatura: " + temperaturaTermostato);
		while (temperaturaActual < temperaturaTermostato) {
			temperaturaActual++;
			System.out.println("Actualiza temperatura: " + temperaturaActual);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		while (temperaturaActual > temperaturaTermostato) {
			temperaturaActual--;
			System.out.println("Actualiza temperatura: " + temperaturaActual);
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

