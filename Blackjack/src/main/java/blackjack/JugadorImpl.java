package blackjack;


import java.util.*;

public class JugadorImpl implements Jugador {

	List<Carta> mano = new ArrayList<>(5);
	
	@Override
	public void manoInicial(List<Carta> cartasIniciales) {
		System.out.println("No");
		this.mano.addAll(cartasIniciales);
	}

	@Override
	public void recibe(Carta carta) {
		this.mano.add(carta);
	}
	
	// Esto debería ir en una clase mano
	//
	public Integer valorDeMano() {
		Integer valor = 0;
		
		// Cambiar esto por un stream
		for(Carta c: this.mano) {
			valor += c.getValor();
		}
		
		return valor;
	}

}
