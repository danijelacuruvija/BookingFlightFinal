package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class VerifyFlight extends BasePage {
    WebDriver driver;

    public VerifyFlight(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "[data-testid='checkout_extras_inner_next']")
    WebElement nextToSeatSelectionButton;

    @FindBy(css = "[data-testid='checkout_extras_inner_next']")
    WebElement skipButton;

    @FindBy(css = "[data-testid='trip_summary_dates']")
    WebElement travelDates;

    public void selectBaggageAndExtras() throws InterruptedException {
        clickElement(nextToSeatSelectionButton);
    }

    public void skipSeatSelection() throws InterruptedException {
        clickElement(skipButton);
    }

    public void checkPayingCard(String cardName) throws InterruptedException {

        Assert.assertTrue( driver.findElement(By.xpath("//img[@title='" + cardName + "']")).isDisplayed());
        Thread.sleep(3000);


    }
}