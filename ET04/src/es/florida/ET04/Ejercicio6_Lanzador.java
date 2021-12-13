/**
 * Como habrás podido observar, cada uno de los programas anteriores se ejecuta de forma independiente (cada uno tiene su main). 
 * Una forma de ver la ejecución en Eclipse es creándote un tercer programa que funcione como lanzador, tal como hiciste en el tema sobre Multiproceso. 
 * Implementa ahora un programa lanzador que ejecute el servidor y el cliente y que muestre todas las salidas por consola.
 */

// NO FUNCIONA CORRECTAMENTE PORQUE NO PERMITE RECOGER LAS ENTRADAS POR TECLADO, LANZAR EJ. 4 Y 5 POR SEPARADO.

package es.florida.ET04;

import java.io.File;
import java.io.IOException;

public class Ejercicio6_Lanzador {

	public static void main(String[] args) throws IOException {
		String javaHome = System.getProperty("java.home");
		String javaBin = javaHome + File.separator + "bin" + File.separator + "java";
		String classpath = System.getProperty("java.class.path");
		
		String className = "es.florida.ET04.Ejercicio4_Servidor";
		ProcessBuilder builder = new ProcessBuilder(javaBin, "-cp",classpath,className);
		builder.inheritIO().start();
		
		className = "es.florida.ET04.Ejercicio5_Clienter";
		builder = new ProcessBuilder(javaBin, "-cp",classpath,className);
		builder.inheritIO().start();
	}

}
