package dracotienda.page;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class AdvancedSearchPage extends Page {

	public SearchResultPage seacrhByPrice(String arg1, String arg2) throws IOException {
		// <form name="advanced_search"
		HtmlForm form = page.getFormByName("advanced_search");
		form.getInputByName("pfrom").setValueAttribute(arg1);
		form.getInputByName("pto").setValueAttribute(arg2);

		// <button id="tdb4" type="submit">Buscar
		HtmlButton button = page.getFirstByXPath("//button[@id='tdb4']");
		HtmlPage result = button.click();
  
		return new SearchResultPage(result);
        
	}

}
