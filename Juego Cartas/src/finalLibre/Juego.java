package finalLibre;

import java.util.ArrayList;
import java.util.Collections;

import Estrategias.EstrategiaAmbicioso;
import Estrategias.EstrategiaObstinado;
import Estrategias.EstrategiaTimbero;
import pocimas.Cocktail;
import pocimas.Pocima;
import pocimas.PocimaFija;
import pocimas.PocimaFortalecedora;
import pocimas.PocimaReductora;
import pocimas.PocimaSelectiva;

public class Juego {
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Mazo mazo;
	private int rondasMax;
	private ArrayList<Pocima> pocimas;
	
	public Juego(Jugador jugador1, Jugador jugador2, Mazo mazo, int rondasMax) {
		this.jugador1 = jugador1;
		this.jugador2 = jugador2;
		this.mazo = mazo;
		this.rondasMax = rondasMax;
		this.pocimas = new ArrayList<>();
	}
	
	public void jugar(){
		rondasMax += 1;
		int rondas = 1;
		this.repartirPocimas();
		this.repartir();
		Jugador jugadorGanador = jugador1;
		while(rondas< rondasMax && !jugador1.getMazo().estaVacio() && !jugador2.getMazo().estaVacio()) {
				Carta carta1 = jugador1.tirarCarta();
				Carta carta2 = jugador2.tirarCarta();
			 	Atributo atributoSeleccionado = jugadorGanador.elegirEstrategia(carta1);
				String atributo = atributoSeleccionado.getNombre(); 
				
				double valor1 = carta1.getAtributo(atributo);
				double valor2 = carta2.getAtributo(atributo);
				System.out.println("----------- Ronda"+ rondas +"------------");
				System.out.println("El jugador " + jugadorGanador.getNombre() + " selecciona competir por el atributo " + atributo );
				System.out.println("La carta de " + jugador1.getNombre() + " es " + carta1.getNombre() + " con " + atributo + " " + carta1.getAtributoOriginal(atributo));
				if(carta1.getPocima() != null) {
					System.out.println("se aplico la pocima " + carta1.getPocima().getNombre() + " valor resultante "+ valor1);
				}
				System.out.println("La carta de " + jugador2.getNombre() + " es " + carta2.getNombre() + " con " + atributo + " " + carta2.getAtributoOriginal(atributo));
				if(carta2.getPocima() != null) {
					System.out.println("se aplico la pocima " + carta2.getPocima().getNombre() + " valor resultante " + valor2);
				}
				if(valor1 == valor2) {
					jugador1.recibirCarta(carta1);
					jugador2.recibirCarta(carta2);
					System.out.println("Empatan la ronda");
				}
				else if(valor1 > valor2) {
					jugador1.recibirCarta(carta1);
					jugador1.recibirCarta(carta2);
					jugadorGanador = jugador1;
					System.out.println("Gana la ronda " + jugador1.getNombre());
				}
				else{
					jugador2.recibirCarta(carta1);
					jugador2.recibirCarta(carta2);
					jugadorGanador = jugador2;
					System.out.println("Gana la ronda " + jugador2.getNombre());
				}
				System.out.println(jugador1.getNombre() + " posee ahora " + jugador1.getCantCartas() + " cartas" + " y " + jugador2.getNombre() + " posee ahora " + jugador2.getCantCartas() + " cartas");
			
			
			if(jugador2.getMazo().estaVacio())
				System.out.println("Gano " + jugador1.getNombre());
			else if(jugador1.getMazo().estaVacio())
				System.out.println("Gano " + jugador2.getNombre());
			rondas++;
		}
		if(rondas >= rondasMax) {
			System.out.println("------------------------------------------");
			System.out.println("Cantidad maxima de rondas alcanzadas");
			if(jugador1.getCantCartas() == jugador2.getCantCartas())
				System.out.println("Empate");
			else if(jugador1.getCantCartas() > jugador2.getCantCartas())
				System.out.println("Gano el jugador " + jugador1.getNombre());
			else
				System.out.println("Gano el jugador " + jugador2.getNombre());
		}
	}
	
	
	
	
	public void repartirPocimas() {
		ArrayList<Pocima> copiaPocimas = new ArrayList<>(pocimas);
		if(!copiaPocimas.isEmpty()) {
			Collections.shuffle(copiaPocimas);
			this.mazo.agregarPocimas(copiaPocimas);
		}
	}
	
	
	public void agregarPocima(Pocima p){
		pocimas.add(p);
	}
	
