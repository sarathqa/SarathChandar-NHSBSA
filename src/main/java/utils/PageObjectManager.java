package utils;

import pageObject.ResultPage;
import pageObject.SearchConsolePage;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
    private WebDriver driver;
    private ResultPage resultPage;
    private SearchConsolePage searchConsolePage;

    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }

    public ResultPage getResultPage() {
        return (resultPage == null) ? resultPage = new ResultPage(driver) : resultPage;
    }

    public SearchConsolePage getSearchConsolePage() {
        return (searchConsolePage == null) ? searchConsolePage = new SearchConsolePage(driver) : searchConsolePage;
    }
}
