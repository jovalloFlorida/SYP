/**
 * Crea una clase llamada “MostrarASCII” que implemente Runnable y que tenga como atributo un número entero denominado “tipo”.
 *  Si el tipo es 1, la clase mostrará los caracteres ASCII impares y si es 2, los pares. La aplicación (método main) 
 *  deberá crear dos hilos, uno para mostrar los impares y otro para los pares.
 */
package es.florida.ET03;

	public class MostrarASCII implements Runnable{

		int tipo;
		MostrarASCII(int tipo){
			this.tipo=tipo;
		}
		
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			MostrarASCII objeto1 = new MostrarASCII(1);
			MostrarASCII objeto2 = new MostrarASCII(2);
			Thread thread1=new Thread(objeto1);
			Thread thread2=new Thread(objeto2);
			thread1.start();
			thread2.start();
		}

		@Override
		public void run() {
			// TODO Auto-generated method stub
			if (tipo==1) {
				for (int i=1;i<256;i+=2) {
					System.err.println("Caracter impar nº" + i + ": " + (char)i);
				}
			}else if (tipo==2) {
				for (int i=2;i<=256;i+=2) {
					System.out.println("Caracter par nº" + i + ": " + (char)i);
				}
			
		}
	}		
}
