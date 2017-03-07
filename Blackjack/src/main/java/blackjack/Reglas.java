package blackjack;

/**
 * Esto debería ser una interface para 
 * @author Javier
 *

public interface Reglas {

	Jugador ganador(Mesa mesa);

	boolean noHayGanador(Mesa mesa);

	boolean accionValida(Accion accion);

} */


public class Reglas {

	public Jugador ganador(Mesa mesa) {
		return null;
	}

	boolean noHayGanador(Mesa mesa) {
		return false;
	}

	boolean accionValida(Accion accion) {
		return true;
	}

	public Resultado comprobarBlackjack(Mesa mesa) {
		for(Jugador jug: mesa.jugadores()) {
			if (jug.valorDeMano() == 21) {
				return new ResultadoImpl(jug);
			}
		}
		return new ResultadoImpl();
	}

	public Resultado sePasa(Jugador jugador) {
		Integer valor = jugador.valorDeMano();
		if (valor > 21) {
			System.out.println("Se pasa: "+  valor);
			return new ResultadoImpl(null);
		}
		return new ResultadoImpl();
	}

}
