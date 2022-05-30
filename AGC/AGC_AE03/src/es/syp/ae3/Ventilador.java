package es.syp.ae3;

public class Ventilador {

	int encendido = 1;
	int tiempo = 2000;
	
	
	//M�todo: encederVentilador
		// Descripci�n: puesta en marcha del ventilador durante 2 segundos de tiempo.
		//	Dise�ado para trabajar de manera alterna y sincronizada con hilos que implementen el m�todo apagarVentilador().
		//	Funciona mientras que la mina tenga oro para extraer, que la luz est� muy cara.
		// Par�metros de entrada: no.
		// Par�metros de salida: no.
	public void encenderVentilador() {
		while(App.mina.getStock() > 0) {
			synchronized(this) {
				try {
					while (encendido == 2) wait();
					System.err.println("Ventilador ENCENDIDO durante " + tiempo / 1000 + " segundos.");
					Thread.sleep(tiempo);
					encendido = 2;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	
	//M�todo: apagarVentilador
		// Descripci�n: apagado del ventilador durante 2 segundos de tiempo.
		//	Dise�ado para trabajar de manera alterna y sincronizada con hilos que implementen el m�todo encender Ventilador().
		//	Funciona mientras que la mina tenga oro para extraer, que la luz est� muy cara.
		// Par�metros de entrada: no.
		// Par�metros de salida: no.
	public void apagarVentilador() {
		while(App.mina.getStock() > 0) {
			synchronized(this) {
				try {
					while (encendido == 1) wait();
					System.err.println("Ventilador APAGADO durante " + tiempo / 1000 + " segundos.");
					Thread.sleep(tiempo);
					encendido = 1;
					notify();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	

}
