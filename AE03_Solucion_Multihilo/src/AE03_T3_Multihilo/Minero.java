package AE03_T3_Multihilo;

public class Minero implements Runnable{//implemento Runnable porque con esta clase crearemos los hilos (Threads)

	int bolsa = 0; //bolsa donde guaradremos el oro del minero
	int tiempoExtraccion; // tiempo de extraccion del oro de la mina
	int cantidadExtraccionPorTurno = 1; // cantidad de oro que extrae el minero en cada turno
	public static int totalOroExtraido = 0; // total de oro extraido por este minero
	
	public Minero (int bolsa, int tiempoExtraccion){ //bolsa(guarda recursos que recolecta) tiempoExtraccion(tiempo necesario para extraer un recurso)
		this.bolsa = bolsa;
		this.tiempoExtraccion = tiempoExtraccion;
	}
	
	//Metodo thread-safe para asegurarnos que el proceso de extraer recurso es seguro
	synchronized public void extraerRecursos() throws InterruptedException {
		
		String nombre = Thread.currentThread().getName(); // guardamos en variable el nombre del hilo

		while(App.newMina.stock >= 0) { // mientras haya oro en la mina
			
			Thread.sleep(tiempoExtraccion);//simulamos el tiempo de extraccion
			System.out.println(nombre + " ha recolectado " + bolsa + " de oro"); 
			App.newMina.stock -= cantidadExtraccionPorTurno; // restamos de la mina el oro extraido por el minero
			bolsa += cantidadExtraccionPorTurno; //sumamos a la bola el oro extraido por el minero
			totalOroExtraido += cantidadExtraccionPorTurno; // sumamos el oro al total de oro extraido
		}
		
		if(App.newMina.stock < 0) { // si ya no hay oro en la mina
			System.out.println(nombre + " no ha podido extraer " + cantidadExtraccionPorTurno + " de oro en la mina, no queda oro en la mina!");
			totalOroExtraido -= cantidadExtraccionPorTurno; // restamos 1 oro al total de oros extraidos
		}
	}

	@Override
	public void run() { // run que ejecuta con el start del thread
		
		try {
			extraerRecursos(); //llamamos al metodo extraerRecursos
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
