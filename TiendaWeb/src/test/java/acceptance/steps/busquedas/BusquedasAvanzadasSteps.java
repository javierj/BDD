package steps.busquedas;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import dracotienda.dsl.Dracotienda;
import dracotienda.dsl.ResultadoBusqueda;
import static org.junit.Assert.*;

public class BusquedasAvanzadasSteps {
	
	Dracotienda tienda;
	ResultadoBusqueda resultado;
	
	String juego;
	String precio_normal;
	String precio_reducido;
	
	@Before
	public void setUp() throws Exception {
		tienda = new Dracotienda();
		tienda.entrar();
	}

	@Given("^El juego \"([^\"]*)\" con precio normal \"([^\"]*)\" y precio reducido \"([^\"]*)\"$")
	public void el_juego_con_precio_normal_y_precio_reducido(String juego, String precio_normal, String precio_reducido) throws Throwable {
	    this.juego	= juego;
	    this.precio_normal = precio_normal;
	    this.precio_reducido = precio_reducido;
	}

	@When("^Hago una busqueda avanzada de juegos entre \"([^\"]*)\" y \"([^\"]*)\" euros$")
	public void hago_una_b_squeda_avanzada_de_juegos_entre_y_euros(String arg1, String arg2) throws Throwable {
		resultado = tienda.busquedaAvanzadaPorPrecio(arg1, arg2);
	}

	@Then("^El juego aparece en los resultados$")
	public void el_juego_aparece_en_los_resultados() throws Throwable {
	    Boolean res = resultado.hasJuego(juego, precio_normal, precio_reducido);
	    assertTrue(res);
	}
	
}
