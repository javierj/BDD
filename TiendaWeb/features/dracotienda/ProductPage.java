package dracotienda;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.html.*;

public class ProductPage extends Page {

	public void buy() throws IOException {
        final HtmlForm form = page.getFormByName("cart_quantity");

        final HtmlSubmitInput button = form.getInputByName("tdb4");
        
        this.page = button.click();
		
	}

	public Boolean isTotalCarrito(String total) {
		return this.page.asText().contains(total+"EUR");
	}

	
}
