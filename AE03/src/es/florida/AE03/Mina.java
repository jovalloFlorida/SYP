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
