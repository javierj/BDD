package fraccion;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestFracciones {

	
	@Test
	public void debeSumarFracciones() {
		Fraction fractionA = fraccion(1, 2);
		Fraction fractionB = fraccion(4, 3);
		Fraction expectedResult = fraccion(11, 6);
		
		Fraction res = fractionA.sum(fractionB);
		
		assertTrue(res.isSameFraction(expectedResult));
	}
	
	@Test
	public void debeSimplificarFracciones() {
		Fraction fractionA = fraccion(2, 2);
		Fraction fractionB = fraccion(4, 4);
		Fraction expectedResult = fraccion(1, 1);
		
		Fraction res = fractionA.sum(fractionB);
		
		assertTrue(res.isSameFraction(expectedResult));
	}




	


	
	

	
	
	
	@Test(expected = Fraction.WrongFractionException.class)
	public void testFractionWithZeroDen() {
		Fraction wrongFraction = new Fraction(3, 0);
	}
	
	
	private Fraction fraccion(int num, int den) {
		return new Fraction(num, den);
	}

}


