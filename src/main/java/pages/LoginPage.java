package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private final WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	By emailField = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
	By passwordField = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
	By logoutButton = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
	By loginButton = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
	By HomePageIcon = By.xpath("//*[@id=\"slider-carousel\"]/div");
	By errorMessage = By.xpath("//*[@id=\"form\"]/div/div/div[1]/div[1]/form/p");

	public void enterEmail(String email) {
		driver.findElement(emailField).sendKeys(email);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}

	public void clickLogIn() {
		driver.findElement(loginButton).click();
	}

	public void clickLogOut() {
		driver.findElement(logoutButton).click();
	}

	public String getErrorMessage() {
		return driver.findElement(errorMessage).getText();
	}

	public boolean LoginPagegetErrorMessage() {
		return driver.findElement(passwordField).isDisplayed();
	}

	public void homePageIcon() {
		Assert.assertTrue(driver.findElement(HomePageIcon).isDisplayed());
	}

}
