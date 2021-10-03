package steps;

import static org.testng.Assert.assertTrue;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.TableFilterPage;

public class TableFilterSteps {
	
	private TableFilterPage tableFilterPage = new TableFilterPage();
	
	@When("The user clicks on the {string} filter button")
	public void the_user_clicks_on_the_filter_button(String button) {
	    tableFilterPage.clickOnFilterButton(button);
	}
	@Then("There should be only {string} type of records in the table")
	public void there_should_be_only_type_of_records_in_the_table(String color) {
	    assertTrue(tableFilterPage.isTableFiltered(color));
	}
	@When("The user clicks on the All filter button")
	public void the_user_clicks_on_the_all_filter_button() {
		tableFilterPage.clickOnFilterButton("default");
	}
	@Then("There should be all types of records in the table")
	public void there_should_be_all_types_of_records_in_the_table() {
	    assertTrue(tableFilterPage.areAllRecordsVisible());
	}
}
