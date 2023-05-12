package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class FamilyImmigrationStatusPage extends Utility {

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement nextStepButton;
    @CacheLookup
    @FindBy(xpath ="//input[@id='response-0']")
    WebElement yes;
    @CacheLookup
    @FindBy(xpath = "//input[@id='response-1']")
    WebElement no;
    public void selectImmigrationStatus(String yesOrNo){
        switch (yesOrNo.toLowerCase()) {
            case "yes":
                clickOnElement(yes);
                break;
            case "no":
                clickOnElement(no);
                break;
            default:
                System.out.println("Invalid selection. Please enter either 'yes' or 'no'.");

        }

    }
    public void clickNextStepButton(){
        CustomListeners.test.log(Status.PASS,"Click next step button");
        Reporter.log("Click next step button" + nextStepButton.toString());
        clickOnElement(nextStepButton);
    }
}
