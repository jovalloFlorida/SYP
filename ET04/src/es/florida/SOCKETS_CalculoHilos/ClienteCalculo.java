package es.florida.SOCKETS_CalculoHilos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClienteCalculo {

	public static void main(String[] args) throws IOException {
		
		String nombreCliente = "CLIENTE";
		String[] operacion = {"+","100","50"};
		if (args.length>0) {
			nombreCliente = args[0];
			operacion[0] = args[1];
			operacion[1] = args[2];
			operacion[2] = args[3];
		}
		
		
		System.out.println(nombreCliente + " >>> Arranca cliente");
		System.out.println(nombreCliente + " >>> Conexional servidor");
		InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
		Socket socket = new Socket();
		socket.connect(direccion);
		
		System.out.println(nombreCliente + " >>> Envio de datos para el calculo: " + operacion[1] + " "+ operacion[0] + " "+ operacion[2]);
		PrintWriter pw = new PrintWriter(socket.getOutputStream());
		pw.print(operacion[0] +"\n");
		pw.print(operacion[1] +"\n");
		pw.print(operacion[2] +"\n");
		pw.flush();
		
		System.out.println(nombreCliente + " >>> Preparado canal para recibir resultado");
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
						
		String resultado = bfr.readLine();
		System.out.println(nombreCliente + " >>> Recibe resultado: " + resultado);
	}

}
