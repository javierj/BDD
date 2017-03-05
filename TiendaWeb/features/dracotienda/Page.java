package dracotienda;

import java.io.IOException;
import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Page {

	WebClient webClient;
	HtmlPage page;
	
	public void connect(String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		webClient = new WebClient();
		page = webClient.getPage(url);
	}
	
}
