package dracotienda.page;

import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class SearchResultPage extends Page {
	
	public SearchResultPage(HtmlPage page) {
		super();
		this.page = page;
	}

	public boolean containsString(String string) {
		return this.page.asText().contains(string);
	}

}
