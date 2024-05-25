package finalLibre;

import Estrategias.Estrategia;

public class Jugador {

	private String nombre;
	private Mazo mazo;
	private Estrategia estrat;
	
	public Jugador(String nombre, Estrategia estrat){
		this.nombre = nombre;
		this.mazo = new Mazo("Mazo");
		this.estrat = estrat;
	}
	
	public Atributo elegirEstrategia(Carta c) {
		return estrat.seleccionarEstrategia(c);
	}
	
	public int getCantCartas() {
		return mazo.getCantCartas();
	}
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	public void recibirCarta(Carta c) {
		this.mazo.agregarCarta(c);
	}
	
	public Mazo getMazo() {
		Mazo aux = this.mazo;
		return aux;
	}
	
	
	
	public Carta tirarCarta(){
		if(!mazo.estaVacio()){
			Carta aux = mazo.getPrimerCarta();
			mazo.removerCarta(aux);
			return aux;
		}
		else
			return null;
	}

}
