/**
 *Clase “App” con un método “main” que cree un objeto Mina y un pequeño ejército de hilos mineros (no menos de 10) 
 *que se dediquen a extraer los recursos de la mina. El programa finalizará cuando ya no queden recursos para extraer. 
 *Al finalizar deberá mostrar la suma de todo lo recolectado por los mineros. 
 */

package es.florida.AE03;

public class App {

	static Mina objetoMina;
	static Minero objetoMinero;
	boolean descontar = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cantidadRecursos = 10000;
		objetoMina = new Mina(cantidadRecursos);
		
		Thread recolector;
		//creacion de recolectores
		for (int i=1; i < 10; i++) {
			objetoMinero = new Minero(objetoMina);
			recolector = new Thread(objetoMinero);
			recolector.setName("Recolector " + (i));
			recolector.start();
		}
	}

}
