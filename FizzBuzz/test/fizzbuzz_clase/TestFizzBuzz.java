package fizzbuzz_clase;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestFizzBuzz {

	@Test
	public void debeDevolverUnaSecuenciaDeNumeros() {
		assertThat(fizzbuzz(2), is(Arrays.asList("1", "2")));
	}

	@Test
	public void debeDevolver_Fizz_EnMultiplosDe_3() {
		assertEquals(fizzbuzz(3).get(2), "Fizz");
		assertEquals(fizzbuzz(6).get(5), "Fizz");

	}

	@Test
	public void debeDevolver_Buzz_EnMultiplosDe_5() {
		assertEquals(fizzbuzz(5).get(4), "Buzz");
	}

	@Test
	public void debeDevolver_FizzBuzz_EnMultiplosDe_15() {
		assertEquals(fizzbuzz(15).get(14), "FizzBuzz");
	}

	
	private List<String> fizzbuzz(int limite) {
		List<String> resultado = new ArrayList<String>();
		for (int i = 1; i <= limite; i++) {
			String valor = "";
			valor = convierte(i, "Fizz", 3, valor);
			valor = convierte(i, "Buzz", 5, valor);

			if (valor == "") {
				valor = String.valueOf(i);
			}
			resultado.add(valor);
			
		}
		return resultado;
	}

	private String convierte(int i, String cadena, int multiplo, String valor) {
		if ((i%multiplo) == 0) {
			return valor + cadena;
		}	
		return valor;
	}

}
