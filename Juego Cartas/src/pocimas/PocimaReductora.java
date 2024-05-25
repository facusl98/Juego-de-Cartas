package pocimas;

import finalLibre.Atributo;

public class PocimaReductora extends Pocima{

	private double reduc;
	
	
	public PocimaReductora(String nombre, double reduc) {
		super(nombre);
		this.reduc = reduc;
	}



	public double aplicarPocima(Atributo a) {
		return a.getValor() * reduc;
	}
	
	
	
}
