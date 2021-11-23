/**
 * El delegado de clase ha comprado un bote extra grande de alitas de pollo en el KFC (100 alitas) y los va a repartir entre los 30 compa�eros de clase. 
 * Para ello crea una clase que implementa Runnable y que tiene un m�todo �consumirAlita� que mientras queden alitas permite consumir el n�mero que pida cada compa�ero 
 * (entre 1 y 10 alitas, de forma aleatoria), un m�todo �run� (obligado al implementar Runnable) que llama a �consumirAlita� y un �main� que crea un hilo por cada compa�ero. 
 * El �main� deber� mostrar al final de la ejecuci�n cu�ntas alitas se han comido entre todos. Realiza dos ejecuciones: sin y con sincronizaci�n del m�todo �consumirAlita�
 *  (problema similar al de las entradas).
 */

package es.florida.ET03;

public class Ejercicio5 implements Runnable {

//	public static void main(String[] args) {
	// TODO Auto-generated method stub

	int alitasDisponibles = 100;
	static int alitasConsumidas = 0;

	synchronized public void consumirAlita(String nombre, int alitas) { // Con synchronized, proteges las variables
																		// alitasDisponibles y alitasConsumidas
																		// y la suma de 100 alitas consumidas es
																		// correcta

		// public void consumirAlita(String nombre, int alitas) { // Sin synchronized,
		// no salen bien la suma de 100 alitas consumidas
		if (alitas <= alitasDisponibles) {
			System.out.println(alitas + " alitas se come" + nombre);
			alitasDisponibles = alitasDisponibles - alitas;
			alitasConsumidas = alitasConsumidas + alitas;
		} else {
			System.out.println(nombre + " quiere " + alitas + " alitas, pero no quedan alitas suficientes :(((");
		}
	}

//	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		String nombre = Thread.currentThread().getName();
		int alitas = (int) (Math.random() * 10 + 1);
		consumirAlita(nombre, alitas);

	}

	public static void main(String[] args) {
		Ejercicio5 ej5 = new Ejercicio5();
		Thread t;
		for (int i = 0; i < 30; i++) {
			t = new Thread(ej5);
			t.setName("Amigo " + (i + 1));
			t.start();
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // Pausa para que acaben todos los threads
		System.out.println("Total alitas consumidas: " + alitasConsumidas);

	}

}
