package org.pages;

import java.util.concurrent.TimeUnit;

import org.baseutility.BaseUtility;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.utility.privilege.GetSystemPropertyAction;

public class BursaMalaysiaHomePage extends BaseUtility {

	public BursaMalaysiaHomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[contains(text(),'Register')]")
	private WebElement register;

	@FindBy(xpath = "//input[@name='signup-username']")
	private WebElement displayName;

	@FindBy(xpath = "//input[@name='signup-email']")
	private WebElement emailAddress;

	@FindBy(xpath = "//input[@type='checkbox']")
	private WebElement checkBox;

	@FindBy(xpath = "//span[@id='recaptcha-anchor']//child::div[@class='recaptcha-checkbox-border']")
	private WebElement captchaBox;

	@FindBy(xpath = "//button[@type='submit' and text()='Register']")
	private WebElement registerComplete;

	@FindBy(xpath = "//input[@name='signup-password']")
	private WebElement password;

	public WebElement getRegister() {
		return register;
	}

	public WebElement getDisplayName() {
		return displayName;
	}

	public WebElement getEmailAddress() {
		return emailAddress;
	}

	public WebElement getCheckBox() {
		return checkBox;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getCaptchaBox() {
		return captchaBox;
	}

	public WebElement getRegisterComplete() {
		return registerComplete;
	}

	public void RegisterPage(String displayName, String emailAddress, String password) throws InterruptedException {
		getRegister().click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", getDisplayName());
		getDisplayName().sendKeys(displayName);
		getEmailAddress().sendKeys(emailAddress);
		getPassword().sendKeys(password);
		getCheckBox().click();
		Thread.sleep(5000);
		getRegisterComplete().click();
	}

}
