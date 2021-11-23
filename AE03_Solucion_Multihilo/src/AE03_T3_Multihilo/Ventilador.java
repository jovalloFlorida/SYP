package AE03_T3_Multihilo;

public class Ventilador { // clase ventilador que crearemos en app

	boolean estado = false;//si esta encendido o apagado
	int tiempoFuncionamiento = 2000;//mismo tiempo de encendido que de apagado
	
	public void encenderVentilador() { //metodo encender ventilador
		
		while(true) { // bucle para que se ejecute siempre
			
			synchronized (this) { //hacer que sea thread safe
				
				try {// try para capturar errores
					
					while(estado == true) wait(); // mientras el estado sea true, esperamos al aviso del otro metodo ventilador
					System.err.print("Ventilador encendido!");
					System.out.println(" -> Ventilador encendido durante " + tiempoFuncionamiento / 1000 + " segundos"); //print en segundos del tiempo
					Thread.sleep(tiempoFuncionamiento); //tiempo de espera que simula el tiempo que esta funcionando
					estado = true;// estado pasa a true por lo tanto pasa a modo espera
					notify();//notificamos al otro metodo que puede empezar
				}catch (InterruptedException e) {
					e.printStackTrace();// imprime errores capturados
				}
			}
		}
	}
	
	public void apagarVentilador() {//metodo apagar ventilador
		
		while(true) { // bucle para que se ejecute siempre
			
			synchronized (this) {//hacer que sea thread safe
				
				try {// try para capturar errores
					
					while(estado == false) wait(); //mientras el estado sea false, esperamos al aviso del otro metodo ventilador
					System.err.print("Ventilador apagado!");
					System.out.println(" -> Ventilador apagado durante " + tiempoFuncionamiento / 1000 + " segundos");//print en segundos del tiempo
					Thread.sleep(tiempoFuncionamiento);//tiempo de espera que simula el tiempo que esta funcionando
					estado = false;// estado pasa a false por lo tanto pasa a modo espera
					notify();//notificamos al otro metodo que puede empezar
				}catch (InterruptedException e) {
					e.printStackTrace();// imprime errores capturados
				}
			}
		}
		
	}
}
