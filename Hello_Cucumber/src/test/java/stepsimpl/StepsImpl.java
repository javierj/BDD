package stepsimpl;

import cucumber.api.PendingException;
import cucumber.api.java.en.*;
import hello.MyCucumber;

import static org.junit.Assert.*;

public class StepsImpl {

	String name = "Unset";
	String result = "Unset";
	
	@Given("^a student called \"([^\"]*)\"$")
	public void a_student_called(String name) throws Throwable {
	   this.name = name;
	}

	@When("^Bob says hello to Cucumber$")
	public void bob_says_hello_to_Cucumber() throws Throwable {
		MyCucumber cucumber = new MyCucumber();
	    this.result = cucumber.hello(this.name);
	}

	@Then("^Cucumber answer \"([^\"]*)\"$")
	public void cucumber_answer(String msg) throws Throwable {
	   assertEquals(this.result, msg);
	}


	
}
