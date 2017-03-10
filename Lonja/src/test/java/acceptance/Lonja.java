
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import lonja.Carga;
import lonja.servicios.*;
import lonja.Lonjamatic;


import static org.junit.Assert.*;

public class Lonja {


private int vieiras;
private DistanciaCiudades stubDistancia;
private PreciosLonja stubPrecio;
private int beneficio;

@Given("^una carga de (\\d+) kilos de vieiras$")
public void una_carga_de_kilos_de_vieiras(int vieiras) throws Throwable {
    this.vieiras = vieiras;
}

@Given("^un precio de (\\d+) euros por kilo de vieiras en \"([^\"]*)\"$")
public void un_precio_de_euros_por_kilo_de_vieiras_en(int precio, String ciudad) throws Throwable {
	this.stubPrecio = mock(PreciosLonja.class);
	when(stubPrecio.vieiraEn(ciudad)).thenReturn(precio);
}

@Given("^una distancia hasta \"([^\"]*)\" de (\\d+) Km$")
public void una_distancia_hasta_de_Km(String ciudad, int distancia) throws Throwable {
	this.stubDistancia = mock(DistanciaCiudades.class);
	when(stubDistancia.hasta(ciudad)).thenReturn(distancia);
}

@When("^vendo la carga en \"([^\"]*)\"$")
public void vendo_la_carga_en(String ciudad) throws Throwable {
	Carga carga = new Carga(this.vieiras, 0, 0);
    Lonjamatic lonja = new Lonjamatic(stubPrecio, stubDistancia);
	this.beneficio = lonja.beneficiosDeVenta(carga, ciudad);
}

@Then("^el beneficio es (\\-\\d+)$")
public void el_beneficio_es(int beneficioEsperado) throws Throwable {
    assertEquals(beneficioEsperado, this.beneficio);
}
	
}
