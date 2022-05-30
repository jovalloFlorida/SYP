package es.syp.ae4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	
	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
			
			Scanner teclado = new Scanner(System.in);
			
			System.out.print("Introducir IP: ");
			String host = teclado.nextLine();
			System.out.print("Introducir puerto: ");
			int puerto = Integer.parseInt(teclado.nextLine());
			
			Socket cliente = new Socket(host, puerto);
			System.out.println("\nCLIENTE >> Arranca cliente --> Esperando mensaje del servidor...");
			
			ObjectInputStream inObjeto = new ObjectInputStream(cliente.getInputStream());
			Contrasenya contrasenya = (Contrasenya) inObjeto.readObject();
			System.out.println("\nCLIENTE >> Recibo del servidor la contrase�a plana (vac�a)");
			
			System.out.print("CLIENTE >> Introducir nueva contrase�a: ");
			String nuevaContrasenya = teclado.nextLine();
			contrasenya.setContrasenyaPlana(nuevaContrasenya);
			System.out.println("CLIENTE >> Env�o al servidor la nueva contrase�a: " + contrasenya.getContrasenyaPlana());
			ObjectOutputStream outObjeto = new ObjectOutputStream(cliente.getOutputStream());
			outObjeto.writeObject(contrasenya);
			
			Thread.sleep(2000);
		
			System.out.println("\nCLIENTE >> Recibo consulta sobre encriptaci�n");
			DataInputStream inData = new DataInputStream(cliente.getInputStream());
			System.out.print(inData.readUTF());
			String encriptado = teclado.nextLine();
			encriptado = encriptado.toLowerCase();
			
			System.out.println("CLIENTE >> Env�o tipo de encriptaci�n");
			DataOutputStream outData = new DataOutputStream(cliente.getOutputStream());
			outData.writeUTF(encriptado);
			outData.flush();
			
			Thread.sleep(2000);

			Contrasenya contrasenyaCompleta = (Contrasenya) inObjeto.readObject();
			
			if (!contrasenyaCompleta.getContrasenyaEncriptada().equals("")) {
				System.out.println("\nCLIENTE >> Recibo contrase�a completa --> " + contrasenyaCompleta.toString());
			} else {
				System.out.println("\nERROR en la encriptaci�n. El tipo de encriptado solicitado no es v�lido");
			}
			
			outObjeto.close();
			inObjeto.close();
			cliente.close();
			teclado.close();
		}

}
