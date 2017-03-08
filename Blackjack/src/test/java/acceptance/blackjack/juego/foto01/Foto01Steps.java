package blackjack.juego.foto01;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import blackjack.BlackjackGame;
import blackjack.Controlador;
import blackjack.Mesa;
import blackjack.Reglas;
import blackjack.Resultado;
import blackjack.juego.JugadorMock;
import blackjack.participante.Jugador;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;

public class Foto01Steps {
	
	JugadorMock jugador ;
	JugadorMock croupier;
	Jugador ganador;
	private Resultado resultado;
	
	
	@Before
	public void setUp() {
		jugador = new JugadorMock();
		croupier = new JugadorMock();
	}
	
	@Given("^Tengo (\\d+) cartas iniciales con (\\d+) puntos$")
	public void tengo_cartas_iniciales_con_puntos(int sin_usar, int puntos) throws Throwable {
		this.jugador.addValor(0);
		this.jugador.addValor(puntos);
	}

	@Given("^El croupier saca (\\d+) puntos$")
	public void el_croupier_saca_puntos(Integer puntos) throws Throwable {
		this.croupier.addValor(0);
		this.croupier.addValor(puntos);
	}

	@When("^Se resuelve la partida$")
	public void se_resuelve_la_partida() throws Throwable {
		BlackjackGame game = new BlackjackGame();

		Controlador controlador = mock(Controlador.class);
		
		//game.setMesa(this.getMesaMock());
		game.setReglas(new Reglas());
		game.setControlador(controlador);
		
		this.resultado = game.jugarMano(this.getMesaMock());
	}

	@Then("^Gano partida$")
	public void gano_partida() throws Throwable {
		assertTrue(this.resultado.getGanador() == jugador);
	}

	@Then("^Me llevo (\\d+) a (\\d+)$")
	public void me_llevo_a(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
	
	
	private Mesa getMesaMock() {
		Mesa mesa = mock(Mesa.class);
		when(mesa.jugadores()).thenReturn(Arrays.asList(jugador, croupier));
		when(mesa.getJugador()).thenReturn(jugador);
		when(mesa.getCroupier()).thenReturn(croupier);
		return mesa;
	}
}