	public void repartir() {
		ArrayList<Carta> aux = mazo.getCartas();
		for(int i = 0; i < aux.size(); i++) { 
				jugador1.recibirCarta(aux.get(i));
				mazo.removerCarta(aux.get(i));
				i++;	
			if(i < aux.size()) {
				jugador2.recibirCarta(aux.get(i));
				mazo.removerCarta(aux.get(i));
			}
		}
	}

	
	public int getCantCartas() {
		return mazo.getCantCartas();
	}
	
	
	public Mazo getMazo() {
		return this.mazo;
	}
	
	
	
	
	public static void main(String[] args) {
		
		//creo los atributos
		Atributo a1 = new Atributo("fuerza", 200);
		Atributo a2 = new Atributo("agilidad", 200);
		Atributo a3 = new Atributo("armadura", 200);
		Atributo a4 = new Atributo("resistencia", 200);
		
		Atributo a5 = new Atributo("fuerza", 100);
		Atributo a6 = new Atributo("agilidad", 100);
		Atributo a7 = new Atributo("armadura", 300);
		Atributo a8 = new Atributo("resistencia", 100);
		
		Atributo a9 = new Atributo("fuerza", 50);
		Atributo a10 = new Atributo("agilidad", 1000);
		Atributo a11 = new Atributo("armadura", 100);
		Atributo a12 = new Atributo("resistencia", 300);
		
		Atributo a13 = new Atributo("fuerza", 300);
		Atributo a14 = new Atributo("agilidad", 150);
		Atributo a15 = new Atributo("armadura", 300);
		Atributo a16 = new Atributo("resistencia", 300);
		
		//agrego los atributos de SuperMan
		Carta carta1 = new Carta("SuperMan");
		
		carta1.agregarAtributo(a1);
		carta1.agregarAtributo(a2);
		carta1.agregarAtributo(a3);
		carta1.agregarAtributo(a4);
		
		//agrego los atributos de Batman
		Carta carta2 = new Carta("Batman");
		carta2.agregarAtributo(a1);
		carta2.agregarAtributo(a6);
		carta2.agregarAtributo(a7);
		carta2.agregarAtributo(a16);
		
		//agrego los atributos de Linterna Verde
		Carta carta3 = new Carta("Linterna verde");
		carta3.agregarAtributo(a13);
		carta3.agregarAtributo(a10);
		carta3.agregarAtributo(a15);
		carta3.agregarAtributo(a8);
		
		//agrego los atributos de Flash
		Carta carta4 = new Carta("Flash");
		carta4.agregarAtributo(a1);
		carta4.agregarAtributo(a14);
		carta4.agregarAtributo(a11);
		carta4.agregarAtributo(a4);
		
		//agrego los atributos de Spider Man
		Carta carta5 = new Carta("Spider Man");
		carta5.agregarAtributo(a9);
		carta5.agregarAtributo(a6);
		carta5.agregarAtributo(a3);
		carta5.agregarAtributo(a4);
		
		//agrego los atributos de Thor
		Carta carta6 = new Carta("Thor");
		carta6.agregarAtributo(a1);
		carta6.agregarAtributo(a6);
		carta6.agregarAtributo(a3);
		carta6.agregarAtributo(a16);
		
		//agrego los atributos de Hulk
		Carta carta7 = new Carta("Hulk");
		carta7.agregarAtributo(a5);
		carta7.agregarAtributo(a10);
		carta7.agregarAtributo(a15);
		carta7.agregarAtributo(a4);
		
		//agrego los atributos de Wolverine
		Carta carta8 = new Carta("Wolverine");
		carta8.agregarAtributo(a1);
		carta8.agregarAtributo(a10);
		carta8.agregarAtributo(a15);
		carta8.agregarAtributo(a12);
		
		//agrego los atributos de iron Man
		Carta carta9 = new Carta("Iron Man");
		carta9.agregarAtributo(a13);
		carta9.agregarAtributo(a14);
		carta9.agregarAtributo(a3);
		carta9.agregarAtributo(a8);
		
		//agrego los atributos de Capitan América
		Carta carta10 = new Carta("Capitán América");
		carta10.agregarAtributo(a5);
		carta10.agregarAtributo(a2);
		carta10.agregarAtributo(a11);
		carta10.agregarAtributo(a4);
		
		
		//Agrego las cartas al mazo Supers
		Mazo mazo1 = new Mazo("Supers");
		mazo1.agregarCarta(carta1);
		mazo1.agregarCarta(carta2);
		mazo1.agregarCarta(carta3);
		mazo1.agregarCarta(carta4);
		mazo1.agregarCarta(carta5);
		mazo1.agregarCarta(carta6);
		mazo1.agregarCarta(carta7);
		mazo1.agregarCarta(carta8);
		mazo1.agregarCarta(carta9);
		mazo1.agregarCarta(carta10);
		
		
		//Creo las estrategias
		EstrategiaAmbicioso estratAmbi = new EstrategiaAmbicioso();
		//EstrategiaObstinado estratObsti = new EstrategiaObstinado("fuerza");
		EstrategiaTimbero estratTimb = new EstrategiaTimbero();
		
		
		//Creo los jugadores con las estrategias que van a usar
		Jugador jugador1 = new Jugador("Juan",estratTimb);
		Jugador jugador2 = new Jugador("Maria",estratAmbi);
		
		//Creo las pocimas
		PocimaFortalecedora p1 = new PocimaFortalecedora("Fortalecedora", 1.2);
		PocimaFortalecedora p2 = new PocimaFortalecedora("FortalecedoraPlus", 1.5);
		PocimaReductora p3 = new PocimaReductora("Kriptonita", 0.25);
		PocimaReductora p4 = new PocimaReductora("Reductor de Plomo", 0.5); 
		PocimaFija p5 = new PocimaFija("Quiero vale cuatro", 4);
		PocimaFija p6 = new PocimaFija("Numero Mágico", 4);
		PocimaSelectiva p7 = new PocimaSelectiva("Pócima Selectiva Fuerza", "fuerza", 1.35);
		PocimaSelectiva p8 = new PocimaSelectiva("Pócima Selectiva Peso", "fuerza", 1.43);
		Cocktail p9 = new Cocktail("Pócima Cocktail");
		Cocktail p10 = new Cocktail("Pócima Cocktail"); 
		
		
		//Agrego las pocimas a las pocimas Cocktail
		p9.agregarPocima(p1);
		p9.agregarPocima(p2);
		p9.agregarPocima(p3);
		
		
		p10.agregarPocima(p9);
		p10.agregarPocima(p3);
		p10.agregarPocima(p4);
		
		//Creo el juego y agrego las pocimas
		Juego juego1 = new Juego(jugador1, jugador2, mazo1, 15);
		juego1.agregarPocima(p1);
		juego1.agregarPocima(p2);
		juego1.agregarPocima(p3);
		juego1.agregarPocima(p4);
		juego1.agregarPocima(p5);
		juego1.agregarPocima(p6);
		juego1.agregarPocima(p7);
		juego1.agregarPocima(p8);
		juego1.agregarPocima(p9);
		juego1.agregarPocima(p10);
		
		
		juego1.jugar();
		
		
		
		
	}
	
	
	
}
