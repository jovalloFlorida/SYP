/**
 * Implementa una clase denominada “Contador” que implemente Runnable con tres atributos: 
 * un atributo de tipo String denominado “nombreHilo”, otro atributo de tipo entero denominado “inicioContador” 
 * y otro de tipo entero denominado “limiteContador”, que indicará el fin de la cuenta. El programa principal
 *  deberá crear 5 hilos contadores con límites distintos y que se muestre por pantalla la cuenta de cada uno.
 */

package es.florida.ET03;

public class Contador implements Runnable{

	int inicioContador, limiteContador;
	String nombreHilo;
	
	Contador (String nombreHilo, int inicioContador, int limiteContador){
		this.inicioContador = inicioContador;
		this.limiteContador = limiteContador;
		this.nombreHilo = nombreHilo;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayNombresHilos = {"hilo1","hilo2","hilo3","hilo4","hilo5"};
		int[] arrayInicios= {1,11,21,31,41};
		int[] arrayLimites= {10,20,30,40,50};
		Contador objetoContador;
		Thread hiloContador;
		for (int i=0;i<5;i++) {
			objetoContador= new Contador(arrayNombresHilos[i],arrayInicios[i],arrayLimites[i]);
			hiloContador= new Thread(objetoContador);
			hiloContador.start();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = inicioContador;i<limiteContador;i++) {
			System.out.println("Contador " + nombreHilo + " (de " + inicioContador + " a " + limiteContador + "): " + i);
		}
		
	}

}
