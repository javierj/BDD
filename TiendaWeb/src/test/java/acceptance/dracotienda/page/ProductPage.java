package dracotienda.page;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.html.*;

public class ProductPage extends Page {

	public void buy() throws IOException {
        HtmlButton button = page.getFirstByXPath("//button[@id='tdb4']");
        button.click();
	}
}
