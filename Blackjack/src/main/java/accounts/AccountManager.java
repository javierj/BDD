package accounts;

import java.util.*;

public class AccountManager {

	Map<String, Map<String, Integer>> accountsForUsers;
	
	
	
	public AccountManager() {
		this.accountsForUsers = new HashMap<>();
	}
	
	public void createAccount(String user, String id, Integer amount) {
		Map<String, Integer> accountsBalance = this.accountsForUsers.get(user);
		
		if (accountsBalance == null) {
			accountsBalance = new HashMap<String, Integer>();
			this.accountsForUsers.put(user, accountsBalance);
		}
		
		accountsBalance.put(id,  amount);
	 }
	
	public void transfer(String user, String id_source, String id_target, Integer amount) {
		Map<String, Integer> accountsBalance = this.accountsForUsers.get(user);
		accountsBalance.put(id_source, accountsBalance.get(id_source) - amount );
		accountsBalance.put(id_target, accountsBalance.get(id_target) + amount );
	}
	
	public Integer getValance(String user, String id) {
		return this.accountsForUsers.get(user).get(id);
	}
	 
}
