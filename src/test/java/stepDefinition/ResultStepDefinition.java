package stepDefinition;

import io.cucumber.java.en.And;
import org.openqa.selenium.WebElement;
import utils.CommonUtil;
import utils.TestContext;
import io.cucumber.java.en.Then;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class ResultStepDefinition extends BaseStep {
    TestContext testContext;

    public ResultStepDefinition(TestContext testContext) {
        super(testContext);
        this.testContext = testContext;
    }


    @Then("Verify that Jobseeker should be able to see the list of jobs based on {string} keyword")
    public void enterTextInJobTitleField(String keyword) throws IOException {
        try {
            assertTrue(getResultPage().getResultTitle().getText().contains(keyword));
        } catch (Exception e) {
            CommonUtil.getScreenshot(testContext.getDriver(), "enterTextInJobTitleField");
        }

    }

    @And("Sort the result with {string}")
    public void sortTheResultWith(String value) {
        CommonUtil.selectByVisibleText(getResultPage().getSortDropdown(), value);
    }

    @And("List down all job title in the first page for {string} keyword")
    public void listAllTheJobTitle(String keyword) throws IOException {
        System.out.println("List of Top 10 jobs after sorted with newest date for "+ keyword+ " title");
        List<WebElement> elementList = getResultPage().getResultdata();
        for (WebElement element : elementList) {
            System.out.println(element.getText());
        }
        CommonUtil.zoomOut(testContext.getDriver(),0.2);
        CommonUtil.getScreenshot(testContext.getDriver(),"listFirstPageoOf"+keyword+"JobTitle");
    }
}