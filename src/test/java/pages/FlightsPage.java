package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.By;

import java.util.Map;

public class FlightsPage extends BasePage {
    WebDriver driver;

    public FlightsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-decider-header='flights']")
    WebElement flights;

    public void openFlightsPage() throws InterruptedException {
        clickElement(flights);

    }
}
