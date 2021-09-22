//Ejercicio 

package es.florida.ET01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Plantilla {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);

		isr.close();
		br.close();
	}
}
