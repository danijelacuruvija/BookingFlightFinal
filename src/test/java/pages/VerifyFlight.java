package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public void selectBaggageAndExtras() throws InterruptedException {
        clickElement(nextToSeatSelectionButton);
    }

    public void skipSeatSelection() throws InterruptedException {
        clickElement(skipButton);
    }
}