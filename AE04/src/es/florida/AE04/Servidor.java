/**
 * Clase cliente para la introduccion de la contraseña a modificar
 */
package es.florida.AE04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Servidor implements Runnable {

	BufferedReader bfr;
	PrintWriter pw;
	Socket socket;

	public Servidor(Socket socket) {
		this.socket = socket;
	}

	/**
	 * Metodo para una vez recibida la contraseña, la devuelve encriptada
	 * (Sustitucion por caractes ASCII inmediatamente posterior de la tabla ASCII.
	 * 
	 * @param pwd
	 * @return
	 */
	public static String conversion(String pwd) {

		int longitud = pwd.length();
		String nuevoPasswd = "";
		char nuevoCaracter;

		for (int i = 0; i < longitud; i++) {

			char caracter = pwd.charAt(i);
			int numeroASCII = (int) caracter;

			if ((numeroASCII > 33) && (numeroASCII < 126)) {
				nuevoCaracter = ((char) (numeroASCII + 1));
			} else {
				nuevoCaracter = (char) 42;
			}
			nuevoPasswd = nuevoPasswd + nuevoCaracter;
		}
		return nuevoPasswd;
	}

	/**
	 * Metodo para encriptar la contraseña en MD5
	 * 
	 * @param input
	 * @return
	 */
	public static String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

	public void run() {

		try {
			// Creacion y envio del objeto
			ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
			Contrasenya passwd = new Contrasenya("", "");
			outObjeto.writeObject(passwd);

			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Conexion Recibida...");

			// Recibimiento del Objeto
			ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
			Contrasenya pMod = (Contrasenya) inObjeto.readObject();
			String contrasenyaPlana = pMod.getcontrasenyaTextoPlano();

			// Realiza la conversion de la contraseña y se pide que tipo de encryptacion (ASCII / MD5)
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Servidor realiza la conversion...");
			System.out.print("SERVIDOR >>> Introduce tipo Contraseña Encryptada (1. ASCII / 2. MD5): ");
			Scanner teclado = new Scanner(System.in);
			int tipoContrasenya = Integer.parseInt(teclado.next());
			String newPasswd = "";
			
			switch (tipoContrasenya) {
			case 1:
				newPasswd = "Contraseña Encryptada ASCII: " + conversion(contrasenyaPlana);
				break;
			case 2:
				newPasswd = "Contraseña Encryptada MD5: " + getMD5(contrasenyaPlana);
				break;
			default:
				System.err.print("SERVIDOR >>> OPCION INCORRECTA... ");
				break;
			}	
			
			pMod.setcontrasenyaTextoPlano(newPasswd);

			// Devuleve el resultado
			System.err.println("SERVIDOR Hilo " + Thread.currentThread().getName() + " >>> Servidor devuelve el resultado...");
			OutputStream os = socket.getOutputStream();
			pw = new PrintWriter(os);
			pw.write(newPasswd + "\n");
			pw.flush();

		} catch (Exception e) {
			System.out.println("\n <<< Excepcion: Opcion no Admitida >>>");
		}

	}

}
