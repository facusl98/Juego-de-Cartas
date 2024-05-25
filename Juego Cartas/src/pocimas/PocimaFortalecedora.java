package pocimas;

import finalLibre.Atributo;

public class PocimaFortalecedora extends Pocima{

	private double incremento;
	
	

	
	
	public PocimaFortalecedora(String nombre, double incremento) {
		super(nombre);
		this.incremento = incremento;
	}



	public double aplicarPocima(Atributo a) {
		return a.getValor() * incremento;
	}
	
	
}