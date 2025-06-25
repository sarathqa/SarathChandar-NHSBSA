package stepDefinition;

import pageObject.ResultPage;
import pageObject.SearchConsolePage;
import utils.TestContext;

public class BaseStep extends TestContext {

    TestContext testContext;

    BaseStep(TestContext context){

        this.testContext=context;
    }

    public SearchConsolePage getSearchConsolePage(){
        return testContext.getPageObjectManager().getSearchConsolePage();
    }

    public ResultPage getResultPage(){
        return testContext.getPageObjectManager().getResultPage();
    }

}
