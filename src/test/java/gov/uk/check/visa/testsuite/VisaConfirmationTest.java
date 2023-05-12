package gov.uk.check.visa.testsuite;

import gov.uk.check.visa.customlisteners.CustomListeners;
import gov.uk.check.visa.pages.*;
import gov.uk.check.visa.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)

public class VisaConfirmationTest extends BaseTest {
    StartPage startPage;
    WorkTypePage workTypePage;
    SelectNationalityPage selectNationalityPage;
    ResultPage resultPage;
    ReasonForTravelPage reasonForTravelPage;
    FamilyImmigrationStatusPage familyImmigrationStatusPage;
    DurationOfStayPage durationOfStayPage;
    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        startPage = new StartPage();
        workTypePage =new WorkTypePage();
        selectNationalityPage = new SelectNationalityPage();
        resultPage = new ResultPage();
        reasonForTravelPage = new ReasonForTravelPage();
        durationOfStayPage = new DurationOfStayPage();
        familyImmigrationStatusPage = new FamilyImmigrationStatusPage();
    }

    @Test(groups = {"sanity","regression"})
    public void anAustralianComingToUKForTourism(){
        //  Click on start button
        startPage.clickStartNow();

        //Click on accept cookies button
        startPage.clickOnAcceptCookiesButton();

        // Select a Nationality 'Australia'
        selectNationalityPage.selectNationality("Australia");

        // Click on Continue button
        selectNationalityPage.clickOnContinueButton();

        // Select reason 'Tourism'
        reasonForTravelPage.selectReasonForVisit("Tourism or visiting family and friends");

        // Click on Continue button
        reasonForTravelPage.clickOnContinueButton();

        // verify result 'You will not need a visa to come to the UK'
        resultPage.confirmResultMessage("You will not need a visa to come to the UK");

    }

    @Test(groups = {"smoke","regression"})
    public void aChileanComingToTheUKForWorkAndPlansOnStayingForLongerThanSixMonths(){
        // Click on start button
        startPage.clickStartNow();

        // Click on accept cookies button
        startPage.clickOnAcceptCookiesButton();

        // Select a Nationality 'Chile'
        selectNationalityPage.selectNationality("Chile");

        // Click on Continue button
        selectNationalityPage.clickOnContinueButton();

        // Select reason 'Work, academic visit or business'
        reasonForTravelPage.selectReasonForVisit("Work, academic visit or business");

        // Click on Continue button
        reasonForTravelPage.clickOnContinueButton();

        // Select intendent to stay for 'longer than 6 months'
        durationOfStayPage.selectLengthOfStay("more");

        // Click on Continue button
        durationOfStayPage.clickNextStepButton();

        // Select have planning to work for 'Health and care professional'
        workTypePage.selectJobType("Health and care professional");

        // Click on continue button
        workTypePage.clickOnContinueButton();

        // verify result 'You need a visa to work in health and care'
        resultPage.confirmResultMessage("You need a visa to work in health and care");

    }

    @Test(groups = {"regression"})
    public void aColumbianNationalComingToTheUKToJoinAPartnerForALongStayTheyDoHaveAnArticle10Or20Card() {
        // Click on accept cookies button
        startPage.clickOnAcceptCookiesButton();

        // Click on start button
        startPage.clickStartNow();

        // Select a Nationality 'Congo'
        selectNationalityPage.selectNationality("Congo");

        // Click on Continue button
        selectNationalityPage.clickOnContinueButton();

        // Select reason 'Join partner or family for a long stay'
        reasonForTravelPage.selectReasonForVisit("Join partner or family for a long stay");

        // Click on Continue button
        reasonForTravelPage.clickOnContinueButton();

        // Select state My partner of family member have uk immigration status 'yes'
        familyImmigrationStatusPage.selectImmigrationStatus("yes");

        // Click on Continue button
        familyImmigrationStatusPage.clickNextStepButton();

        // verify result 'You’ll need a visa to join your family or partner in the UK'
        resultPage.confirmResultMessage("You’ll need a visa to join your family or partner in the UK");

    }
}
