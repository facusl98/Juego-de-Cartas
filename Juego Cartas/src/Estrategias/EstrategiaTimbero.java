package Estrategias;

import finalLibre.Atributo;
import finalLibre.Carta;

public class EstrategiaTimbero implements Estrategia {

	
	
	public Atributo seleccionarEstrategia(Carta c) {
		return c.getRandom();	
	}
}
