package blackjack.juego;

import java.util.ArrayList;
import java.util.List;

import blackjack.Carta;
import blackjack.participante.Jugador;

public class JugadorMock implements Jugador {
	
	private List<Integer> valorManos;
	private int indice;

	public JugadorMock(List<Integer> valorManos) {
		this.valorManos = valorManos;
		this.indice = 0;
	}
	
	
	public JugadorMock() {
		this(new ArrayList<>(10));
	}


	@Override
	public void manoInicial(List<Carta> cartasIniciales) {
		// TODO Auto-generated method stub

	}

	@Override
	public void recibe(Carta carta) {
		// TODO Auto-generated method stub

	}

	@Override
	public Integer valorDeMano() {
		
		this.indice += 1;
		System.out.println("Llamada: " + this.indice);
		System.out.println("Valor : " + this.valorManos.get(this.indice));
		return this.valorManos.get(this.indice); 
	}


	public void addValor(Integer valor) {
	    if (this.valorManos.size() == 0) {
	    	this.valorManos.add(valor);
	    } else {
	    	this.valorManos.add(valor + this.valorManos.get(this.valorManos.size()-1));
	    }
		
	}


	public void addValor(Carta carta) {
		this.addValor(carta.getValor());
	}

}
