package es.florida.SOCKETS_calculo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lanzador {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		
		//Lanzamos la clase ServidorCalculo
		String className = "es.florida.SOCKETS_calculo.ServidorCalculo";
		List<String> command = new ArrayList<>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classpath);
		command.add(className);
		ProcessBuilder builder = new ProcessBuilder(command);
		builder.inheritIO().start();
		
		//Lanzamos la clase ClienteCalculo
		className = "es.florida.SOCKETS_calculo.ClienteCalculo";
		command = new ArrayList<>();
		command.add(javaBin);
		command.add("-cp");
		command.add(classpath);
		command.add(className);
		builder = new ProcessBuilder(command);
		builder.inheritIO().start();
	}

}
