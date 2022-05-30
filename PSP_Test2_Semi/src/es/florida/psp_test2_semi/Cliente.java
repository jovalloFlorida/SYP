package es.florida.psp_test2_semi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		
		try {
			
			System.out.println("CLIENTE: Arranca cliente");
			System.out.println("CLIENTE: Conexion al servidor");
			InetSocketAddress direccion = new InetSocketAddress("localhost", 9876);
			Socket socket = new Socket();
			socket.connect(direccion);
			
			//Preparar buffer para lectura
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bfr = new BufferedReader(isr);
			
			//Preparar printwriter para escritura
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			//Preparar envio de objetos
			ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
			
			Scanner teclado = new Scanner(System.in);
			System.out.print("CLIENTE: Usuario: ");
			String usuario = teclado.nextLine();
			System.out.print("CLIENTE: Contrasenya: ");
			String contrasenya = teclado.nextLine();
			
			Usuario objUsuario = new Usuario(usuario, contrasenya);
			outObjeto.writeObject(objUsuario);
			System.out.println("CLIENTE: Enviado objeto usuario al servidor");
			System.out.println("CLIENTE: Esperando respuesta del servidor...");
			
			String respuestaAutenticacion = bfr.readLine();
			String numeroLineas = "";
			if (respuestaAutenticacion.equals("200 OK")) {
				System.out.print("CLIENTE: Indica numero de lineas a enviar: ");
				numeroLineas = teclado.nextLine();
				pw.write(numeroLineas + "\n");
				pw.flush();
				System.out.println("CLIENTE: Enviado numero de lineas al servidor");
			} else if (respuestaAutenticacion.equals("ERROR")) {
				System.out.print("CLIENTE: Error en la autenticacion. Se cerrara la conexion.");
				pw.close();
				bfr.close();
				outObjeto.close();
				socket.close();
				return;
			}
			
			String servidorPreparado = bfr.readLine();
			if (!servidorPreparado.equals("PREPARADO")) {
				System.out.println("CLIENTE: El servidor no esta preparado, se cierra conexion");
				pw.close();
				bfr.close();
				outObjeto.close();
				socket.close();
				return;
			}
			
			System.out.println("CLIENTE: Solicitando " + numeroLineas + " lineas de texto:");
			for (int i = 0; i < Integer.parseInt(numeroLineas); i++) {
				System.out.print("CLIENTE: Linea " + (i + 1) + ": ");
				String lineaActual = teclado.nextLine();
				pw.write(lineaActual + "\n");
				pw.flush();
				System.out.println("CLIENTE: Linea " + (i + 1) + " enviada al servidor");
			}
			
			pw.write("FIN CLIENTE\n");
			pw.flush();
			System.out.println("CLIENTE: Envia mensaje de finalizacion");
			
			String mensajeFin = bfr.readLine();
			System.out.println("CLIENTE: Recibido mensaje del servidor " + mensajeFin + ". Cierra conexion.");
			
			pw.close();
			bfr.close();
			outObjeto.close();
			socket.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
