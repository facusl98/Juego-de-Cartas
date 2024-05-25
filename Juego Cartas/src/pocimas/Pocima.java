package pocimas;

import finalLibre.Atributo;

public abstract class Pocima {
	
	private String nombre;
	
	public abstract double aplicarPocima(Atributo a);

	public Pocima(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
		
}
