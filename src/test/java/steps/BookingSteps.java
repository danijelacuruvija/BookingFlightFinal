package steps;

import excell_core.ExcelUtilities;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import pages.FlightsPage;
import pages.PassengersDetails;
import pages.TicketDetails;
import tests.BaseTest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class BookingSteps extends BaseTest {

    String BROWSER = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("BROWSER");
    String WAIT = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("WAIT");
    String ENV = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("ENV");

    Map<String, String> data;
    String testDataPath = "src/test/test_data/";

    @Before
    public void setUp() throws Exception {
        setUPTest(BROWSER, Integer.parseInt(WAIT));
    }

    @After
    public void tearDown() throws IOException, InterruptedException {
        reportScreenshot("end", "screenshot on end or fail");
        quit();
    }

    @Given("I load test data from {string} {string} {string}")
    public void iLoadTestDataFrom(String fileName, String sheetName, String rowNum) throws IOException {
        ExcelUtilities excelUtilities = new ExcelUtilities();
        data = excelUtilities.getRowData(testDataPath + fileName + ".xlsx", sheetName, rowNum);
        System.out.println(data.get("Location"));
    }

    @Given("I navigate to Booking")
    public void iNavigateToBooking() throws Exception {
        startApplication(ENV);
    }

    @Then("I navigate to flights page")
    public void iNavigateToFlightsPage() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver); //ovo kreiram iznova da bih mogla da koristim metode iz Flights page-a
        flightsPage.openFlightsPage();
    }

    @And("I select flight class {string}")
    public void iSelectFlightClass(String classType) {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectFlightClass(classType);
    }


    @And("I select number of passengers")
    public void iSelectNumberOfPassengers() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addAdults();

    }

    @And("I add destination {string}")
    public void iAddDestination(String city) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.addDestination(city);
    }

    @And("I add depart and return date {string} {string}")
    public void iAddDepartAndReturnDate(String departDate, String returnDate) throws InterruptedException {
       FlightsPage flightsPage = new FlightsPage(driver);
      flightsPage.selectDepartAndReturnDate(departDate,returnDate);
    }

    @And("I click search")
    public void iClickSearch() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.clickSearch();

    }

    @Then("I choose flight time {string}")
    public void iChooseFlightTime(String time) throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.chooseFlightTime(time);
    }

    @And("I select flight")
    public void iSelectFlight() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.selectFlight();
    }

    @Then("I verify that flight is to selected destination {string}")
    public void iVerifyThatFlightIsToSelectedDestination(String checkCity) {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.verifyDestination(checkCity);
    }


    @Then("I choose selected flight")
    public void iChooseSelectedFlight() throws InterruptedException {
        FlightsPage flightsPage = new FlightsPage(driver);
        flightsPage.chooseSelectedFlight();
    }


    @Then("I select ticket details")
    public void iSelectTicketDetails() throws InterruptedException {
        TicketDetails ticketDetails = new TicketDetails(driver);
        ticketDetails.checkTicketType();

    }

    @Then("I enter contact data {string}")
    public void iEnterContactData(String countryCodeValue) {
        PassengersDetails passengersDetails = new PassengersDetails(driver);
        passengersDetails.enterEmail();
        passengersDetails.enterCountyCode(countryCodeValue);
        passengersDetails.enterPhoneNumber();
    }

    @Then("I enter passenger data {string}")
    public void iEnterPassengerData(String numOfPassengers) {
        PassengersDetails passengersDetails = new PassengersDetails(driver);

    }
}


    ////    @Then("I choose flight type")
////    public void iChooseFlightType() throws InterruptedException {
////        FlightsPage flightsPage = new FlightsPage(driver);
////        flightsPage.selectFlightType();
//    }









