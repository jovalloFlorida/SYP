/**
 * Clase “Minero” con dos atributos enteros que sean “bolsa” (donde guarda los recursos que recolecta) y “tiempoExtraccion” 
 * (tiempo de trabajo necesario para extraer un recurso) y dos métodos: un método constructor que inicialice la bolsa a 0; 
 * y un método “extraerRecurso” que extraiga de la mina un recurso en cada turno y lo guarde en su bolsa. 
 * Para simular un turno de trabajo se deberá incluir una pausa (definida por la variable tiempoExtraccion, 
 * en milisegundos -por ejemplo 1000 ms-) cada vez que se ejecute el método “extraerRecurso”.
 */
package es.florida.AE03;

public class Minero implements Runnable {
	
	static int bolsa;
	static int tiempoExtraccion = 1000;
	Mina objetoMina;
	int descontar;
	int totalExtraido=0;
	

	public Minero(Mina laMina) {
		Minero.bolsa=0;
		this.objetoMina= laMina;
	}
	
	public void run() {
		extraerRecurso();
	}
	
	public void extraerRecurso() {
		while(objetoMina.getStock() != 0) {
			bolsa=bolsa + 1;
			this.objetoMina.setStock(objetoMina.getStock() - 1);
			tiempoDescanso();
			totalExtraido = totalExtraido + bolsa;
			System.out.println(Thread.currentThread().getName() + " ha extraido de la mina " + objetoMina.getStock() + " Oros.");
		}
		if (objetoMina.getStock() == 0) {
			System.err.println(Thread.currentThread().getName() + " ha extraido y recolectado TOTAL " +  totalExtraido + " Oros");
		}

	}
	
	
	public void tiempoDescanso() {
		try {
			Thread.sleep(tiempoExtraccion);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
