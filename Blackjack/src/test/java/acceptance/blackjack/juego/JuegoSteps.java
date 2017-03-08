package blackjack.juego;

import java.util.*;

import org.mockito.ArgumentCaptor;

import blackjack.*;
import blackjack.participante.Jugador;
import cucumber.api.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class JuegoSteps {

	JugadorMock jugador ;
	JugadorMock croupier;
	Jugador ganador;
	private Resultado resultado;
	
	
	@Before
	public void setUp() {
		jugador = new JugadorMock();
		croupier = new JugadorMock();
	}
	
	@Given("^El croupier tiene un \"([^\"]*)\" y una \"([^\"]*)\"$")
	public void el_croupier_tiene_un_y_un(String carta_1, String carta_2) throws Throwable {
	    Carta c1 = new Carta(carta_1);
	    Carta c2 = new Carta(carta_2);
	    //croupier.manoInicial(Arrays.asList(c1, c2));
	    //System.out.println(c1.getValor());
	    //System.out.println(c2.getValor());
	    //croupier = mock(Jugador.class);
	    //assertNotNull(croupier);
	    //Integer valor = c1.getValor() + c2.getValor();
	    //System.out.println(valor);
	    //when(croupier.valorDeMano()).thenReturn(valor);
	    
	    this.croupier.addValor(c1.getValor());
	    this.croupier.addValor(c2.getValor());
	    

	}
	
	@Given("^El jugador tiene un \"([^\"]*)\" y un \"([^\"]*)\"$")
	public void el_jugador_tiene_un_y_un(String carta_1, String carta_2) throws Throwable {
	    Carta c1 = new Carta(carta_1);
	    Carta c2 = new Carta(carta_2);
	    //jugador.manoInicial(Arrays.asList(c1, c2));
	    //when(jugador.valorDeMano()).thenReturn(c1.getValor() + c2.getValor());

	    //when(croupier.valorDeMano()).thenReturn(valor);
	    
	    this.jugador.addValor(c1.getValor());
	    this.jugador.addValor(c2.getValor());
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
		//Integer valor = jugador.valorDeMano() + c.getValor();
		//jugador = mock(Jugador.class);
	    //when(jugador.valorDeMano()).thenReturn(valor);
		this.jugador.addValor(c.getValor());
	    	
	}
	
	@When("^La partida se resuelve$")
	public void la_partida_se_resuelve() throws Throwable {	
	
		BlackjackGame game = new BlackjackGame();

		Controlador controlador = mock(Controlador.class);
		
		//game.setMesa(this.getMesaMock());
		game.setReglas(new Reglas());
		game.setControlador(controlador);
		
		this.resultado = game.jugarMano(this.getMesaMock());
		
		
		extractWinner(controlador);
	}
	
	@Then("^La partida termina$")
	public void la_partida_termina() throws Throwable {
		BlackjackGame game = new BlackjackGame();

			
		Controlador controlador = mock(Controlador.class);
		Accion accion = mock(Accion.class);
		when(accion.pideCarta()).thenReturn(true);
		when(controlador.accionDe(any())).thenReturn(accion);
		
		//game.setMesa(getMesaMock());
		game.setReglas(new Reglas());
		game.setControlador(controlador);
		game.setBaraja(mock(Baraja.class));
		
		this.resultado = game.jugarMano(this.getMesaMock());
		
		
		//controlador.ganador(ganador);
		extractWinner(controlador);
	
	}


	


	@Then("^El jugador gana$")
	public void el_jugador_gana() throws Throwable {
		assertTrue(this.ganador == jugador);
		assertTrue(this.resultado.getGanador() == jugador);
	}
	
	

	@Then("^El jugador pierde$")
	public void el_jugador_pierde() throws Throwable {
		//assertTrue(this.ganador == croupier);
		
		assertNotNull(this.resultado);
		assertTrue(this.resultado.getGanador() == this.croupier);
		}
	
	
	//--- Foto 02 ------------------------------------------------
	
	@Given("^El usuario tiene un \"([^\"]*)\" y un \"([^\"]*)\"$")
	public void el_usuario_tiene_un_y_un(String carta01, String carta02) throws Throwable {
	    this.jugador.addValor(new Carta(carta01));
	    this.jugador.addValor(new Carta(carta02));
	    
	    // Y el croupier
	    this.croupier.addValor(10);
	    this.croupier.addValor(7);

	}

	@When("^El jugador pide una carta y recibe un \"([^\"]*)\"$")
	public void el_jugador_pide_una_carta_y_recibe_un(String carta) throws Throwable {
		Carta c = new Carta(carta);
		this.jugador.addValor(c.getValor());
	}
	
	//--- Foro 03 -----------------------------------------------
	

@Given("^Cada jugador tiene (\\d+) cartas$")
public void cada_jugador_tiene_cartas(int arg1) throws Throwable {
    this.croupier.addValor(10);
    this.croupier.addValor(7);
}

@Given("^El jugador \"([^\"]*)\" obtiene las cartas \"([^\"]*)\" y \"([^\"]*)\"$")
public void el_jugador_obtiene_las_cartas_y(String arg1, String carta01, String carta02) throws Throwable {
    this.jugador.addValor(new Carta(carta01));
    this.jugador.addValor(new Carta(carta02));
    
}

@When("^se resuelve la partida$")
public void se_resuelve_la_partida() throws Throwable {
    this.la_partida_se_resuelve();
}

@Then("^el jugador \"([^\"]*)\" gana la partida$")
public void el_jugador_gana_la_partida(String arg1) throws Throwable {
   this.el_jugador_gana();
}

	
	private Mesa getMesaMock() {
		Mesa mesa = mock(Mesa.class);
		when(mesa.jugadores()).thenReturn(Arrays.asList(jugador, croupier));
		when(mesa.getJugador()).thenReturn(jugador);
		when(mesa.getCroupier()).thenReturn(croupier);
		return mesa;
	}
	
	private void extractWinner(Controlador controlador) {
		ArgumentCaptor<Jugador> argument = ArgumentCaptor.forClass(Jugador.class);
		verify(controlador).ganador(argument.capture());
		this.ganador = argument.getValue();
	}	
}
