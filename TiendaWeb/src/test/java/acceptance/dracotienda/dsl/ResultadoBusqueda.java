package dracotienda.dsl;

import dracotienda.page.SearchResultPage;

public class ResultadoBusqueda {

	SearchResultPage page;
	
	public ResultadoBusqueda(SearchResultPage page) {
		this.page = page;
	}

	public boolean hasJuego(String juego, String precio_normal, String precio_reducido) {
		return this.page.containsString(juego) &&
				this.page.containsString(precio_normal) &&
				this.page.containsString(precio_reducido);
		
	}
	 
}
