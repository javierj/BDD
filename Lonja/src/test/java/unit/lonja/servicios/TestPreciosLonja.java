package lonja.servicios;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import lonja.servicios.PreciosLonja;

public class TestPreciosLonja {

	@Test
	public void debeSimularseConUnStubUsandoLaTablaDelEnunciado() {
		PreciosLonja stubPrecio = mock(PreciosLonja.class);
		when(stubPrecio.centolloEn("Madrid")).thenReturn(450);
		
		
		assertEquals(450, stubPrecio.centolloEn("Madrid"));
	}

}
