package es.florida.SOCKETS_CalculoHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Peticion implements Runnable {

	BufferedReader bfr;
	PrintWriter pw;
	Socket socket;

	public Peticion(Socket socket) {
		this.socket = socket;
	}

	public int extraerNumero(String linea) {
		int numero;
		try {
			numero = Integer.parseInt(linea);
		} catch (NumberFormatException e) {
			numero = 0;
		}
		if (numero >= 100000000) {
			numero = 0;
		}
		return numero;
	}

	public int calcular(String op, String n1, String n2) {
		int resultado = 0;
		char simbolo = op.charAt(0);
		int num1 = extraerNumero(n1);
		int num2 = extraerNumero(n2);
		if (simbolo == '+') {
			resultado = num1 + num2;
		}
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
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Devuelve resultado");
			pw.write(result.toString() + "\n");
			pw.flush();
		} catch (IOException e) {
			e.printStackTrace();
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Error.");
		}
	}

}
