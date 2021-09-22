//Ejercicio 5. Realiza un programa que lea dos números desde teclado en un bucle repetitivo. El bucle deberá finalizar cuando los números leídos sean iguales

package es.florida.ET01;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio5 {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		int num1=1;
		int num2=2;
		while (num1 != num2) {
			System.out.print("Introduce el primer numero para compararlos: ");
			String numero1 = br.readLine();
			num1 = Integer.parseInt(numero1);
		
			System.out.print("Introduce el segundo numero para compararlos: ");
			String numero2 = br.readLine();
			num2 = Integer.parseInt(numero2);
			if (num1==num2) {
				System.out.println("Los dos numeros son iguales");
			}
		}
		isr.close();
		br.close();
	}
}
