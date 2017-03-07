package blackjack;

import java.util.List;

public interface Jugador {

	void manoInicial(List<Carta> cartasIniciales);
	
	void recibe(Carta carta);
	
	public Integer valorDeMano();
	

}
