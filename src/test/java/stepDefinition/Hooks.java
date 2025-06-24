package stepDefinition;

import io.cucumber.java.BeforeAll;
import org.apache.commons.io.FileUtils;
import utils.DriverFactory;
import utils.PageObjectManager;
import utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Hooks {

    private TestContext testContext;

    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @BeforeAll
    public static void before_or_after_all() throws IOException {
        try {
            FileUtils.cleanDirectory(new File(System.getProperty("user.dir") + "/target/screenshot"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Before
    public void setUp() throws IOException {
        WebDriver driver = DriverFactory.initDriver();
        testContext.setDriver(driver);
        testContext.setPageObjectManager(new PageObjectManager(driver));

    }

    @After
    public void tearDown() {
        testContext.getDriver().quit();
    }


}
