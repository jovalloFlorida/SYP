/**
 * Clase �Mina� con un atributo que sea �stock� y un m�todo constructor que inicialice el stock a un valor determinado 
 * pasado como par�metro al m�todo (por ejemplo, 10.000 oros).
 */

package es.florida.AE03;

public class Mina {

	int stock;
	
	public Mina(int cantidad) {
		this.stock = cantidad;
	}

	//Getter
	public int getStock() {
		return this.stock;
	}
	
	//Setter
	synchronized public void setStock(int cantidad) {
		this.stock=cantidad;
		notify();
	}
	
}
