package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class SearchConsolePage {

    WebDriver driver;
    private final By txtJobTitle = By.id("keyword");
    private final By txtJobLocation = By.id("location");
    private final By btnSearch = By.id("search");
    private final By btnClear = By.id("clearFilters");
    private final By linkMoreSearch = By.id("searchOptionsBtn");
    private final By btnRejectCookies = By.id("reject-cookies");
    private final By btnAcceptCookies = By.id("accept-cookies");
    private final By ddDistance = By.id("distance");
    private final By txtJobRef = By.id("jobReference");
    private final By txtEmployer = By.id("employer");
    private final By ddPayRange = By.id("payRange");
    private final By lnklanguage = By.xpath("//a[@lang='cy']");
    private final By labelJobTitle = By.id("keyword-label");
    private final By labelJobLocation = By.id("location-label");
    private final By labelDistance = By.id("distance-label");
    private final By labelJobTitleHint = By.id("keyword-hint");
    private final By labelJobLocationHint = By.id("location-hint");
    private final By labelDistanceHint = By.id("distance-hint");
    private final By labelHeading = By.xpath("//*[@id='heading']/h1");

    public SearchConsolePage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getJobTitle() {
        return driver.findElement(txtJobTitle);
    }

    public WebElement getJobLocation() {
        return driver.findElement(txtJobLocation);
    }

    public WebElement getSearchButtonID() {
        return driver.findElement(btnSearch);
    }

    public WebElement getClearButtonID() {
        return driver.findElement(btnClear);
    }

    public WebElement getRejectCookies() {
        return driver.findElement(btnRejectCookies);
    }

    public WebElement getAcceptCookies() {
        return driver.findElement(btnAcceptCookies);
    }

    public WebElement getDistance() {
        return driver.findElement(ddDistance);
    }

    public WebElement getJobRef() {
        return driver.findElement(txtJobRef);
    }

    public WebElement getEmp() {
        return driver.findElement(txtEmployer);
    }

    public WebElement getPay() {
        return driver.findElement(ddPayRange);
    }

    public WebElement getSearchOptionslink() {
        return driver.findElement(linkMoreSearch);
    }

    public WebElement getChangeLanguage() {
        return driver.findElement(lnklanguage);
    }

    public WebElement getLabelJobLocation() {
        return driver.findElement(labelJobLocation);
    }

    public WebElement getLabelJobTitle() {
        return driver.findElement(labelJobTitle);
    }

    public WebElement getLabelDistance() {
        return driver.findElement(labelDistance);
    }

    public WebElement getLabelJobTitleHint() {
        return driver.findElement(labelJobTitleHint);
    }

    public WebElement getLabelJobLocationHint() {
        return driver.findElement(labelJobLocationHint);
    }

    public WebElement getLabelDistanceHint() {
        return driver.findElement(labelDistanceHint);
    }

    public WebElement getLabelHeading() {
        return driver.findElement(labelHeading);
    }


}
