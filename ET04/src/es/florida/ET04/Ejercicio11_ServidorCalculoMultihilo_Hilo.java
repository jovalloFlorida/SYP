package es.florida.ET04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Ejercicio11_ServidorCalculoMultihilo_Hilo implements Runnable {

	BufferedReader bfr;
	PrintWriter pw;
	Socket socket;

	public Ejercicio11_ServidorCalculoMultihilo_Hilo(Socket socket) {
		this.socket = socket;
	}
	
public int calcular(String op, String n1, String n2) {
		
		int resultado = 0;
		char simbolo = op.charAt(0);
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		if (simbolo == '+') {resultado = num1 + num2;}
		if (simbolo == '-') {resultado = num1 - num2;}
		if (simbolo == '*') {resultado = num1 * num2;}
		if (simbolo == '/') {resultado = num1 / num2;}
		return resultado;
	}

	public void run() {
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			bfr = new BufferedReader(isr);
			OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(os);
			String linea = bfr.readLine();
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Lee datos para la operacion");
			String num1 = bfr.readLine();
			String num2 = bfr.readLine();
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Realiza la operacion");
			Integer result = calcular(linea, num1, num2);
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Devuleve resultado");
			pw.write(result.toString() + "\n");
			pw.flush();
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Espera nueva peticion");
			
		}catch (IOException e) {
			e.printStackTrace();
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Error.");
		}
	}

}
