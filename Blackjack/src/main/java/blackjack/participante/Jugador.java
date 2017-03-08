package blackjack.participante;

import java.util.List;

import blackjack.Carta;

public interface Jugador {

	void manoInicial(List<Carta> cartasIniciales);
	
	void recibe(Carta carta);
	
	public Integer valorDeMano();
	

}
