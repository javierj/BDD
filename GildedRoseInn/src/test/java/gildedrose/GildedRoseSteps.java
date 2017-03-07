package gildedrose;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import gildedroseinn.*;


import static org.junit.Assert.*;

import java.util.Arrays;

public class GildedRoseSteps {

	Item item;
	
	@Given("^\"([^\"]*)\" con una calidad de (\\d+)$")
	public void con_una_calidad_de(String arg1, int arg2) throws Throwable {
	    item = new Item(arg1, -1, arg2);
	    
	}

	@Given("^una fecha de venta de (\\d+) dias$")
	public void una_fecha_de_venta_de_dias(int arg1) throws Throwable {
	    this.item.setSellIn(arg1);
	}

	@Given("^una fecha de venta de (\\d+) dias$")
	public void una_fecha_de_venta_de_dias_2(int arg1) throws Throwable {
	    this.item.setSellIn(arg1);

}

	@Given("^cualquier item con calidad (\\d+)$")
	public void cualquier_item_con_calidad(int arg1) throws Throwable {
		item = new Item("Normal_Item", -1, arg1);
	}

	
	@When("^transcurre un dia$")
	public void transcurre_un_dia() throws Throwable {
	    GildedRose inn = new GildedRose(new Item[]{this.item} );
	    inn.updateQuality();
	}

	@Then("^La calidad es de (\\d+)$")
	public void la_calidad_es_de(int arg1) throws Throwable {
	    assertEquals(arg1, this.item.getQuality());
	}

	@Then("^la fecha de ventas es de (\\d+) dias$")
	public void la_fecha_de_ventas_es_de_dias(int arg1) throws Throwable {
		assertEquals(arg1, this.item.getSellIn());
	}

	@Then("^La calidad sigue siendo (\\d+)$")
	public void la_calidad_sigue_siendo(int arg1) throws Throwable {
	    this.la_calidad_es_de(arg1);
	}

	
}
