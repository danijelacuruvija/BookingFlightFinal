package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class TicketDetails extends BasePage {
        WebDriver driver;

        public TicketDetails(WebDriver driver) {
            super(driver);
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }


    @FindBy(css="span.InputRadio-module__field___16hZ8")
    List<WebElement> ticketTypes;
    @FindBy (css="div[data-testid='checkout_ticket_type_inner_next']")
    WebElement nextButton;

    public void checkTicketType() throws InterruptedException{
        clickElement(ticketTypes.get(0));
        clickElement(nextButton);
    }


    }
