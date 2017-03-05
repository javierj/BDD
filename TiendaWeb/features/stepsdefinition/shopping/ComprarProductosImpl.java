package stepsdefinition.shopping;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import dracotienda.MainPage;
import dracotienda.ProductPage;
import static org.junit.Assert.*;

public class ComprarProductosImpl {

	MainPage mainPage;
	ProductPage productPage;
	
	@Given("^la tienda Dracotienda$")
	public void la_tienda_Dracotienda() throws Throwable {
	    mainPage = new MainPage();
	}

	@Given("^mi carrito vacio$")
	public void mi_carrito_vac_o() throws Throwable {
	    mainPage.connect();
	}

	@Given("^el producto \"([^\"]*)\"$")
	public void el_producto(String productName) throws Throwable {
	    productPage = mainPage.smashUpLindoPrimoroso();
	    
	}

	@When("^compro el producto \"([^\"]*)\" a mi carrito$")
	public void compro_el_producto_a_mi_carrito(String arg1) throws Throwable {
		productPage.buy();
	}

	@Then("^mi carrito incluye (\\d+) copia[s|] de \"([^\"]*)\"$")
	public void mi_carrito_incluye_copias_de(int numCopias, String producto) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Then("^el total de mi carrito es \"([^\"]*)\" euros$")
	public void el_total_de_mi_carrito_es_euros(String totalCarrito) throws Throwable {
	    assertTrue(this.productPage.isTotalCarrito(totalCarrito));
	}

	@Given("^mi carrito con el producto \"([^\"]*)\"$")
	public void mi_carrito_con_el_producto(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}

	@Given("^un  total de (\\d+),(\\d+) euros$")
	public void un_total_de_euros(int arg1, int arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
	}



	
}
