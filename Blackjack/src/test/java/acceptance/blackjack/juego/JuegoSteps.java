package blackjack.juego;

import java.util.Arrays;

import org.mockito.ArgumentCaptor;

import blackjack.*;
import cucumber.api.PendingException;
import cucumber.api.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class JuegoSteps {

	Jugador jugador ;
	Jugador croupier;
	Jugador ganador;
	private Resultado resultado;
	
	@Before
	public void setUp() {
		//jugador = new JugadorImpl();
		//croupier = new JugadorImpl();

		jugador = mock(Jugador.class);
		croupier = mock(Croupier.class);
	}
	
	@Given("^El croupier tiene un \"([^\"]*)\" y una \"([^\"]*)\"$")
	public void el_croupier_tiene_un_y_un(String carta_1, String carta_2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	    
	    Carta c1 = new Carta(carta_1);
	    Carta c2 = new Carta(carta_2);
	    //croupier.manoInicial(Arrays.asList(c1, c2));
	    System.out.println(c1.getValor());
	    System.out.println(c2.getValor());
	    croupier = mock(Jugador.class);
	    assertNotNull(croupier);
	    Integer valor = c1.getValor() + c2.getValor();
	    System.out.println(valor);
	    when(croupier.valorDeMano()).thenReturn(valor);
	}
	
	@Given("^El jugador tiene un \"([^\"]*)\" y un \"([^\"]*)\"$")
	public void el_jugador_tiene_un_y_un(String carta_1, String carta_2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	    
	    Carta c1 = new Carta(carta_1);
	    Carta c2 = new Carta(carta_2);
	    //jugador.manoInicial(Arrays.asList(c1, c2));
	    when(jugador.valorDeMano()).thenReturn(c1.getValor() + c2.getValor());

	}
	
	
	@When("^El jugador recibe un \"([^\"]*)\"$")
	public void el_jugador_recibe_un(String carta) throws Throwable {
		/*
		BlackjackGame game = new BlackjackGame();
		Mesa mesa = mock(Mesa.class);
		when(mesa.jugadores()).thenReturn(Arrays.asList(jugador, croupier));

		Controlador controlador = mock(Controlador.class);

		jugador.recibe(new Carta(carta));
		
		game.setMesa(mesa);
		game.setReglas(new Reglas());
		game.setControlador(controlador);
		
		resultado = game.jugarMano();
		
		
		//controlador.ganador(ganador);
		ArgumentCaptor<Jugador> argument = ArgumentCaptor.forClass(Jugador.class);
		verify(controlador).ganador(argument.capture());
		this.ganador = argument.getValue();*/
		
		//jugador.recibe(new Carta(carta));
		Carta c = new Carta(carta);
		Integer valor = jugador.valorDeMano() + c.getValor();
		jugador = mock(Jugador.class);
	    when(jugador.valorDeMano()).thenReturn(valor);

	}
	
	@When("^La partida se resuelve$")
	public void la_partida_se_resuelve() throws Throwable {	
	
		BlackjackGame game = new BlackjackGame();
		Mesa mesa = mock(Mesa.class);
		when(mesa.jugadores()).thenReturn(Arrays.asList(jugador, croupier));
		
		Controlador controlador = mock(Controlador.class);
		
		game.setMesa(mesa);
		game.setReglas(new Reglas());
		game.setControlador(controlador);
		
		this.resultado = game.jugarMano();
		
		
		//controlador.ganador(ganador);
		ArgumentCaptor<Jugador> argument = ArgumentCaptor.forClass(Jugador.class);
		verify(controlador).ganador(argument.capture());
		this.ganador = argument.getValue();
	}
	
	@Then("^La partida termina$")
	public void la_partida_termina() throws Throwable {
		BlackjackGame game = new BlackjackGame();
		Mesa mesa = mock(Mesa.class);
		when(mesa.jugadores()).thenReturn(Arrays.asList(jugador, croupier));
		when(mesa.getJugador()).thenReturn(jugador);
			
		Controlador controlador = mock(Controlador.class);
		Accion accion = mock(Accion.class);
		when(accion.pideCarta()).thenReturn(true);
		when(controlador.accionDe(any())).thenReturn(accion);
		
		game.setMesa(mesa);
		game.setReglas(new Reglas());
		game.setControlador(controlador);
		
		this.resultado = game.jugarMano();
		
		
		//controlador.ganador(ganador);
		ArgumentCaptor<Jugador> argument = ArgumentCaptor.forClass(Jugador.class);
		verify(controlador).ganador(argument.capture());
		this.ganador = argument.getValue();
	
	}	
	
	@Then("^El jugador gana$")
	public void el_jugador_gana() throws Throwable {
		assertTrue(this.ganador == jugador);
		assertTrue(this.resultado.getGanador() == jugador);
	}
	
	

	@Then("^El jugador pierde$")
	public void el_jugador_pierde() throws Throwable {
		assertTrue(this.ganador == croupier);
		
		assertNotNull(this.resultado);
		assertTrue(this.resultado.getGanador() == this.croupier);
		}
}
