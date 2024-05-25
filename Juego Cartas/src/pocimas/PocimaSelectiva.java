package pocimas;



import finalLibre.Atributo;

public class PocimaSelectiva extends Pocima {

	private String selec;
	private double incremento;
	
	public PocimaSelectiva(String nombre, String selec, double incremento) {
		super(nombre);
		this.selec = selec;
		this.incremento = incremento;
	}



	public double aplicarPocima(Atributo a) {
		if(this.selec.equals(a.getNombre())) {
		return a.getValor() * incremento;
		}
		else 
			return a.getValor();
	}
	
}
