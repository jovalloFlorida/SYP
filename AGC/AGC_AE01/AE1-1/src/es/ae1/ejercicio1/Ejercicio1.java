package es.ae1.ejercicio1;

public class Ejercicio1 {

	public static void main(String[] args) {
		
		SayHello(); 
		
		App otraClase = new App(); 
		
		otraClase.SayHello2(); 

	}
	
	public static void SayHello() { 
		System.out.println("Hola Mundo");
	}

}


/* COMENTARIOS DEL EJERCICIO:
El enunciado no me debaja claro si ten�a que hacer el m�todo en una �nica 
clase o si ten�a que desarrollarlo en una clase a parte y llamarlo desde 
la clase principal. As� que lo he hecho de las dos maneras.
*/
