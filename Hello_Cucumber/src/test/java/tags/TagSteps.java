package tags;

import cucumber.api.java.en.*;

public class TagSteps {

@Then("^A scenario was executed$")
public void a_scenario_was_executed() throws Throwable {
    doNothing();
}

@Then("^B scenario was executed$")
public void b_scenario_was_executed() throws Throwable {
	doNothing();
}


private void doNothing() {
	// TODO Auto-generated method stub
	
}
}
