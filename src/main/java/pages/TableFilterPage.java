package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumDriver;

public class TableFilterPage {
	
	private final By GREEN_BUTTON = By.xpath("//button[contains(@class, 'btn-success')]");
	private final By ORANGE_BUTTON = By.xpath("//button[contains(@class, 'btn-warning')]");
	private final By RED_BUTTON = By.xpath("//button[contains(@class, 'btn-danger')]");
	private final By ALL_BUTTON = By.xpath("//button[contains(@class, 'btn-default')]");
	private final By FIRST_TABLE_ROW = By.xpath("//tbody/tr[1]");
	private final By RECORDS_COLOR_SPANS = By.xpath("//tbody//h4/span");
	WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(), 5);
	
	public void clickOnFilterButton(String button) {
		switch(button) {
			case "Green":
				clickOnGreenButton();
				break;
			case "Orange":
				clickOnOrangeButton();
				break;
			case "Red":
				clickOnRedButton();
				break;
			default:
				clickOnAllButton();
				break;
		}
	}
	
	public void clickOnGreenButton() {
		SeleniumDriver.getDriver().findElement(GREEN_BUTTON).click();
	}
	
	public void clickOnOrangeButton() {
		SeleniumDriver.getDriver().findElement(ORANGE_BUTTON).click();
	}
	
	public void clickOnRedButton() {
		SeleniumDriver.getDriver().findElement(RED_BUTTON).click();
	}
	
	public void clickOnAllButton() {
		SeleniumDriver.getDriver().findElement(ALL_BUTTON).click();
	}
	
	public boolean isTableFiltered(String color) {
		wait.until(ExpectedConditions.attributeToBe(FIRST_TABLE_ROW, "sytle", ""));
		List<WebElement> spans = SeleniumDriver.getDriver().findElements(RECORDS_COLOR_SPANS);
		for(WebElement span: spans) {
			if(span.isDisplayed()) {
				if(!span.getText().contains(color)) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean areAllRecordsVisible() {
		List<WebElement> spans = SeleniumDriver.getDriver().findElements(RECORDS_COLOR_SPANS);
		try {
			wait.until(ExpectedConditions.visibilityOfAllElements(spans));
		}catch(Exception e) {
			return false;
		}
		return true;
	}

}
