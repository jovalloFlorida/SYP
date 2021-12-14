/**
 * Implementa en tu equipo las aplicaciones ServidorCalculo y ClienteCalculo vistas en teoría. 
 * Prueba su funcionamiento (puedes crear un lanzador como en el ejercicio 6 o crear .JARs como en el ejercicio 7). 
 * Estudia con detenimiento el flujo del programa y qué hace cada una de las instrucciones. 
 * A continuación, haz las modificaciones pertinentes para que se pueda realizar cualquier tipo de operación entre 2 números.
 */
package es.florida.ET04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio8_ServidorCalculo {

	public static double calcular(String op, String n1, String n2) {
		
		double resultado = 0;
		char simbolo = op.charAt(0);
		double num1 = Double.parseDouble(n1);
		double num2 = Double.parseDouble(n2);
		if (simbolo == '+') {resultado = num1 + num2;}
		if (simbolo == '-') {resultado = num1 - num2;}
		if (simbolo == '*') {resultado = num1 * num2;}
		if (simbolo == '/') {resultado = num1 / num2;}
		return resultado;
	}

	public static void main(String[] args) throws IOException {
		
		System.err.println("SERVIDOR >>> Arranca el servidor, espera peticion...");
		ServerSocket socketEscucha = new ServerSocket(5000);
		while (true) {
			Socket conexion = socketEscucha.accept();
			System.err.println("SERVIDOR >>> Conexion recibida!");
			InputStream is = conexion.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bf = new BufferedReader(isr);
			System.err.println("SERVIDOR >>> Lee datos para la operacion");
			String linea = bf.readLine();
			String num1 = bf.readLine();
			String num2 = bf.readLine();
			System.err.println("SERVIDOR >>> Realiza la operacion");
			Double result = calcular(linea, num1, num2);
			System.err.println("SERVIDOR >>> Devuelve resultado");
			OutputStream os = conexion.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			pw.write(result.toString() + "\n");
			pw.flush();
			System.err.println("SERVIDOR >>> Espera nueva peticion...");
		}
	}
}
