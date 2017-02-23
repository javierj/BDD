package dracotienda;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class MainPage extends Page {

	public void connect() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		super.connect("http://http://www.dracotienda.com");
	}
	
	public ProductPage smashUpLindoPrimoroso() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		ProductPage pp = new ProductPage();
		pp.connect("http://www.dracotienda.com/smash-up-lindo-primoroso-p-17972.html");
		return pp;
	}

	
}
