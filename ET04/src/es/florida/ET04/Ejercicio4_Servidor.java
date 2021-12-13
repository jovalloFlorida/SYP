/**
 * De manera análoga al ejemplo visto en teoría, crea una clase servidor que cada vez que se conecte un cliente, 
 * le envíe un objeto del tipo que has creado en el ejercicio anterior para que el cliente lo rellene. 
 * Una vez recibido el objeto, lo deberá mostrar por pantalla. Es importante que te detengas en ver qué hace cada una de las instrucciones que estás utilizando.
 */
package es.florida.ET04;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Ejercicio4_Servidor {

	public static void main(String[] arg) throws IOException, ClassNotFoundException, InterruptedException {
		int numeroPuerto = 5000;
		ServerSocket servidor = new ServerSocket(numeroPuerto);
		System.err.println("SERVIDOR >> Escuchando...");
		Socket cliente = servidor.accept();
		Thread.sleep(2000);
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
		Ejercicio3_Vehiculo vehiculo = new Ejercicio3_Vehiculo("Marca", "Modelo");
		outObjeto.writeObject(vehiculo);
		System.err.println("SERVIDOR >> Envio a cliente: " + vehiculo.getMarca() + " - " + vehiculo.getModelo());
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Ejercicio3_Vehiculo vehiculoMod = (Ejercicio3_Vehiculo) inObjeto.readObject();
		Thread.sleep(2000);
		System.err.println("SERVIDOR >> Recibo de cliente: " + vehiculoMod.getMarca() + " - " + vehiculoMod.getModelo());
		outObjeto.close();
		inObjeto.close();
		cliente.close();
		servidor.close();

	}

}
