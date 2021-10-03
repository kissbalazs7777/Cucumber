package steps;

import io.cucumber.java.en.Given;
import utils.SeleniumDriver;

public class CommonSteps {
	@Given("The user is at {string}")
	public void the_user_is_at(String url) {
	    SeleniumDriver.getDriver().get(url);
	}
}
