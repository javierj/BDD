package accounts;

import java.util.*;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.*;

import static org.junit.Assert.*;


public class AccountsStepsImpl {

	AccountManager accounts;
	
	@Given("^the accounts of Bob$")
	public void the_acocunts_of_bob(DataTable table) throws Throwable {
		this.accounts = new AccountManager();
		
		for (Map<String, String> map : table.asMaps(String.class, String.class)) {
	        String id = map.get("Id");
	        Integer amount = Integer.valueOf(map.get("Amount"));
	        this.accounts.createAccount("Bob", id, amount);
	        //System.out.println("Acount "+id + " with balance "+ amount );
	    }
	}

	@When("^Bob transfers (\\d+) from account \"([^\"]*)\" to account \"([^\"]*)\"$")
	public void bob_transfers_from_account_to_account( int amount, String source, String target) throws Throwable {
		//System.out.println("Source "+source + " Target "+ target );
		this.accounts.transfer("Bob", source, target, amount);
	}

	@Then("^The balance of his accounts are$")
	public void the_balance_of_accounnts_are(DataTable table) throws Throwable {
		for (Map<String, String> map : table.asMaps(String.class, String.class)) {
	        String id = map.get("Id");
	        Integer amount = Integer.valueOf(map.get("Amount"));
	        assertEquals(this.accounts.getValance("Bob", id), amount);
		}
		
	}


}
