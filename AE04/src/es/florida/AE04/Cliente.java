/**
 * Clase cliente para la introduccion de la contraseña, envio a Servidor y la recibe ya encriptada.
 */
package es.florida.AE04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] arg) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
		
		
		
		System.out.println("CLIENTE >> Arranca cliente -> esperando mensaje del Servidor...");
		InetSocketAddress direccionAddress =new InetSocketAddress("localhost", 1234 );
		Socket socket = new Socket();
		socket.connect(direccionAddress);
		
		ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
		Contrasenya passwd = (Contrasenya) inObjeto.readObject();
		
		System.out.println("CLIENTE >>> Recibo del servidor... ");
		System.out.println("CLIENTE >>> Actualizar informacion del objeto...");
		
		System.out.print("CLIENTE >>> Introducir Contrasenya Texto Plano: ");
		Scanner teclado = new Scanner(System.in);
		String passwdTextoPlano = teclado.nextLine();
		
		passwd.setcontrasenyaTextoPlano(passwdTextoPlano);
						
		ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
		outObjeto.writeObject(passwd);
		
		System.out.println("CLIENTE >>> Envio informacion al SERVIDOR... ");
		InputStream is = socket.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader bfr = new BufferedReader(isr);
		
		String resultado = bfr.readLine();
		System.out.println("CLIENTE >>> Recibe informacion del SERVIDOR...");
		System.out.println("CLIENTE >>> " + resultado);
		 
		
	}
}
