package steps;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CarvanaAutoLoanCalculatorPage;
import pages.CarvanaCarFinderPage;
import pages.CarvanaHomePage;
import pages.CarvanaSellTradePage;
import utils.Driver;
import utils.DropdownHandler;
import utils.Waiter;

public class CarvanaSteps {

    WebDriver driver;
    WebDriverWait explicitWait;
    CarvanaHomePage carvanaHomePage;
    CarvanaCarFinderPage carvanaCarFinderPage;
    CarvanaSellTradePage carvanaSellTradePage;
    CarvanaAutoLoanCalculatorPage carvanaAutoLoanCalculatorPage;

    @Before
    public void setup() {
        driver = Driver.getDriver();
        carvanaHomePage = new CarvanaHomePage();
        carvanaCarFinderPage = new CarvanaCarFinderPage();
        carvanaSellTradePage = new CarvanaSellTradePage();
        carvanaAutoLoanCalculatorPage = new CarvanaAutoLoanCalculatorPage();
        explicitWait = new WebDriverWait(driver, 15);

    }


    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text) {
            case "WHAT CAR SHOULD I GET?":
                Assert.assertEquals(text, carvanaCarFinderPage.whatCarShouldIGetText.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertEquals(text, carvanaCarFinderPage.carFinderCanHelpText.getText());
                break;
            case "TRY CAR FINDER":
                Assert.assertEquals(text, carvanaCarFinderPage.tryCarFinderLink.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertEquals(text, carvanaCarFinderPage.whatIsMostImportantText.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertEquals(text, carvanaCarFinderPage.selectUpTo4Text.getText());
                break;
            case "GET A REAL OFFER IN 2 MINUTES":
                Assert.assertEquals(text, carvanaSellTradePage.getARealOfferIn2MinsText.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertEquals(text, carvanaSellTradePage.wePickUpYourCarText.getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Waiter.waitForVisibilityOfElement(driver, carvanaSellTradePage.VINErrorMessage, 15);
                Assert.assertEquals(text, carvanaSellTradePage.VINErrorMessage.getText());
                break;


        }

    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String linkText) {
        Assert.assertEquals(linkText, carvanaCarFinderPage.tryCarFinderLink.getText());
    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String link) {
        carvanaCarFinderPage.tryCarFinderLink.click();
    }

    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button) {
            case "VIN":
                carvanaSellTradePage.VINButton.click();
                break;
            case "GET MY OFFER":
                carvanaSellTradePage.getMyOfferButton.click();
                break;
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String key) {
        carvanaSellTradePage.VINInputBox.sendKeys("00000000000000000");
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String link) {
        Waiter.waitForVisibilityOfElement(driver,carvanaHomePage.carFinderLink,5);
        Actions actions = new Actions(driver);
        actions.moveToElement(carvanaHomePage.financingDropdown).perform();

    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String text, String value) {
        switch (text) {
            case "Cost of Car I want":
                carvanaAutoLoanCalculatorPage.costInputBox.sendKeys(value);
                break;
            case "What is Your Down Payment?":
                carvanaAutoLoanCalculatorPage.downPaymentInputBox.sendKeys(value);
                break;
        }
    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String text, String selection) {
        switch (text){
            case "What’s Your credit Score?":
                DropdownHandler.selectOptionByVisibleText(carvanaAutoLoanCalculatorPage.creditScoreDropdown,selection);
                break;
            case "Choose Your Loan Terms":
                DropdownHandler.selectOptionByVisibleText(carvanaAutoLoanCalculatorPage.loanTermsDropdown,selection);
                break;
        }
    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String text) {
        Assert.assertEquals(carvanaAutoLoanCalculatorPage.monthlyPaymentDisplayValue.getText(), text);
    }
}
