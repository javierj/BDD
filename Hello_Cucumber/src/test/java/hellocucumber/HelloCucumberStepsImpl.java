package hellocucumber;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import hellocucumber.MyCucumber;

import static org.junit.Assert.*;

public class HelloCucumberStepsImpl {

	String name = "Unset";
	String result = "Unset";
	
	@Given("^A student called \"([^\"]*)\"$")
	public void a_student_called(String name) throws Throwable {
	   this.name = name;
	}

	@When("^Bob says hello to Cucumber$")
	public void bob_says_hello_to_Cucumber() throws Throwable {
		MyCucumber cucumber = new MyCucumber();
	    this.result = cucumber.hello(this.name);
	}

	@Then("^Cucumber answers \"([^\"]*)\"$")
	public void cucumber_answer(String msg) throws Throwable {
	   assertEquals(this.result, msg);
	}

	@When("^Bob asks Cucumber to introduce itself$")
	public void bob_asks_Cucumber_to_introduce_itself() throws Throwable {
		MyCucumber cucumber = new MyCucumber();
	    this.result = cucumber.introduceYourself(this.name);
	}

	@Then("^Cucumber answers$")
	public void cucumber_answers(String cucumberAnswer) throws Throwable {
		assertTrue(this.result.contains(this.name));
	}



	
}
