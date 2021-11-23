/**
 * Basándote en el problema del Productor-Consumidor (comunicación entre hilos), desarrolla un programa que tenga una clase “ControlSemaforos” 
 * con dos métodos que simulan dos semáforos distintos (“encenderSemaforo1” y “encenderSemaforo2”, que hace alternar los semáforos entre verde y rojo cada 3 segundos, 
 * no pudiendo estar los dos en el mismo estado a la vez) y un método “main” que crea un objeto “ControlSemaforos” y dos hilos, uno por cada semáforo.
 * Puedes utilizar una variable de tipo int para controlar qué semáforo está en verde, de forma que cuando 1 esté en verde, el semáforo 2 espere en rojo. 
 * Cuando pasen 5 segundos, el semáforo 1 que está en verde cambiará a rojo y lo notificará al semáforo 2, que dejará de esperar y pasará a verde durante otros 5 segundos.
 */
package es.florida.ET03;

public class Ejercicio6 {

	public static class Semaforos {

		int semaforo = 1;
		int tiempoFuncionamiento = 5000;

		public void encenderSemaforo1() {
			while (true) {
				synchronized (this) {
					try {
						while (semaforo == 2)
							wait();
						System.err.print("Semaforo 2 rojo");
						System.out.println(" -> Semaforo 1 verde durante " + tiempoFuncionamiento / 1000 + " segundos");
						Thread.sleep(tiempoFuncionamiento);
						semaforo = 2;
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

		public void encenderSemaforo2() {
			while (true) {
				synchronized (this) {
					try {
						while (semaforo == 1)
							wait();
						System.err.print("Semaforo 1 rojo");
						System.out.println(" -> Semaforo 2 verde durante " + tiempoFuncionamiento / 1000 + " segundos");
						Thread.sleep(tiempoFuncionamiento);
						semaforo = 1;
						notify();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Semaforos s = new Semaforos();

		// Hilo semaforo 1 encendido
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				s.encenderSemaforo1();
			}

		});

		// Hilo semaforo 2 encendido
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				s.encenderSemaforo2();
			}
		});
		t1.start();
		t2.start();

	}

}
