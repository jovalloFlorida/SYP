/**
 * Implementa en tu equipo las aplicaciones ServidorCalculo y ClienteCalculo vistas en teoría. 
 * Prueba su funcionamiento (puedes crear un lanzador como en el ejercicio 6 o crear .JARs como en el ejercicio 7). 
 * Estudia con detenimiento el flujo del programa y qué hace cada una de las instrucciones. A continuación, haz las modificaciones 
 * pertinentes para que se pueda realizar cualquier tipo de operación entre 2 números.
 */
package es.florida.ET04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;



public class Ejercicio8_ClienteCalculo {

	public static void main(String[] args) throws IOException {
		
		String[] operacion = {"-","100","50"}; 
		
		System.out.println("CLIENTE >>> Arranca cliente");
		System.out.println("CLIENTE >>> Conexion al servidor");
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce la IP: ");
		String host = teclado.nextLine();
		InetSocketAddress direccion = new InetSocketAddress(host, 5000);
		Socket socket = new Socket();
		socket.connect(direccion);
		
		System.out.println(">>> Envio de datos para el calculo: " + operacion[1] + " " + operacion[0] + " " +operacion[2]);
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		pw.print(operacion[0]+"\n");
		pw.print(operacion[1]+"n");
		pw.print(operacion[2]+"\n");
		pw.flush();
		
		System.out.println("CLIENTE >>> Preparado canal para recibir resultado");
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
		String resultado = bfr.readLine();
		System.out.println("CLIENTE >>> Recibe resultado: " + resultado);
		
		socket.close();
		
	}

}
