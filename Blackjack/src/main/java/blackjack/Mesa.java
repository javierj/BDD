package blackjack;

import java.util.List;

public class Mesa {

	List<Jugador> jugador;
	Croupier croupier;
	Baraja baraja;
	
	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}
	
	public void addJugador(Jugador jugador) {
		this.jugador.add(jugador);
	}
	
	public void addCroupier(Croupier croupier) {
		this.jugador.add(croupier);
		this.croupier = croupier;
	}
	
	public void repartirManosIniciales() {
		for(Jugador jug: this.jugador) {
			jug.manoInicial(this.croupier.getManoInicial());
		}
	}
	
	public List<Jugador> jugadores() {
		return this.jugador;
	}


	// Son las reglas las que detemrinan un jugador
	public Jugador ganador() {
		return null;
	}

	public Jugador getJugador() {
		return this.jugador.get(0);
	}

	public void cartaParaJugador() {
		this.jugador.get(0).recibe(baraja.siguienteCarta());
		
	}

	public Croupier getCroupier() {
		return this.croupier;
	}

}
