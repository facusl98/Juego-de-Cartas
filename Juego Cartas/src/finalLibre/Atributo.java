package finalLibre;

public class Atributo {
	private String nombre;
	private double valor;
	
	public Atributo(String nombre, double valor) {
		this.nombre = nombre;
		this.valor = valor;
	}
	
	
	public double getValor() {
		return this.valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	
}
