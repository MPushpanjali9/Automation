package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	private final WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    
    By HomePageIcon = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]");
    By signOutButton = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");

    public boolean getWelcomeMessage() {
        return driver.findElement(HomePageIcon).isDisplayed();
    }

    public void clickSignOut() {
        driver.findElement(signOutButton).click();
    }
}
