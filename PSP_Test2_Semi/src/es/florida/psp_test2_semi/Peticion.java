package es.florida.psp_test2_semi;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class Peticion implements Runnable {
	
	Socket socket;

	public Peticion(Socket socket){
		this.socket = socket;
	}

	public boolean compruebaUsuario(Usuario objUsuario) throws IOException {
		boolean respuesta = false;
		boolean respuestaUsuario = false;
		boolean respuestaContrasenya = false;
		
		File ficheroUsuarios = new File("Usuarios_autorizados.txt");
		FileReader fr = new FileReader(ficheroUsuarios);
		BufferedReader brFichero = new BufferedReader(fr);
		String linea = brFichero.readLine();
		int idUsuario = 0;
		while(linea != null) {
			if (linea.equals(objUsuario.getUsuario())) {
				respuestaUsuario = true;
				break;
			}
			linea = brFichero.readLine();
			idUsuario++;
		}
		brFichero.close();
		fr.close();
		
		File ficheroContrasenyas = new File("Contrasenyas_autorizadas.txt");
		fr = new FileReader(ficheroContrasenyas);
		brFichero = new BufferedReader(fr);
		for (int i = 0; i <= idUsuario; i++) {
			linea = brFichero.readLine();
		}
		if (linea.equals(objUsuario.getContrasenya())) {
			respuestaContrasenya = true;
		}
		brFichero.close();
		fr.close();
		
		if (respuestaUsuario && respuestaContrasenya) {
			respuesta = true;
		}
		
		return respuesta;
	}
	
	@Override
	public void run() {
		
		try {
			//Preparar buffer para lectura
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader bfr = new BufferedReader(isr);
			
			//Preparar printwriter para escritura
			OutputStream os = socket.getOutputStream();
			PrintWriter pw = new PrintWriter(os);
			
			//Preparar recepcion de objetos
			ObjectInputStream inObjeto = new ObjectInputStream(socket.getInputStream());
			
			System.err.println("SERVIDOR: Esperando objeto de usuario...");
			Usuario objUsuario = (Usuario) inObjeto.readObject();
			System.err.println("SERVIDOR: Recibido objeto de usuario:");
			System.err.println("SERVIDOR: " + objUsuario.toString());
			System.err.println("SERVIDOR: Comprobando credenciales");
			boolean respuesta = compruebaUsuario(objUsuario);
			if (respuesta) {
				pw.write("200 OK\n");
				pw.flush();
				System.err.println("SERVIDOR: Cliente autenticado. Enviado mensaje de confirmacion");
			} else {
				pw.write("ERROR\n");
				pw.flush();
				System.err.println("SERVIDOR: Cliente no autenticado. Se cierra la conexion");
				pw.close();
				bfr.close();
				inObjeto.close();
				socket.close();
				return;
			}
			
			System.err.println("SERVIDOR: Esperando numero de lineas...");
			String numeroLineas = bfr.readLine();
			FileWriter fw = new FileWriter("contenido.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			pw.write("PREPARADO\n");
			pw.flush();
			System.err.println("SERVIDOR: Creado fichero contenido.txt. Esperando " + numeroLineas + " lineas del cliente...");
			
			for (int i = 0; i < Integer.parseInt(numeroLineas); i++) {
				String lineaActual = bfr.readLine();
				System.err.print("SERVIDOR: Recibida linea " + (i + 1) + ": " + lineaActual);
				bw.write(lineaActual + "\n");
				System.err.print("SERVIDOR: Guardada linea " + (i + 1) + " en fichero");
			}
			bw.close();
			
			String mensajeFin = bfr.readLine();
			System.err.println("SERVIDOR: Recibido mensaje del cliente " + mensajeFin);
			pw.write("FIN SERVIDOR\n");
			pw.flush();
			System.err.println("SERVIDOR: Envia mensaje de finalizacion. Cierra conexion.");
			pw.close();
			bfr.close();
			inObjeto.close();
			socket.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	
}
