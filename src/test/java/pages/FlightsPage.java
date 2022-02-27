package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage extends BasePage {
    WebDriver driver;

    public FlightsPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@data-decider-header='flights']")
    WebElement flights;

    @FindBy(css = "select.css-1k0jlfl")
    WebElement flightClass;

    @FindBy(xpath = "//div[contains(text(), 'adult')]")
    WebElement adultEl;

    @FindBy(css = ".css-153jucu")
    WebElement addAdult;

    @FindBy(css = ".css-1bal7l4 .css-ya5gr9")
    WebElement finishedPassengers;

    public void openFlightsPage() throws InterruptedException {
        clickElement(flights);
    }

    public void selectFlightClass(String classType){
        selectByValue(flightClass,classType);
    }

    public void addAdults() throws InterruptedException {
        clickElement(adultEl);
        clickElement(addAdult);
        clickElement(finishedPassengers);

    }
}
