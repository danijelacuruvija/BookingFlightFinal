package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(css = "[data-testid='searchbox_destination']")
    WebElement clickToAddDestination;

    @FindBy(css = "[data-testid='searchbox_destination_input']")
    WebElement clickToTypeCity;

    @FindBy(css = ".css-bwf0ll")
    WebElement checkToSelectDestination;

    @FindBy(css = ".css-hboir5")
    WebElement selectDestination;

    @FindBy(xpath = "//input[@placeholder='Depart']")
    WebElement departBtn;

    @FindBy(xpath = "//input[@placeholder='Return']")
    WebElement returnBtn;

    @FindBy(css = "[data-testid='searchbox_submit' ]")
    WebElement clickSearchButton;


    public void openFlightsPage() throws InterruptedException {
        clickElement(flights);
    }

    public void selectFlightClass(String classType) {
        selectByValue(flightClass, classType);
    }

    public void addAdults() throws InterruptedException {
        clickElement(adultEl);
        clickElement(addAdult);
        clickElement(finishedPassengers);

    }

    public void addDestination(String city) throws InterruptedException {
        clickElement(clickToAddDestination);
        inputElement(clickToTypeCity, city);
        //clickElement(checkToSelectDestination);
        clickElement(selectDestination);
    }

    public void selectDepartAndReturnDate(String departDate, String returnDate) throws InterruptedException {
        clickElement(departBtn);
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell='" + departDate + "']")));
        clickElement(returnBtn);
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell='" + returnDate + "']")));
    }


    public void clickSearch() throws InterruptedException {
        clickElement(clickSearchButton);
        Thread.sleep(3000);
    }

    public void chooseFlightTime(String time) throws InterruptedException {
        List<WebElement> flightTime = driver.findElements(By.xpath("//*[contains(text(),'" + time + "')]"));
        clickElement(flightTime.get(0));
        Thread.sleep(1000);
    }

}

