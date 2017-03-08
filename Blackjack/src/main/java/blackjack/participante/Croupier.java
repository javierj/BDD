package blackjack.participante;

import java.util.List;

import blackjack.Carta;

public interface Croupier extends Jugador
{

	List<Carta> getManoInicial();

}
