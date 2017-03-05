package steps.shopping;

import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import dracotienda.Dracotienda;

import static org.junit.Assert.*;

public class CarritoSteps {

	Dracotienda tienda;
	
	@Before
	public void setUp() {
		tienda = new Dracotienda();
	}
	
	@Given("^la tienda Dracotienda$")
	public void la_tienda_Dracotienda() throws Throwable {
		tienda.entrar();
	}

	@Given("^mi carrito vacio$")
	public void mi_carrito_vac_o() {
	}

	@When("^pongo el producto \"([^\"]*)\" a mi carrito$")
	public void compro_el_producto_a_mi_carrito(String productName) throws Throwable {
		tienda.comprar(productName);
	}

	@Then("^mi carrito incluye (\\d+) copias de \"([^\"]*)\"$")
	public void mi_carrito_incluye_copias_de(int numCopias, String producto) throws Throwable {
	    //throw new PendingException();
	}

	@Then("^el total de mi carrito es \"([^\"]*)\" euros$")
	public void el_total_de_mi_carrito_es_euros(String totalCarrito) throws Throwable {
		assertTrue(tienda.isTotalCarrito(totalCarrito));
	}

	
	
	/**
	 * Este método no se llama nunca, solo sirve para
	 * ver de manera más sencilla la interacción del 
	 * escenario con la tienda.
	 * @throws Exception
	 */
	private void pasos() throws Exception {
		String totalCarrito = null;
		String productName = null;
		
		tienda.entrar();
		tienda.comprar(productName);
		tienda.isTotalCarrito(totalCarrito);
	}
	
}
