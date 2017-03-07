package acceptance;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue="gildedrose",
	    features="src/test/resources/features/",
	    plugin = {"json:target/cucumber.json", "junit:target/cucumber.xml"}
)
public class RunCukesTest {
}
