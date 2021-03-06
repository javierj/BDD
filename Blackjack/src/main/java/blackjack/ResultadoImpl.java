/**
 * 
 */
package blackjack;

import blackjack.participante.Jugador;

/**
 * @author Javier
 *
 */
public class ResultadoImpl implements Resultado {

	Boolean finDeMano;
	Jugador ganador;
	
	public ResultadoImpl(Jugador jug) {
		this.ganador = jug;
		this.finDeMano = true;
	}

	public ResultadoImpl() {
		this.finDeMano = false;
	}

	@Override
	public boolean esFinDeMano() {
		return finDeMano;
	}

	@Override
	public Jugador getGanador() {
		return this.ganador;
	}

	@Override
	public void setGanador(Jugador croupier) {
		this.ganador = croupier;
		
	}

}
