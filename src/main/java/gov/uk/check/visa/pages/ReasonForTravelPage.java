package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

import java.util.List;

public class ReasonForTravelPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;
    @CacheLookup
    @FindBy(xpath = "//div[@class='govuk-radios']//div")
    List<WebElement> reasonForVisitList;
    public void selectReasonForVisit(String reason){
        List<WebElement> reasonList = reasonForVisitList;
        for (WebElement reason1 : reasonList) {
            if (reason1.getText().equals(reason)) {
                reason1.click();
            }
        }
        Reporter.log("Reason for visit" + reasonForVisitList.toString());
        CustomListeners.test.log(Status.PASS, "Reason for visit");

    }
    public void clickOnContinueButton(){
        CustomListeners.test.log(Status.PASS,"Click on continue button ");
        Reporter.log("Click on continue button" + continueButton.toString());
        clickOnElement(continueButton);
    }
}
