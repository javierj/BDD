package blackjack;

import blackjack.participante.Jugador;

public interface Resultado {

	boolean esFinDeMano();

	Jugador getGanador();

	void setGanador(Jugador jugador);

}
