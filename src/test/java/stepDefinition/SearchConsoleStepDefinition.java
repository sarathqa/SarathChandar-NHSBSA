package stepDefinition;

import io.cucumber.java.en.Then;
import org.openqa.selenium.WebElement;
import utils.CommonUtil;
import utils.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class SearchConsoleStepDefinition {

    TestContext testContext;

    public SearchConsoleStepDefinition(TestContext testContext) {
        this.testContext = testContext;

    }

    @Given("JobSeeker landed on NHS Job Portal")
    public void jobseekerLandedOnNHSJobPortal() throws IOException {
        testContext.getDriver().get(CommonUtil.getDataFromProp("Config", "url"));
        testContext.getPageObjectManager().getSearchConsolePage().getRejectCookies().click();
    }

    @And("Enter {string} keyword in the Job Title field")
    public void enterTextInJobTitleField(String keyword) throws InterruptedException {
        CommonUtil.explicitWait(testContext.getDriver(), testContext.getPageObjectManager().getSearchConsolePage().getJobTitle());
        testContext.getPageObjectManager().getSearchConsolePage().getJobTitle().click();
        testContext.getPageObjectManager().getSearchConsolePage().getJobTitle().sendKeys(keyword);

    }

    @And("Click search button")
    public void clickButton() {
        testContext.getPageObjectManager().getSearchConsolePage().getSearchButtonID().click();

    }

    @Given("Enter {string} keyword in the Job location field")
    public void enter_keyword_in_the_job_location_field(String location) throws InterruptedException {
        CommonUtil.explicitWait(testContext.getDriver(), testContext.getPageObjectManager().getSearchConsolePage().getJobLocation());
        testContext.getPageObjectManager().getSearchConsolePage().getJobLocation().click();
        testContext.getPageObjectManager().getSearchConsolePage().getJobLocation().sendKeys(location);
    }


    @Then("Verify that distance drop down should be {string}")
    public void verifyThatDistanceDropDownShouldBeEnabled(String data) throws IOException {
        try {
            if (data.equalsIgnoreCase("enabled")) {
                assertTrue(testContext.getPageObjectManager().getSearchConsolePage().getDistance().isEnabled());
            } else {
                assertFalse(testContext.getPageObjectManager().getSearchConsolePage().getDistance().isEnabled());
            }
        } catch (Exception e) {
            CommonUtil.getScreenshot(testContext.getDriver(),"DistanceDropdown");
        }
    }


    @And("Select {string} distance")
    public void selectDistance(String distance) {
        CommonUtil.selectByVisibleText(testContext.getPageObjectManager().getSearchConsolePage().getDistance(), distance);
    }

    @And("Click clear button")
    public void clickClearButton() {
        testContext.getPageObjectManager().getSearchConsolePage().getClearButtonID().click();
    }

    @Then("Verify that entered value should not be displayed in Job Title field")
    public void verifyThatValueShouldNotBeDisplayedInJobTitleField() throws IOException {
        try {
            assertTrue(testContext.getPageObjectManager().getSearchConsolePage().getJobTitle().getAttribute("value").isEmpty());
        } catch (Exception e) {
            CommonUtil.getScreenshot(testContext.getDriver(),"JobTitleFieldAfterReset");
        }

    }

    @Then("Verify that entered value should not be displayed in Job Location field")
    public void verifyThatValueShouldNotBeDisplayedInJobLocField() throws IOException {
        try {
            assertTrue(testContext.getPageObjectManager().getSearchConsolePage().getJobLocation().getAttribute("value").isEmpty());
        } catch (Exception e) {
            CommonUtil.getScreenshot(testContext.getDriver(),"JobLocationFieldAfterReset");
        }

    }

    @And("Click More Search options link")
    public void clickMoreSearchOptionsLink() {
        CommonUtil.explicitWaitElementClick(testContext.getDriver(),  testContext.getPageObjectManager().getSearchConsolePage().getSearchOptionslink());
        testContext.getPageObjectManager().getSearchConsolePage().getSearchOptionslink().click();
    }

    @Then("Verify that Job Reference, Employer and Pay fields should be displayed and enabled")
    public void verifyThatNewFieldShouldBeDisplayedAndEnabled() throws IOException {
        try {
            CommonUtil.explicitWait(testContext.getDriver(),testContext.getPageObjectManager().getSearchConsolePage().getJobRef());
            assertTrue(testContext.getPageObjectManager().getSearchConsolePage().getJobRef().isDisplayed());
            assertTrue(testContext.getPageObjectManager().getSearchConsolePage().getEmp().isDisplayed());
            assertTrue(testContext.getPageObjectManager().getSearchConsolePage().getPay().isDisplayed());
            assertTrue(testContext.getPageObjectManager().getSearchConsolePage().getJobRef().isEnabled());
            assertTrue(testContext.getPageObjectManager().getSearchConsolePage().getEmp().isEnabled());
            assertTrue(testContext.getPageObjectManager().getSearchConsolePage().getPay().isEnabled());
        } catch (Exception e) {
             CommonUtil.getScreenshot(testContext.getDriver(),"FieldAfterClickMoreSearchOption");
        }

    }

    @And("Enter {string} keyword in the Employer field")
    public void enterKeywordInTheEmployerField(String keyword) {
        CommonUtil.explicitWait(testContext.getDriver(),testContext.getPageObjectManager().getSearchConsolePage().getEmp());
        testContext.getPageObjectManager().getSearchConsolePage().getEmp().sendKeys(keyword);
    }

    @And("Select {string} in the Pay Range field")
    public void selectInThePayRangeField(String value) {
        CommonUtil.selectByVisibleText(testContext.getPageObjectManager().getSearchConsolePage().getPay(), value);
    }

    @And("Click Cymraeg language")
    public void clickCymraegLanguage() {
        CommonUtil.explicitWaitElementClick(testContext.getDriver(), testContext.getPageObjectManager().getSearchConsolePage().getChangeLanguage());
        testContext.getPageObjectManager().getSearchConsolePage().getChangeLanguage().click();

    }

    @Then("Verify that Label name of Job Reference, Job Location and distance should be displayed in Cymraeg")
    public void verifyThatLabelNameOfJobReferenceJobLocationAndDistanceShouldBeDisplayedInCymraeg() throws IOException {
        CommonUtil.explicitWait(testContext.getDriver(),testContext.getPageObjectManager().getSearchConsolePage().getLabelJobTitle());
        assertEquals(CommonUtil.getDataFromProp("Cymraeglang", "JobTitleLabel"), testContext.getPageObjectManager().getSearchConsolePage().getLabelJobTitle().getText());
        assertEquals(CommonUtil.getDataFromProp("Cymraeglang", "JobLocLabel"), testContext.getPageObjectManager().getSearchConsolePage().getLabelJobLocation().getText());
        assertEquals(CommonUtil.getDataFromProp("Cymraeglang", "DistanceLabel"), testContext.getPageObjectManager().getSearchConsolePage().getLabelDistance().getText());
        assertEquals(CommonUtil.getDataFromProp("Cymraeglang", "Heading"), testContext.getPageObjectManager().getSearchConsolePage().getLabelHeading().getText());
        assertEquals(CommonUtil.getDataFromProp("Cymraeglang", "JobTitleHint"), testContext.getPageObjectManager().getSearchConsolePage().getLabelJobTitleHint().getText());
        assertEquals(CommonUtil.getDataFromProp("Cymraeglang", "JobLocHint"), testContext.getPageObjectManager().getSearchConsolePage().getLabelJobLocationHint().getText());
        assertEquals(CommonUtil.getDataFromProp("Cymraeglang", "JobDistanceHint"), testContext.getPageObjectManager().getSearchConsolePage().getLabelDistanceHint().getText());
        CommonUtil.getScreenshot(testContext.getDriver(), "LabelNameInCymraegLanguage");
    }

    @Then("Verify the drop down values from Job Distance")
    public void verifyTheDropDownValuesFromJobDistance() throws IOException {
        List<WebElement> elementList = CommonUtil.getAllValuesFromDropdown(testContext.getPageObjectManager().getSearchConsolePage().getDistance());
        String[] expectedValue = {"+5 Miles", "+10 Miles", "+20 Miles", "+30 Miles", "+50 Miles", "+100 Miles", "All locations"};
        String[] actualValue = new String[elementList.size()];
        for (int i = 0; i < elementList.size(); i++) {
            actualValue[i] = elementList.get(i).getText();
        }

        try {
            assertArrayEquals(expectedValue, actualValue);
        } catch (Exception e) {
            CommonUtil.getScreenshot(testContext.getDriver(), "verifyTheDropDownValuesFromJobDistance");
        }

    }
}
