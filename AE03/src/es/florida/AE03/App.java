package es.florida.AE03;

public class App {

	static Mina objetoMina;
	static Minero objetoMinero;
	boolean descontar = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int cantidadRecursos = 100;
		objetoMina = new Mina(cantidadRecursos);
		
		Thread recolector;
		//creacion de recolectores
		for (int i=1; i < 15; i++) {
			objetoMinero = new Minero(objetoMina);
			recolector = new Thread(objetoMinero);
			recolector.setName("Recolector " + (i));
			recolector.start();
		}
	}

}
