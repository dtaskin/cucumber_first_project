package pages;

import com.gargoylesoftware.htmlunit.Page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaCarFinderPage {
    public CarvanaCarFinderPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "div.leftSide>h1")
    public WebElement whatCarShouldIGetText;

    @FindBy(css = "div.leftSide>h3")
    public WebElement carFinderCanHelpText;

    @FindBy(css = "a[data-qa='router-link']")
    public WebElement tryCarFinderLink;

    @FindBy(css = ".styles__Headline-sc-1z43k2-1")
    public WebElement whatIsMostImportantText;

    @FindBy(css = "div[data-qa='sub-heading']")
    public WebElement selectUpTo4Text;


}
