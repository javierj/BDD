package fizzbuzz;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestFizzbuzz {

	@Test
	public void devuelveUnaSecuenciaDeNumeros() {
		List<String> expected = fizzbuzz(2);

		assertThat(Arrays.asList("1", "2"), is(expected)); 
	}

	@Test
	public void debeCambiar_MultiplosDe3_por_Fizz() {
		List<String> expected = fizzbuzz(6);

		// assertThat(Arrays.asList("1", "2", "Fizz"), is(expected)); 
		// Mal - assertThat(Arrays.asList("1", "2", "Fizz", "4", "5", "Fizz"), is(fizzbuzz(6)));
	
		assertEquals("Fizz", expected.get(2));
		assertEquals("Fizz", expected.get(5));
	}
	
	@Test
	public void debeCambiar_MultiplosDe5_por_BuzzFizz() {
		List<String> expected = fizzbuzz(5);

		// assertThat(Arrays.asList("1", "2", "Fizz"), is(expected)); 
		// Mal - assertThat(Arrays.asList("1", "2", "Fizz", "4", "5", "Fizz"), is(fizzbuzz(6)));
	
		assertEquals("Buzz", expected.get(4));
	}
	
	@Test
	public void debeCambiar_MultiplosDe5Y3_por_FizzBuzz() {
		List<String> expected = fizzbuzz(15);

		// assertThat(Arrays.asList("1", "2", "Fizz"), is(expected)); 
		// Mal - assertThat(Arrays.asList("1", "2", "Fizz", "4", "5", "Fizz"), is(fizzbuzz(6)));
	
		assertEquals("FizzBuzz", expected.get(14));
	}
	
	private List<String> fizzbuzz(int limite) {
		List<String> result = new ArrayList<>();
		for (int i = 1; i <= limite; i++ ) {
			añadirElemento(result, i);
		}
		return result;
	}

	private void añadirElemento(List<String> result, int i) {
		String valor = this.reglaFizz(i, "");
		valor = reglaBuzz(i, valor);
		valor = reglaNumero(i, valor);

		result.add(valor);
	}
	
	private String reglaFizz(int numero, String valor) {
		if ((numero % 3) == 0) {
			return valor + "Fizz";
		} 
		return valor;
	}

	private String reglaBuzz(int numero, String valor) {
		
			if ((numero % 5) == 0) {
				return valor + "Buzz";
			}
		
		return valor;
	}
	
	
	private String reglaNumero(int numero, String valor) {
		if (valor == "") {
			return String.valueOf(numero);
		}
		return valor;
	}
}
