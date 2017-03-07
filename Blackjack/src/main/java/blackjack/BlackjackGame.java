package blackjack;

public class BlackjackGame {

	Mesa mesa;
	Reglas reglas;
	Controlador controlador;
	Baraja baraja;
	
	public void setBaraja(Baraja baraja) {
		this.baraja = baraja;
	}
	
	public void setMesa(Mesa mesa) {
		this.mesa = mesa;
	}
	
	public void setReglas(Reglas reglas) {
		this.reglas = reglas;
	}
	
	public void setControlador(Controlador controlador) {
		this.controlador = controlador;
	}
	 
	public Resultado jugarMano() {
		mesa.repartirManosIniciales();
		controlador.manosIniciales(mesa);
		
		Resultado blackjack = reglas.comprobarBlackjack(mesa);
		if (blackjack.esFinDeMano()) {
			controlador.finDePartida(blackjack);
			controlador.ganador(blackjack.getGanador());
			return blackjack;
		}
		
		Boolean turnoJugador = true; 
		while(turnoJugador) {
			Accion accion = controlador.accionDe(mesa.getJugador());
			Resultado resultado = new ResultadoImpl();
			
			// Eso habría quee scribirlo de ora manera
			if (accion.pideCarta()) {
				//mesa.cartaParaJugador();
				System.out.println("Pide carta");
				mesa.getJugador().recibe(baraja.siguienteCarta());
				resultado = reglas.sePasa(mesa.getJugador());
				System.out.println("Fin de mano: " + resultado.esFinDeMano());
				if (resultado.esFinDeMano()) {
					resultado.setGanador(mesa.getCroupier());
					controlador.ganador(mesa.getCroupier());
					return resultado;
				}
			}
			/*
			if (reglas.accionValida(accion))
				accion.resuelveAccion(mesa);
			*/
			if (accion.esPlantarse() || resultado.esFinDeMano()) {
				turnoJugador = false;
			}
			
		}
		Jugador ganador = reglas.ganador(mesa);
		controlador.ganador(ganador);
		
		return null;
	}
	
}
