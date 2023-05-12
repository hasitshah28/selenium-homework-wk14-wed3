package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class WorkTypePage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(xpath = "//input[@id='response-0']")
    WebElement selectJobTypeList;
    @CacheLookup
    @FindBy(xpath = "//h2[normalize-space()='You need a visa to work in health and care']")
    WebElement resultMessage1;
    public void selectJobType(String job){

        Reporter.log("Select job type" + selectJobTypeList.toString());
        CustomListeners.test.log(Status.PASS, "Select job type");
        clickOnElement(selectJobTypeList);
    }

    public void clickOnContinueButton(){
        CustomListeners.test.log(Status.PASS,"Click next step button ");
        Reporter.log("Click next step button" + nextStepButton.toString());
        clickOnElement(nextStepButton);
    }
    public String getResultMessage1(){
        CustomListeners.test.log(Status.PASS,"Get Result Message1");
        Reporter.log("Get Result Message" + resultMessage1.toString());
        return getTextFromElement(resultMessage1);
    }
}
