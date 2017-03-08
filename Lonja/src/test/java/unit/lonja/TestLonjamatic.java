package lonja;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class TestLonjamatic {

	@Test
	public void debeCalcularElBeneficioFinalDeVentaDeUnaCarga() {
		Carga carga = new Carga(0, 2, 3);
		DistanciaCiudades stubDistancia = mock(DistanciaCiudades.class);
		when(stubDistancia.hasta("Madrid")).thenReturn(800);
		PreciosLonja stubPrecio = mock(PreciosLonja.class);
		when(stubPrecio.centolloEn("Madrid")).thenReturn(450);
		when(stubPrecio.pulpoEn("Madrid")).thenReturn(0);
		
		Lonjamatic lonja = new Lonjamatic(stubPrecio, stubDistancia);
		int beneficio = lonja.beneficiosDeVenta(carga, "Madrid");
		
		assertEquals(beneficioVentaCentollosYPuposEnMadrid(), beneficio);
		
	}

	private int beneficioVentaCentollosYPuposEnMadrid() {
		int ingresosCentollos = 450 * 2;
		int ingresosPulpo = 0 * 3;
		int costeTransporte = 800 * 2;
		int costeCarga = 5;
		
		return ingresosCentollos + ingresosPulpo - costeTransporte - costeCarga;
	}

}
