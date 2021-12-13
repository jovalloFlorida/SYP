package es.florida.ET04;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Ejercicio5_Cliente {

	public static void main(String[] arg) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introducir la IP: ");
		String host = teclado.nextLine();
		System.out.print("Introducir la Puerto: ");
		int puerto = Integer.parseInt(teclado.nextLine());
		System.out.println("CLIENTE >> Arranca cliente -> esperando mensaje del Servidor...");
		Socket cliente = new Socket(host, puerto);
		ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
		Ejercicio3_Vehiculo vehiculo = (Ejercicio3_Vehiculo) inObjeto.readObject();
		System.out.println("CLIENTE >> Recibo del servidor: " +  vehiculo.getMarca() + " - " + vehiculo.getModelo());
		System.out.println("CLIENTE >> Actualizar informacion del objeto...");
		System.out.print("Introducir Marca: ");
		String marca = teclado.nextLine();
		System.out.print("Introducir Modelo: ");
		String modelo = teclado.nextLine();
		vehiculo.setMarca(marca);
		vehiculo.setModelo(modelo);
		Thread.sleep(2000);
		System.out.println("CLIENTE >> Envio al servidor: " + vehiculo.getMarca() + " - " + vehiculo.getModelo());
		ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
		outObjeto.writeObject(vehiculo);
		inObjeto.close();
		outObjeto.close();
		cliente.close();
		teclado.close();

	}

}
