package steps;

import cucumber.api.java.Before;
import cucumber.api.java.de.Aber;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CarvanaHomePage;
import utils.Driver;
import utils.DropdownHandler;
import utils.Waiter;

public class BaseSteps {

    WebDriver driver;
    CarvanaHomePage carvanaHomePage;

    @Before
    public void setup(){
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
    }

    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String linkText) {
        switch (linkText) {
            case "CAR FINDER":
                carvanaHomePage.carFinderLink.click();
                break;
            case "SELL/TRADE":
                Waiter.waitForVisibilityOfElement(driver,carvanaHomePage.carFinderLink,10);
                carvanaHomePage.sellTradeLink.click();
                break;
            case "AUTO LOAN CALCULATOR":
               carvanaHomePage.autoLoanCalculatorLink.click();
                break;
        }
    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Assert.assertEquals(url, driver.getCurrentUrl());
    }
}
