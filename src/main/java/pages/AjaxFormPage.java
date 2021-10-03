package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.SeleniumDriver;

public class AjaxFormPage {
	
	private final By NAME_INPUT = By.id("title");
	private final By COMMENT_INPUT = By.id("description");
	private final By SUBMIT_BUTTON = By.id("btn-submit");
	private final By SUBMIT_MSG = By.id("submit-control");
	
	public void typeInNameInput(String name) {
		SeleniumDriver.getDriver().findElement(NAME_INPUT).sendKeys(name);
	}
	
	public void typeInCommentInput(String comment) {
		SeleniumDriver.getDriver().findElement(COMMENT_INPUT).sendKeys(comment);
	}
	
	public void clickOnSubmitButton() {
		SeleniumDriver.getDriver().findElement(SUBMIT_BUTTON).click();
	}
	
	public String getSubmitMeassge() {
		WebDriverWait wait = new WebDriverWait(SeleniumDriver.getDriver(),10);
		wait.until(ExpectedConditions.textToBe(SUBMIT_MSG, "Form submited Successfully!"));
		return SeleniumDriver.getDriver().findElement(SUBMIT_MSG).getText();
	}
	
	public boolean getBorderColorOfNameInput() {
		String style = SeleniumDriver.getDriver().findElement(NAME_INPUT).getAttribute("style");
		if(style.contains("border: 1px solid rgb(255, 0, 0);")) {
			return true;
		}
		return false;
	}
	
	public boolean isSubmitButtonPresent() {
		List<WebElement> submitButton = SeleniumDriver.getDriver().findElements(SUBMIT_BUTTON);
		if(submitButton.size() > 0) {
			return true;
		}else {
			return false;
		}
		
	}

}
