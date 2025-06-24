package utils;

import org.openqa.selenium.WebDriver;

public class TestContext {
    private WebDriver driver;
    private PageObjectManager pageObjectManager;

    public PageObjectManager getPageObjectManager() {
        return pageObjectManager;
    }

    public void setPageObjectManager(PageObjectManager pageObjectManager) {
        this.pageObjectManager = pageObjectManager;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }


}
