package Estrategias;

import finalLibre.Atributo;
import finalLibre.Carta;

public class EstrategiaObstinado implements Estrategia {

	private Atributo valor;
	
	public EstrategiaObstinado(Atributo valor){
		this.valor = valor;
	}
	
	
	public Atributo seleccionarEstrategia(Carta c) {
		return valor;
	}

}
