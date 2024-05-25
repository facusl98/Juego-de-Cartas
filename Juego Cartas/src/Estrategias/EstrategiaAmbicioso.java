package Estrategias;

import finalLibre.Atributo;
import finalLibre.Carta;

public class EstrategiaAmbicioso implements Estrategia {

	public Atributo seleccionarEstrategia(Carta c) {
		return c.getMayor();
	}

}
