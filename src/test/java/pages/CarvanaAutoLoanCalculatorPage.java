package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;

public class CarvanaAutoLoanCalculatorPage {
    public CarvanaAutoLoanCalculatorPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "input[name='vehiclePrice']")
    public WebElement costInputBox;

    @FindBy(id = "creditBlock")
    public WebElement creditScoreDropdown;

    @FindBy(css = "select[name='loanTerm']")
    public WebElement loanTermsDropdown;

    @FindBy(css = "input[name='downPayment']")
    public WebElement downPaymentInputBox;

    @FindBy(css = "div.loan-calculator-display-value")
    public WebElement monthlyPaymentDisplayValue;

}
