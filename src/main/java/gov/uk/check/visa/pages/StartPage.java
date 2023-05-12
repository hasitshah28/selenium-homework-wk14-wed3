package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class StartPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Accept additional cookies']")
    WebElement acceptCookiesButton;
    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Start now']")
    WebElement startNowButton;
    public void clickStartNow(){
        CustomListeners.test.log(Status.PASS,"Click on start button ");
        Reporter.log("Click on start button" + startNowButton.toString());
        clickOnElement(startNowButton);
    }
    public void clickOnAcceptCookiesButton(){
        CustomListeners.test.log(Status.PASS,"Click on accept cookies button ");
        Reporter.log("Click on accept cookies button" + acceptCookiesButton.toString());
        clickOnElement(acceptCookiesButton);
    }

}
