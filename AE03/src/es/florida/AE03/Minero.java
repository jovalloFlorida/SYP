package es.florida.AE03;

public class Minero implements Runnable {
	
	static int bolsa;
	static int tiempoExtraccion = 1000;
	Mina objetoMina;
	int descontar;
	

	public Minero(Mina laMina) {
		Minero.bolsa=0;
		this.objetoMina= laMina;
	}
	
	public void run() {
		extraerRecurso();
	}
	
	public void extraerRecurso() {
		while(objetoMina.getStock() != 0) {
			Minero.bolsa=bolsa + 1;
			this.objetoMina.setStock(objetoMina.getStock() - 1);
			//descanso
			
			System.out.println(Thread.currentThread().getName() + " Quedan en la mina " + objetoMina.getStock() + " Recursos.");
			
		}
		
	}
	
	
	public void descanso() {
		try {
			Thread.sleep(tiempoExtraccion);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
