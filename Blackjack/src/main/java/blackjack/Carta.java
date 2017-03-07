package blackjack;

import java.util.*;

public class Carta {
	String nombre;
	Integer valor;
	
	static Map<String, Integer> valorPorNombre = new HashMap<>();
	static {
		valorPorNombre.put("As", 11);
		valorPorNombre.put("Jester", 10);
		valorPorNombre.put("Queen", 10);
		valorPorNombre.put("King", 10);
	}
	
	public Carta(String nombre) {
		this.nombre = nombre;
		Integer valor = valorPorNombre.get(nombre);
		if (valor == null) {
			this.valor = Integer.valueOf(this.nombre);
		} else {
			this.valor = valor;
		}
	}

	public Integer getValor() {
		return this.valor;
	}
}
