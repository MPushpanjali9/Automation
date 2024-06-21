package steps;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;
import tests.BaseTest;
import utils.Config;
import utils.ExcelReader;

public class SignInOut {
	
	private final WebDriver driver;
	LoginPage loginPage;
	HomePage homePage;
	List<String[]> testData;
	
	public SignInOut() {
		this.driver = BaseTest.getDriver();
	}
	
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		loginPage = new LoginPage(driver);
		homePage = new HomePage(driver);
		driver.get(Config.URL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@When("the user enters credentials from the excel file")
	public void the_user_enters_credentials_from_the_excel_file() {
		homePage.clickSignOut();
		ExcelReader excelReader = new ExcelReader(utils.Config.TEST_DATA_PATH);
        testData = excelReader.readExcelData();
        
        for (String[] credentials : testData) {
        	the_User_Enters_Email_And_Password(credentials[0], credentials[1]);
        	the_user_should_be_signed_in_successfully();
        	the_user_should_see_the_dashboard_page();
        	the_user_clicks_the_sign_out_button();
        	the_user_should_be_signed_out_successfully();
        	the_user_should_see_the_login_page();
        }
	}

	public void the_User_Enters_Email_And_Password(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
    }
	
	@Then("the user should be signed in successfully")
	public void the_user_should_be_signed_in_successfully() {
		loginPage.clickLogIn();
	}

	@Then("the user should see the dashboard page")
	public void the_user_should_see_the_dashboard_page() {
		homePage.getWelcomeMessage();
	}

	@When("the user clicks the sign-out button")
	public void the_user_clicks_the_sign_out_button() {
		homePage.getWelcomeMessage();
	}

	@Then("the user should be signed out successfully")
	public void the_user_should_be_signed_out_successfully() {
		homePage.clickSignOut();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Then("the user should see the login page")
	public void the_user_should_see_the_login_page() {
		Assert.assertTrue(driver.getTitle().contains("Login"));
	}
	
	@After
	public void tearDown() {
		BaseTest.quitDriver();
	}

}
