package dracotienda;

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
	
}
