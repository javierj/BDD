package holacucumber;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import static org.junit.Assert.*;

public class HolaCucumberStep {

	String nombre;
	String respuesta;
	
	@Given("^soy \"([^\"]*)\"$")
	public void soy(String nombre) throws Throwable {
		this.nombre = nombre;
	}

	@When("^saludo a Cucumber$")
	public void saludo_a_Cucumber() throws Throwable {
		MiCucumber cucumber = new MiCucumber();
		this.respuesta = cucumber.hola(this.nombre);
	}

	@Then("^Cucumber me responde \"([^\"]*)\"$")
	public void cucumber_me_responde(String respuesta_esperada) throws Throwable {
		assertEquals(this.respuesta, respuesta_esperada);
	}
	
	
	@Given("^La siguiente tabla$")
	public void la_siguiente_tabla(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		
	    throw new PendingException();
	}

	
}
