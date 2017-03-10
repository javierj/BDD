package lonja.servicios;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import lonja.servicios.DistanciaCiudades;

public class TestDistanciaCiudades {

	@Test
	public void debeSimularseConUnStubUsandoLasDistanciasDelEnunciado() {
		DistanciaCiudades stubDistancia = mock(DistanciaCiudades.class);
		when(stubDistancia.hasta("Madrid")).thenReturn(800);
		
		
		assertEquals(800, stubDistancia.hasta("Madrid"));
	}

}
