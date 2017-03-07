package dracotienda.page;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class MainPage extends Page {

	public void connect() throws FailingHttpStatusCodeException, MalformedURLException, IOException {		
		super.setUp();
		super.connect("http://www.dracotienda.com");
	}
	
	public ProductPage smashUpLindoPrimoroso() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		ProductPage pp = new ProductPage();
		pp.connect("http://www.dracotienda.com/smash-up-lindo-primoroso-p-17972.html");
		return pp;
	}

	public ShoppingPage pageCarrito() throws Exception {
		ShoppingPage shoppingPage = new ShoppingPage();
		shoppingPage.connect("http://www.dracotienda.com/shopping_cart.php");
		
		return shoppingPage;
	}

	public AdvancedSearchPage pageAdvancedSearch() throws Exception {
		AdvancedSearchPage page = new AdvancedSearchPage();
		page.connect("http://www.dracotienda.com/advanced_search.php");
		return page;
	}

}
