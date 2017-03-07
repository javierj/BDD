package dracotienda.page;

import java.io.IOException;

import java.net.MalformedURLException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.CookieManager;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class Page {

	static WebClient webClient;
	HtmlPage page;
	
	public void connect(String url) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		page = webClient.getPage(url);
	}
	
	public String asText() {
		return page.asText();
	}

	public void setUp() {
		webClient = new WebClient(BrowserVersion.FIREFOX_45);
	    CookieManager cookieManager = webClient.getCookieManager();
	    cookieManager.setCookiesEnabled(true);
	    webClient.getOptions().setJavaScriptEnabled(true); 
	}
	
}
