package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaSellTradePage {
    public CarvanaSellTradePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div.sc-7ed29b82-1>div:nth-child(2)")
    public WebElement getARealOfferIn2MinsText;

    @FindBy(css = "div.sc-4ef54ea5-17")
    public WebElement wePickUpYourCarText;

    @FindBy(css = "button[data-cv-test='VINToggle']")
    public WebElement VINButton;

    @FindBy(css = "input[aria-labelledby='VIN']")
    public WebElement VINInputBox;

    @FindBy(css = "button[data-cv-test='heroGetMyOfferButton']")
    public WebElement getMyOfferButton;

    @FindBy(css = "div.kjoUgV")
    public WebElement VINErrorMessage;
}
