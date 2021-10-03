package steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AjaxFormPage;

public class AjaxFormSteps {
	
	private AjaxFormPage ajaxFormPage = new AjaxFormPage();

	@When("The user types in {string} in the Name input")
	public void the_user_types_in_in_the_name_input(String name) {
	    ajaxFormPage.typeInNameInput(name);
	}

	@When("The user types in {string} in the Comment input")
	public void the_user_types_in_in_the_comment_input(String comment) {
		ajaxFormPage.typeInCommentInput(comment);
	}

	@When("The user clicks on the Submit button")
	public void the_user_clicks_on_the_submit_button() {
	    ajaxFormPage.clickOnSubmitButton();
	}

	@Then("There should be a message {string}")
	public void there_should_be_a_message(String expected) {
	    String actual = ajaxFormPage.getSubmitMeassge();
	    assertEquals(actual, expected);
	}
	
	@Then("The Name input should have red border")
	public void the_name_input_should_have_red_border() {
	    assertTrue(ajaxFormPage.getBorderColorOfNameInput());
	}
	@Then("Submit button shouldnt disappear")
	public void submit_button_shouldnt_disappear() {
	    assertTrue(ajaxFormPage.isSubmitButtonPresent());
	}

}
