package es.syp.ae3;

public class Minero implements Runnable {

	int bolsa;
	int tiempoExtraccion = 500;

	Minero() {
		this.bolsa = 0;
	}

	
	// M�todo: extraerRecurso
		// Descripci�n: Bucle que itera mientras la mina tenga oro. Se implementa un Thread.sleep a modo de
		// 	"tiempo de extracci�n" para establecer un ritmo de proceso. En cada iteraci�n resta 1 unidad al stock (cantidad de oro)
		// 	de la mina y suma 1 unidad a la bolsa de los mineros. Al final, se ejecuta un wait de 0,2 segundos para alternar el proceso de los diferentes hilos en el bucle.
		// Par�metros de entrada: string.
		// Par�metros de salida: no.
	synchronized public void extraerRecurso(String nombre) throws InterruptedException {
		while (App.mina.getStock() > 0) {
				Thread.sleep(tiempoExtraccion);
				System.out.println(nombre + " extrae 1 oro.");
				App.mina.setStock(App.mina.getStock() - 1);
				App.minero.bolsa++;
				wait(200);
		}
	}

	
	// M�todo: run
		// Descripci�n: puesta en marcha de los hilos instanciados en la clase principal.
		//	Obtiene el nombre (string) de cada hilo y lo pasa como par�metro al m�todo extraerRecurso() para su ejecuci�n.
		// Par�metros de entrada: no.
		// Par�metros de salida: no.
	@Override
	synchronized public void run() {
		String nombre = Thread.currentThread().getName();

		try {
			extraerRecurso(nombre);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	
}
