package AE03_T3_Multihilo;

public class App{

	public static Mina newMina; //declaro mina como static para poder acceder en minero
	
	public static void main(String[] args) throws InterruptedException {
		
		int cantidadMineros = 10; //cantidad de hilos
		int cantidadInicialBolsaMinero = 0; //oro inicial en bolsa mineros
		int tiempoExtraccionMinero = 500; // tiempo en extraer 1 oro cada minero
		int cantidadOroEnMina = 500; // oro total de la mina
		
		 Ventilador ventilador = new Ventilador(); // creo el objeto ventilador
		 
			//Hilo ventilador encendido
			Thread threadVentiladorEncendido = new Thread(new Runnable() {
	
				@Override
				public void run() {
					ventilador.encenderVentilador(); //llamo al metodo de encender ventilador
				}
			});
			
			//Hilo ventilador apagado
			Thread threadVentiladorApagado = new Thread(new Runnable() {
	
				@Override
				public void run() {
					ventilador.apagarVentilador();//llamo al metodo de apagar ventilador
				}
			});
			
			threadVentiladorEncendido.start(); //inicio el hilo
			threadVentiladorApagado.start();//inicio el hilo
		
		newMina = new Mina(cantidadOroEnMina); //objeto mina donde le asigno una nueva mina con la cantidad por parametro
	
		Minero objetoMinero; // creo objeto minero
		
		Thread hiloMinero = null; // creo objeto hilo
		
		for (int i = 0; i < cantidadMineros; i++) { // for que recorre el total de hilos
			objetoMinero = new Minero(cantidadInicialBolsaMinero,tiempoExtraccionMinero); // creo por cada iteracion del for 1 nuevo minero pasandole parametros
			hiloMinero = new Thread(objetoMinero); // creo en cada iteracion del for un nuevo hilo pasandole el objeto del minero
			hiloMinero.setName("Minero " + (i + 1)); // asigno nombre al hilo apartir de la i que va incrementando en las iteraciones del for
			hiloMinero.start();//inicio los hilos
		}
	
		boolean done = false; // iniciamos boleana en false
		while (!done) // mientras done sea false..
		{
		    try
		    {
		    	hiloMinero.join(); // espero a que acabe el ultimo hilo
		    	System.err.println("Total oro extraido por los mineros: " + Minero.totalOroExtraido); // imprimo el total de oro apartir de una variable estatica de minero
		        done = true; // paso el done a true para que solo ocurra una vez el contenido del while
		    }
		    catch (InterruptedException e)
		    {
		        // Handle interrupt determine if need to exit.
		    }
		}
	}
}

	





