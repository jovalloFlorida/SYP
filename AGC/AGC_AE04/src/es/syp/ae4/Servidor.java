package es.syp.ae4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.Socket;
import java.security.MessageDigest;

public class Servidor implements Runnable {
	
	BufferedReader bfr;
    PrintWriter pw;
    Socket socket;

    public Servidor(Socket socket) {
        this.socket = socket;
    }
	
    // M�todo: run
 		// Descripci�n: ejecuta los procesos del hilo.
 		// Par�metros de entrada: no.
 		// Par�metros de salida: no.
	@Override
	public void run() {
		
		try {
			
			Thread.sleep(2000);
			
			ObjectOutputStream outObjeto = new ObjectOutputStream(socket.getOutputStream());
			String nombreHilo = Thread.currentThread().getName();
			
			Contrasenya contrasenya = new Contrasenya("", "");
			outObjeto.writeObject(contrasenya);
			
			System.err.println(nombreHilo + " - SERVIDOR >> Envio a cliente la contrase�a plana (vac�a) para rellenar");
			
			Thread.sleep(2000);
			
			ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
			Contrasenya contrasenyaModificada = (Contrasenya) inObjeto.readObject();
			System.err.println(nombreHilo + " - SERVIDOR >> Recibo la contrase�a plana modificada por el cliente: " + contrasenyaModificada.getContrasenyaPlana());
			
			Thread.sleep(2000);
			
			DataOutputStream outData = new DataOutputStream(socket.getOutputStream());
			outData.writeUTF("Elige el tipo de encriptaci�n (ascii o md5): ");
			outData.flush();
			System.err.println(nombreHilo + " - SERVIDOR >> Env�o consulta al cliente sobre tipo de encriptaci�n");
			
			DataInputStream inData = new DataInputStream(socket.getInputStream());
			String encriptado = inData.readUTF();
			System.err.println(nombreHilo + " - SERVIDOR >> Recibo el tipo de encriptaci�n solicitada: " + encriptado);
			
			Thread.sleep(2000);
			
			if (encriptado.equals("ascii")) {
				
				System.err.println(Thread.currentThread().getName() + "SERVIDOR >> Comienza la encriptaci�n de la contrase�a en ASCII...");
				contrasenyaModificada.setContrasenyaEncriptada(EncriptadoASCII(contrasenyaModificada.getContrasenyaPlana()));
			
			} else if (encriptado.equals("md5")) {
				
				System.err.println(nombreHilo + " - SERVIDOR >> Comienza la encriptaci�n de la contrase�a en MD5...");
				contrasenyaModificada.setContrasenyaEncriptada(EncriptadoMD5(contrasenyaModificada.getContrasenyaPlana()));
			
			} else {
				System.err.println(nombreHilo + " - SERVIDOR >> Tipo de encriptaci�n no v�lido");
			}
			
			outObjeto.writeObject(contrasenyaModificada);
			
			if (!contrasenyaModificada.getContrasenyaEncriptada().equals("")) {
				System.err.println(nombreHilo + " - SERVIDOR >> Envio a cliente la contrase�a completa (plana y encriptada): " + contrasenyaModificada.getContrasenyaPlana() + " - " + contrasenyaModificada.getContrasenyaEncriptada());
			} else {
				System.err.println("ERROR en la encriptaci�n. El tipo de encriptado solicitado por el cliente no es v�lido");
			}
			
			outObjeto.close();
			inObjeto.close();
			socket.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	// M�todo: EncriptadoASCII
	 		// Descripci�n: recibe un string y lo "encripta" cambiando cada caracter por su sucesivo en la tabla ASCII. Si el caracter resultante fuera de tipo 'no imprimible', lo sustituye por un asterisco.
	 		// Par�metros de entrada: string.
	 		// Par�metros de salida: string.
	public static String EncriptadoASCII(String password) {
		
		String encriptada = "";
		
		for (int i=0; i < password.length(); i++) {
			char caracter = password.charAt(i);
			int ascii = caracter + 1;
			
			if (ascii >= 32 && ascii <= 126 ) {
				char caracterDos = (char) ascii;
				encriptada += caracterDos;
			} else {
				encriptada += "*";
			}
		}

		return encriptada;
	}
	
	
	// M�todo: EncriptadoMD5
		// Descripci�n: recibe un string y lo encripta con cifrado MD5.
		// Par�metros de entrada: string.
		// Par�metros de salida: string.	
	public static String EncriptadoMD5(String password) {
		MessageDigest md;
		   try {
		    // Genera un resumen de c�lculo cifrado MD5
		    md = MessageDigest.getInstance("MD5");
		        // Calcula la funci�n MD5
		    md.update(password.getBytes());
		        // digest () finalmente determina devolver el valor hash md5, y el valor devuelto es 8 como una cadena. Debido a que el valor hash md5 es un valor hexadecimal de 16 bits, en realidad es un car�cter de 8 bits
		        // La funci�n BigInteger convierte una cadena de 8 bits en un valor hexadecimal de 16 bits, que est� representado por una cadena; el valor hash se obtiene como una cadena
		    String pwd = new BigInteger(1, md.digest()).toString(16);
		    return pwd;
		   } catch (Exception e) {
		    e.printStackTrace();
		   }
		   return password;
		}

}
