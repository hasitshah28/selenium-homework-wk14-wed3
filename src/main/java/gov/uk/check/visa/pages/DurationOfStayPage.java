package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class DurationOfStayPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(id = "response-0")
    WebElement lessThanSixMonths;
    @CacheLookup
    @FindBy(id="response-1")
    WebElement moreThanSixMonths;

    public void selectLengthOfStay(String moreOrLess) {
        switch (moreOrLess.toLowerCase()) {
            case "more":
                clickOnElement(moreThanSixMonths);
                break;
            case "less":
                clickOnElement(lessThanSixMonths);
                break;
            default:
                System.out.println("Invalid selection. Please enter either 'more' or 'less'.");

        }
    }

    public void clickNextStepButton(){
        CustomListeners.test.log(Status.PASS,"Click on next step button");
        Reporter.log("Click on next step button" + nextStepButton.toString());
        clickOnElement(nextStepButton);
    }

 }
