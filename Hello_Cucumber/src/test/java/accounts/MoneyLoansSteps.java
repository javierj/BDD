package accounts;

import java.util.List;

import cucumber.api.PendingException;
import cucumber.api.Transform;
import cucumber.api.java.en.*;
import static org.junit.Assert.*;

public class MoneyLoansSteps {

	Money currentMoney;
	Loan loan;

@Given("^I have \"([^\"]*)\" euros$")
public void i_have_euros(Money currentMoney) throws Throwable {
    this.currentMoney = currentMoney;
}

@When("^I loan \"([^\"]*)\" euros$")
public void i_loan_euros(
		@Transform(LoanTransformer.class) Loan loan
	) throws Throwable {
	this.loan = loan;
}

@Then("^I only have \"([^\"]*)\" euros$")
public void i_only_have_euros(String arg1) throws Throwable {
    // Write code here that turns the phrase above into concrete actions
    throw new PendingException();
}

@Given("^I have: ((?:\\d+|,)+) euros$")
public void i_have_euros(List<Integer> listOfEuros) throws Throwable {
	assertEquals(3, listOfEuros.size());	
}
	
}
