package gov.uk.check.visa.pages;

import com.aventstack.extentreports.Status;
import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class SelectNationalityPage extends Utility {
    @CacheLookup
    @FindBy(id = "response")
    WebElement nationalityDropDownList;
    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Continue']")
    WebElement continueButton;
    public void selectNationality(String nationality){
        CustomListeners.test.log(Status.PASS,"Select Nationality ");
        Reporter.log("Select Nationality" + nationalityDropDownList.toString());
        selectByVisibleTextFromDropDown(nationalityDropDownList,nationality);
    }
    public void clickOnContinueButton(){
        CustomListeners.test.log(Status.PASS,"Click on next step button ");
        Reporter.log("Click on next step button" + continueButton.toString());
        clickOnElement(continueButton);
    }

}
