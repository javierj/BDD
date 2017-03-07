package dracotienda.dsl;

import dracotienda.page.AdvancedSearchPage;
import dracotienda.page.MainPage;
import dracotienda.page.ProductPage;
import dracotienda.page.SearchResultPage;
import dracotienda.page.ShoppingPage;

public class Dracotienda {

	MainPage mainPage;
	
	public void entrar() throws Exception {
		mainPage = new MainPage();
		mainPage.connect();
	}
	
	public void comprar(String productName) throws Exception {
		ProductPage productPage = mainPage.smashUpLindoPrimoroso();
		productPage.buy();
	}

	public Boolean isTotalCarrito(String total) throws Exception {
		ShoppingPage shoppingPage = this.mainPage.pageCarrito();
		return shoppingPage.containsSubtotal(total);
	}

	public ResultadoBusqueda busquedaAvanzadaPorPrecio(String arg1, String arg2) throws Exception {
		AdvancedSearchPage as = mainPage.pageAdvancedSearch();
		SearchResultPage resultPage = as.seacrhByPrice(arg1, arg2);
		return new ResultadoBusqueda(resultPage);
		
	}
	
}
