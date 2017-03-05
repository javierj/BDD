
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Por defecto Cucumber busca las features en el classpath as� que si no las tenemos ah� o
 * cambiamos el classpath o se lo indicamos expl�citamente con @CucumberOptions
 * @author Javier
 *
 * #  tags ={"@ra1, @ra2"}
 */
@RunWith(Cucumber.class)
@CucumberOptions(
	    features="features/",
	    plugin = "json:target/cucumber.json"
)
public class RunCukesTest {
}
