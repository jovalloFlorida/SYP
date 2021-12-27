package es.florida.SOCKETS;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClienteObjeto {

	public static void main(String[] arg) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
		String host = "localhost";
		int puerto = 5000;
		Thread.sleep(2000);
		System.out.println("CLIENTE >> Arranca cliente...");
		Thread.sleep(2000);
		Socket cliente = new Socket(host, puerto);
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Persona p = (Persona) inObjeto.readObject();
		System.out.println("CLIENTE >> Recibo del servidor: " + p.getNombre() + " - " + p.getEdad());
		p.setNombre("Jose Garcia");
		p.setEdad(30);
		Thread.sleep(2000);
		System.out.println("CLIENTE >>> Actualizo informacion...");
		Thread.sleep(2000);
		ObjectOutputStream pMod = new ObjectOutputStream(cliente.getOutputStream());
		pMod.writeObject(p);
		System.out.println("CLIENTE >> Envio al servidor: " + p.getNombre() + " - " + p.getEdad());
		Thread.sleep(2000);
		inObjeto.close();
		pMod.close();
		cliente.close();
	}
}