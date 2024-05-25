package finalLibre;

import java.util.ArrayList;

import pocimas.Pocima;

public class Mazo {
	
	private String nombre;
	private ArrayList<Carta> cartas;
	
	
	public Mazo(String nombre) {
		this.nombre = nombre;
		this.cartas = new ArrayList<>();
	}
	
	
	
	public void removerCarta(Carta c) {
		cartas.remove(c);	
	}
	
	
	public boolean estaVacio() {
		return this.cartas.isEmpty();
	}
	
	public Carta getPrimerCarta() {
		Carta aux = this.cartas.get(0);
		return aux;
	}
	
	
	public void agregarCarta(Carta c) {
		if(cartas.isEmpty())
			cartas.add(c);
		else {
			if (c.esCompatible(this.cartas.get(0)))
				cartas.add(c);
			else
				System.out.println("la carta " + c.getNombre() + " no es compatible");
		
		}
	}
	
	/*//este metodo verificaba si el mazo era compatible
	  //Ahora se verifica al agregar una carta al mazo
	public boolean verificarMazo() {
		if(!cartas.isEmpty()) {
			Carta aux = cartas.get(0);
			Map<String, Double> atr = new HashMap<>();
			for(Carta car:cartas) { 
				if(car.getCantAtributos() != aux.getCantAtributos() ) 
					return false;
				atr = car.getAtributos();
				for(String a:atr.keySet())
					if(!aux.getAtributos().containsKey(a))
						return false;
			}		
			return true;
		}
		else
			return false;
	}
	*/
	
	
	public String getNombre() {
		return this.nombre;
	}
	
	
	public int getCantCartas() {
		return cartas.size();
	}
	
	
	
	public ArrayList<Carta> getCartas(){
		return new ArrayList<>(cartas);
	}

	
	
	
	
	public void agregarPocimas(ArrayList<Pocima> copiaPocimas) {
		if(copiaPocimas.size() <= cartas.size())
			for (int i = 0; i < copiaPocimas.size(); i++) {
	            Carta cartaActual = cartas.get(i);
	            Pocima pocimaActual = copiaPocimas.get(i);
	            cartaActual.setPocima(pocimaActual);
			}
		else
			System.out.println("Error: La cantidad de pocimas es mayor que la cantidad de cartas.");
	}
	
	
	
	
	
}
