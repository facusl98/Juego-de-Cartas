package pocimas;

import finalLibre.Atributo;

public class PocimaFija extends Pocima{

	private double fijo;
	
	public PocimaFija(String nombre, double fijo) {
		super(nombre);
		this.fijo = fijo;
	}



	public double aplicarPocima(Atributo a) {
		return fijo;
	}
	
	
	
	
	
	
}
