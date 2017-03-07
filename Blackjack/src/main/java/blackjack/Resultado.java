package blackjack;

public interface Resultado {

	boolean esFinDeMano();

	Jugador getGanador();

	void setGanador(Croupier croupier);

}
