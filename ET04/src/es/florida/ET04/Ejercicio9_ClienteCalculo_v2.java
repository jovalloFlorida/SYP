/**
 * Modifica el programa ClienteCalculo para que admita como parámetros de entrada (argumentos) los 3 parámetros 
 * que necesita para hacer una petición al servidor (tipo de operación (+ - * /), número 1 y número2) más un String 
 * con el nombre que se asignará al cliente.
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

public class Ejercicio9_ClienteCalculo_v2 {

	public static void main(String[] args) throws IOException {

		String nombreCliente = "CLIENTE";
		String[] operacion = { "*", "100", "50" };
		if (args.length > 0) {
			nombreCliente = args[0];
			String tipoOperacion = args[1];
			if (tipoOperacion.length() >1) {
				operacion[0] = tipoOperacion.substring(1);
			} else {
				operacion[0] = tipoOperacion;
			}
			operacion[1] = args[2];
			operacion[2] = args[3];
		}

		System.out.println(nombreCliente + " >>> Arranca cliente");
		System.out.println(nombreCliente + " >>> Conexion al servidor");
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduce la IP: ");
		String host = teclado.nextLine();
		InetSocketAddress direccion = new InetSocketAddress(host, 9876);
		Socket socket = new Socket();
		socket.connect(direccion);

		System.out.println(nombreCliente + " >>> Envio de datos para el calculo: " + operacion[1] + " " + operacion[0]
				+ " " + operacion[2] + " " + nombreCliente);
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		pw.print(operacion[0] + "\n");
		pw.print(operacion[1] + "\n");
		pw.print(operacion[2] + "\n");
		pw.print(nombreCliente + "\n");
		pw.flush();

		System.out.println("CLIENTE >>> Preparado canal para recibir resultado");
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
		String resultado = bfr.readLine();
		System.out.println(nombreCliente + " >>> Recibe resultado: " + resultado);

		socket.close();

	}

}
