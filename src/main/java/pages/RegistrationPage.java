package pages;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class RegistrationPage {

	private final WebDriver driver;
	
	public RegistrationPage(WebDriver  driver) {
		this.driver = driver;
	}
	
	public By SignupOrLoginLink = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	public By SignUpName = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
	public By SignUpEmailId = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
	public By SignUpButton = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
	public By Gender = By.xpath("//*[@id=\"id_gender2\"]");
	public By SignupPassword = By.xpath("//*[@id=\"password\"]");
	public By DOBDay = By.xpath("//*[@id=\"days\"]");
	public By DOBMonth = By.xpath("//*[@id=\"months\"]");
	public By DOBYear = By.xpath("//*[@id=\"years\"]");
	public By checkBox1 = By.xpath("//*[@id=\"newsletter\"]");
	public By checkBox2 = By.xpath("//*[@id=\"optin\"]");
	public By FirstName = By.xpath("//*[@id=\"first_name\"]");
	public By LastName = By.xpath("//*[@id=\"last_name\"]");
	public By Compay = By.xpath("//*[@id=\"company\"]");
	public By Address = By.xpath("//*[@id=\"address1\"]");
	public By Address2 = By.xpath("//*[@id=\"address2\"]");
	public By Country = By.xpath("//*[@id=\"country\"]");
	public By State = By.xpath("//*[@id=\"state\"]");
	public By City = By.xpath("//*[@id=\"city\"]");
	public By Zipcode = By.xpath("//*[@id=\"zipcode\"]");
	public By MobileNum = By.xpath("//*[@id=\"mobile_number\"]");
	public By CreateButton = By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");
	
	//account_created
	
	public By AccountCreatedMesg = By.xpath("//*[@id=\"form\"]/div/div/div/h2");
	public By AccountCreatedMesg1 = By.xpath("//*[@id=\"form\"]/div/div/div/p[1]");
	public By AccountCreatedMesg2 = By.xpath("//*[@id=\"form\"]/div/div/div/p[2]");
	public By ContinueButton = By.xpath("//*[@id=\"form\"]/div/div/div/div/a" );
	public By DeleteAccount = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
	public By Logout = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
	public By ErrorMessage = By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/p");
	
	

	public void clickSignupOrLoginLink() {
		driver.findElement(SignupOrLoginLink).click();
	}
	
	public void EnterNewUserDeatils(String name, String email) {
		driver.findElement(SignUpName).sendKeys(name);
		driver.findElement(SignUpEmailId).sendKeys(email);
		driver.findElement(SignUpButton).click();
		driver.findElement(SignupPassword).sendKeys("Happy@123");
		driver.findElement(Gender).click();
	}
	
	public void SetDOB(String dob) {
		String date[] = dob.split("/");
		System.out.println(date[1]);
	
		Select dropdown1 = new Select(driver.findElement(DOBDay));
		dropdown1.selectByVisibleText(date[0]);
		
		Select dropdown2 = new Select(driver.findElement(DOBMonth));
		dropdown2.selectByValue(date[1]);
		
		Select dropdown3 = new Select(driver.findElement(DOBYear));
		dropdown3.selectByVisibleText(date[2]);
		
		driver.findElement(checkBox1).click();
		driver.findElement(checkBox2).click();
	}
	
	public void AddressInformtion() {
		
//		driver.findElement(FirstName).sendKeys("Gollapalli");
//		driver.findElement(LastName).sendKeys("Pushpanjali");
//		driver.findElement(Compay).sendKeys("");
//		driver.findElement(Address).sendKeys("EPams Systems");
//		driver.findElement(Address2).sendKeys("");
//		Select dropdown = new Select(driver.findElement(Country));
//		dropdown.selectByValue("India");
//		driver.findElement(State).sendKeys("Telenagana");
//		driver.findElement(City).sendKeys("Hyderabad");
//		driver.findElement(Zipcode).sendKeys("500020");
//		driver.findElement(MobileNum).sendKeys("9898987867");
		
		driver.findElement(CreateButton).click();
	}
}
