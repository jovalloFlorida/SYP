/*
 * *Crea una variación del programa anterior (Caracol) que asigne a todos los caracoles la misma velocidad, pero prioridades distintas a sus hilos correspondientes.
 */


package es.florida.ET03;

public class Caracol2 implements Runnable {

	double distancia = 1;
	double velocidad;
	String nombre;

	Caracol2(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] arrayNombres = { "Turbo", "Rayo", "Flash", "Viento", "Lightspeed" };
		double[] arrayVelocidades = { 0.01, 0.01, 0.01, 0.01, 0.01 };
		int[] arrayPrioridades = {1,2,3,4,10};
		Caracol2 objetoCaracol;
		Thread hiloCaracol;
		for (int i = 0; i < 5; i++) {
			objetoCaracol = new Caracol2(arrayNombres[i], arrayVelocidades[i]);
			hiloCaracol = new Thread(objetoCaracol);
			hiloCaracol.setPriority(arrayPrioridades[i]);
			hiloCaracol.start();
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		double avance = 0;
		double porcentaje = 0;
		System.out.println(nombre + " inicia la carrera");
		while (avance < distancia) {
			avance += velocidad * 1;
			porcentaje = 100 * avance / distancia;
			System.out.println(nombre + " >. " + String.format("%.0f", porcentaje) + "%");
//			try {
//				Thread.sleep(200);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		}
		System.out.println(" -> ¡¡¡" + nombre + " ha llegado a la meta!!!");
	}

}
