package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ResultPage {

    WebDriver driver;
    private final By txtheading = By.id("search-results-heading");
    private final By ddSort = By.id("sort");
    private final By txtdata = By.xpath("//ul[@class='nhsuk-list search-results']/li/div//h2[contains(@id,'job-title')]/a");

    public ResultPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getResultTitle() {
        return driver.findElement(txtheading);
    }

    public WebElement getSortDropdown() {
        return driver.findElement(ddSort);
    }

    public List<WebElement> getResultdata() {
        return driver.findElements(txtdata);
    }


}
