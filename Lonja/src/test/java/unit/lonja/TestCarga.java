package lonja;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestCarga {

	@Test
	public void debeGuardarLosKilosYContenidoDeLaCarga() {
		Carga carga = new Carga(1, 2, 3);
		
		assertEquals(1, carga.getKilosVieiras());
		assertEquals(2, carga.getKilosCentollo());
		assertEquals(3, carga.getKilosPulpo());
	}

}
