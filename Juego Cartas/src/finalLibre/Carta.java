package finalLibre;

import java.util.ArrayList;
import java.util.Random;

import pocimas.Pocima;

public class Carta {

	private String nombre;
	private ArrayList<Atributo> atributos;
	private Pocima pocima;
	
	
	
	public Carta(String nombre) {
		this.nombre = nombre;
		this.atributos = new ArrayList<>();
		this.pocima = null;
	}
	
	

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public double getAtributoOriginal(String atributo) {
		double valor = 0;
		for(Atributo a:this.atributos)
			if(a.getNombre().equals(atributo))
				valor = a.getValor();
		return valor;
	}
	
	
	
	
	public double getAtributo(String atributo) {
		double valor = 0;
		for(Atributo a:this.atributos)
			if(a.getNombre().equals(atributo))
				if(this.pocima != null) {
					valor = this.pocima.aplicarPocima(a);
				}
					else
						valor = a.getValor();
		return valor;	
		
	}
	
	
	public ArrayList<Atributo> getAtributos(){
		return new ArrayList<>(atributos);
	}
	
	
	public boolean esCompatible(Carta c) {
		ArrayList<String> listaCarta1 = new ArrayList<>();
		for(Atributo a:c.getAtributos())
			listaCarta1.add(a.getNombre());
		
		ArrayList<String> listaCarta2 = new ArrayList<>();
		for(Atributo a: this.getAtributos())
			listaCarta2.add(a.getNombre());
		return listaCarta1.size() == listaCarta2.size() && listaCarta2.containsAll(listaCarta1);
		
	
	}
	
	
	public Atributo getMayor() {
		if(this.atributos.isEmpty()) {
			System.out.println("Error: no tiene atributos");
			return null;
		}
		Atributo atr = atributos.get(0);
		double valorMaximo = 0;
		for(Atributo aa:atributos) {
			double valorActual = aa.getValor();
            if (valorActual > valorMaximo) {
                valorMaximo = valorActual;
                atr = aa;
            }
		}
		return atr;
	}
	
	public Atributo getRandom() {
		if(this.atributos.isEmpty()) {
			System.out.println("Error: no tiene atributos");
			return null;
		}
        Random random = new Random();
        int indiceAleatorio = random.nextInt(atributos.size());
        return atributos.get(indiceAleatorio);
	}
	
	
	public void agregarAtributo(Atributo atr) {
		this.atributos.add(atr);
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public void setPocima(Pocima p) {
		this.pocima = p;
	}

	public Pocima getPocima() {
		return pocima;
	}


	
	
}
