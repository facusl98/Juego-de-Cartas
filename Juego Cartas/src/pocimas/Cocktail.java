package pocimas;

import java.util.ArrayList;

import finalLibre.Atributo;

public class Cocktail extends Pocima {

	private ArrayList<Pocima> pocimas;
	public Cocktail(String nombre) {
		super(nombre);
		this.pocimas = new ArrayList<>();
	}

	public void agregarPocima(Pocima p) {
		pocimas.add(p);
	}
	
	
	public double aplicarPocima(Atributo a) {
		double resultadoParcial = a.getValor();
		String nombreParcial = a.getNombre();
		for(Pocima pp:pocimas) {
			resultadoParcial = pp.aplicarPocima(new Atributo(nombreParcial, resultadoParcial));
		}
		return resultadoParcial;
	
	}
	

}
