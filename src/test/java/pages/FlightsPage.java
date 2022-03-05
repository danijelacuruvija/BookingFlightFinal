package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

import static org.testng.Assert.assertTrue;

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

    @FindBy (css = "[data-testid='flight_card_bound_select_flight']")
    List <WebElement> seeFlightButton;

    @FindBy (css = "[data-testid='flight_details_inner_modal_select_button']")
    WebElement  selectChosenFlight;


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
        //clickElement(returnBtn);
        //Thread.sleep(1000);
        clickElement(driver.findElement(By.xpath("//span[@data-date-cell='" + returnDate + "']")));
    }


    public void clickSearch() throws InterruptedException {
        clickElement(clickSearchButton);
        Thread.sleep(3000);
    }

    public void chooseFlightTime(String time) throws InterruptedException {
        clickElement(driver.findElement(By.xpath("//div[contains(text(), 'Departs')]//..//..//div[contains(text(),'"+time+"')]//..//..//span")));
        Thread.sleep(1000);
    }

    public void selectFlight() throws InterruptedException {
        clickElement(seeFlightButton.get(0));
    }

    public void verifyDestination(String checkCity){
        String titleCity = driver.findElement(By.cssSelector("#__bui-41-title")).getText();
        assertTrue(titleCity.contains(checkCity));
    }

    public void chooseSelectedFlight() throws InterruptedException {
        clickElement(selectChosenFlight);

    }

}

