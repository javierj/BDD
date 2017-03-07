package blackjack;

public interface Resultado {

	boolean esFinDeMano();

	Jugador getGanador();

	void setGanador(Jugador jugador);

}
